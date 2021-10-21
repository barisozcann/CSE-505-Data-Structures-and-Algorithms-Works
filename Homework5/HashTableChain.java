import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.function.Consumer;
import java.util.Random;

public class HashTableChain<K, V> implements KWHashMap<K, V> {

    /**
     * This is entry class that consist of key and value
     * @param <K> is key
     * @param <V> is value
     */

    private static class Entry<K, V> { //Inner Class Entry

        private final K key; //Key
        private V value; //Value

        public Entry(K key, V value) { //Entry Class Constructor Method
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public V setvalue(V val) {
            V oldvalue = value;
            value = val;
            return oldvalue;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    /**
     * This class is map iterator. It iterates through null elements to reach non-null elements
     */
    public class MapIterator{
        //data fields
        private K nextItem; //reference to next item
        private K lastItemReturned; //reference to last item returned
        private LinkedList<Entry<K, V>> iteratorLinkedList;
        private int index = 0; //Index of next item
        private int lastItemIndex=0; //Index of last item

        /**
         * Map Iterator zero parameter constructor method
         */
        public MapIterator(){
            if(numkeys==0){ //Empyt HashTable Case
                nextItem=null;
                lastItemReturned=null;
                index=0;
                lastItemIndex=0;
            }
            else{
                Random rnd = new Random(); //Random number generator
                int randomIndex=rnd.nextInt(capacity);
                iteratorLinkedList=table[randomIndex]; //LinkedList is equal to random element of array
                while(iteratorLinkedList==null){ //If linkedlist is null, continue to generate random indexes
                    randomIndex=rnd.nextInt(capacity);
                    iteratorLinkedList=table[randomIndex];
                }
                index=randomIndex; //Finally it founds an index that contains a linked list
                nextItem=iteratorLinkedList.get(0).getKey();
                if(hasPrev()==false){ //If random reached elements is the first element, this block works
                    lastItemIndex=0;
                    lastItemReturned=null;
                }
                else{
                    lastItemIndex=randomIndex-1;
                    iteratorLinkedList=table[lastItemIndex];
                    while(iteratorLinkedList==null){ //This loop finds previous element of random element in array
                        lastItemIndex--;
                        iteratorLinkedList=table[lastItemIndex];
                    }
                    lastItemReturned=iteratorLinkedList.get(0).getKey();
                }

            }

        }

        /**
         * Map Iterator Constructor with a key
         * @param key
         */
        public MapIterator(K key){
            index = hash(key, table.length);
            iteratorLinkedList=table[index];
            nextItem=iteratorLinkedList.get(0).getKey();
            if(hasPrev()==false){ //If key is the first element, this block works
                lastItemIndex=0;
                lastItemReturned=null;
            }
            else {
                int tempIndex = index;
                tempIndex--;
                iteratorLinkedList = table[tempIndex];
                while (iteratorLinkedList == null) { //This loop helps to find previous element of next item
                    tempIndex--;
                    iteratorLinkedList = table[tempIndex];
                }
                lastItemReturned = iteratorLinkedList.get(0).getKey();
            }
        }


        /**
         * This method tries to reach next element by using while loop
         * while loop continues to iterate until it finds a non-null element
         * If hasNext==false this method starts from beginning of the array
         * @return key
         */

        public K next(){
            if(hasNext()==false){
                index=0;
                lastItemReturned=null;
                iteratorLinkedList=table[index];
                while(iteratorLinkedList==null){
                    index++;
                    iteratorLinkedList=table[index];
                }
                nextItem=iteratorLinkedList.get(0).getKey();
                return nextItem;
            }
            lastItemReturned=nextItem;
            lastItemIndex=index;

            index++;
            iteratorLinkedList=table[index];
            while(iteratorLinkedList==null){
                index++;
                iteratorLinkedList=table[index];
            }
            nextItem=iteratorLinkedList.get(0).getKey();
            //System.out.println("Next item: "+nextItem.toString());
            //System.out.println("Last item: "+lastItemReturned.toString());
            return nextItem;
        }

        /**
         * This method tries to reach previous element by using while loop
         * while loop continues to iterate until it finds a non-null element
         * If hasPrevious==false this method stops at the first element of array
         * @return key
         */
        public K prev() {
            if(hasPrev()==false){
                System.out.println("You are at first key");
                index=lastItemIndex;
                nextItem=lastItemReturned;
                return nextItem;
            }
            nextItem=lastItemReturned;
            index=lastItemIndex;
            lastItemIndex--;
            iteratorLinkedList=table[lastItemIndex];
            while(iteratorLinkedList==null){
                lastItemIndex--;
                iteratorLinkedList=table[lastItemIndex];
            }
            lastItemReturned=iteratorLinkedList.get(0).getKey();
            return nextItem;

        }


        /**
         * This method checks if there is a non-null element until the end of the Array
         * If it detects a non-null element, it returns true
         * @return boolean
         */
        public boolean hasNext() {
            int tempIndex=index;
            tempIndex++;
            if (tempIndex>=table.length)
                return false;

            iteratorLinkedList=table[tempIndex];
            if(iteratorLinkedList!=null)
                return true;
            else{
                while(iteratorLinkedList==null){
                    tempIndex++;
                    if(tempIndex>=table.length)
                        return false;
                    iteratorLinkedList=table[tempIndex];
                    if(iteratorLinkedList!=null)
                        return true;
                }
            }
            return false;
        }

        /**
         * This method checks if there is a non-null element until the beginning of the array
         * If it detects a non-null element, it returns true
         * @return boolean
         */
        public boolean hasPrev() {
            int tempIndex=lastItemIndex;
            tempIndex--;
            if(tempIndex<0)
                return false;
            iteratorLinkedList=table[tempIndex];
            if(iteratorLinkedList!=null)
                return true;

            while(iteratorLinkedList==null){
                tempIndex--;
                if(tempIndex<0)
                    return false;
                iteratorLinkedList=table[tempIndex];
            }
            return true;
        }
    }

    //the table
    protected LinkedList<Entry<K, V>>[] table; //Array that contains linkedlists
    //the no.of keys inserted should be increamented
    public int numkeys = 0;
    //the initial capacity of table
    public int capacity = 30;
    //maximum load factor
    public double loadThreshold = 5.0;
    public int collisions = 0;
    public double avgChainLength = 0.0;
    public int maxChainLength = 0;
    public MapIterator myMapIterator;


    /**
     * HashTableChain constructor with zero parameter
     */
    public HashTableChain() {
        this.table = new LinkedList[capacity];
    }

    /**
     * HashTableChain constructor with capacity and load
     * @param capacity
     * @param load
     */
    public HashTableChain(int capacity, double load) { //HashTableChain Constructor Method
        this.table = new LinkedList[capacity];
        this.loadThreshold = load;
        this.capacity = capacity;
    }

    /**
     * This method constructs MapIterator with zero parameter(delegation)
     */

    public void iteratorConstructor(){
        myMapIterator=new MapIterator();
    }

    /**
     * This method uses the inner class called MapIterator
     * So this method delegates next() method of MapIterator (delegation)
     * @return key
     */
    public K next(){
        return myMapIterator.next();
    }


    /**
     * Overloading
     * This method constructs MapIterator with a key parameter(delegation again)
     * @param key
     * @return
     */
    public void iteratorConstructor(K key){
        myMapIterator=new MapIterator(key);
    }


    /**
     * This method uses the inner class called MapIterator
     * So this method delegates prev() method of MapIterator (delegation)
     * @return key
     */
    public K prev(){
        return myMapIterator.prev();
    }


    /**
     * This method returns hashcode of a given key
     * @param key
     * @param length is lenght of array
     * @return
     */
    public int hash(K key, int length) {
        int index = key.hashCode() % length;
        if (index < 0) {
            index += length;
        }
        return index;
    }


    /**
     * This method returns value of given key if it exists
     * @param key
     * @return value of given key
     */
    @Override
    public V get(K key) {
        int index = hash(key, this.table.length);
        if (this.table[index] == null) {
            return null;
        }
        Entry t;
        for(int i = 0; i < table[index].size(); i++) {
            t = table[index].get(i);
            if (t.getKey().equals(key)) {
                return (V) t.getValue();
            }
        }
        return null;
    }

    /**
     * Rehashing method
     * Increases the capacity to maximize load factor
     */
    public void rehash() {
        this.collisions = 0;
        this.numkeys = 0;
        LinkedList<Entry<K, V>>[] oldTable;
        oldTable = this.table;
        this.capacity = (this.capacity * 2) + 1;
        this.table = new LinkedList[this.capacity];
        Entry<K, V> t;
        for(int i = 0; i < oldTable.length; i++) {
            if (oldTable[i] != null) {
                for(int j = 0; j < oldTable[i].size(); j++) {
                t = oldTable[i].get(j);
                this.put(t.getKey(), t.getValue());
            }
            }
        }
    }

    /**
     * This method puts a new element into the hashtable
     * @param key
     * @param value
     * @return value of entered entry
     */
    @Override
    public V put(K key, V value) {
        int index = hash(key, this.table.length);
        V val = null;
        if (this.table[index] == null) {
            // if no linked list add the key value to the linked list
            LinkedList ll = new LinkedList();
            ll.add(new Entry(key, value));
            this.table[index] = ll;
            this.numkeys = this.numkeys + 1;

            // if load is more than threshold rehash into a new table with more capacity
            if ((this.numkeys) > (this.loadThreshold * this.capacity)) {
                rehash();
            }
            return (V) val;
        } 
        else {
            this.collisions += 1;
            for(int i = 0; i < table[index].size(); i++) {
                Entry t = this.table[index].get(i);
                if (t.getKey().equals(key)) {
                    val = (V) t.setvalue(value);
                    return val;
                }
            }
            this.table[index].add(new Entry(key, value)); //Buraya geliyorsa zaten LinkedListe' ekliyor demek
            
            // if load is more than threshold rehash into a new table with more capacity
            this.numkeys += 1;
            
            if ((this.numkeys) > (this.loadThreshold * this.table.length)) {
                rehash();
            }
            return value;
        }
    }


    /**
     * This method removes element by using given key and value
     * @param key
     * @param value
     * @return removed value of element
     */
    public V remove(K key, V value){
        int index = hash(key, this.table.length);
        if(table[index]==null){
            System.out.println("Key: "+key+" is not found in Hashtable");
            return null;
        }
        Iterator<Entry<K,V>> iter=table[index].listIterator();
        while(iter.hasNext()){
            V tempValue=iter.next().getValue();
            if(tempValue.equals(value)){
                iter.remove();
                if(table[index].isEmpty())
                    table[index]=null;
                System.out.println("("+key+","+value+") is removed from has table");
                return tempValue;
            }
        }
        System.out.println("("+key+","+value+") is not found in HashTable!");
        return null;
    }


    /**
     * This method calculates basic stats of hashtable
     */
    public void calcStats() {
        double total = 0.0;
        double sum = 0.0;
        int max = 0;
        for (LinkedList<Entry<K, V>> ll : this.table) {
            if (ll != null && ll.size() > 0) {

                total += 1;
                sum += ll.size();
                if (ll.size() > max) {
                    max = ll.size();
                }
            }
        }
        this.avgChainLength = sum / total;
        this.maxChainLength = max;
    }

    /**
     * This method prints basic stats of hashtable
     */
    public void printStats() {
        System.out.println("no_collisons: " + this.collisions);
        System.out.println("average_chain_length: " + this.avgChainLength);
        System.out.println("max_chain_length: " + this.maxChainLength);
        System.out.println("load_factor: " + this.loadThreshold);
    }


    /**
     * This method calculates and returns the size of hashtable
     * @return size of hashtable
     */
    public int size() {
        int count = 0;
        Iterator<Entry<K, V>> ir;
        Entry<K, V> t;
        for (LinkedList<Entry<K, V>> ll : this.table) {
            if (ll != null) {
                ir = ll.listIterator(0);
                while (ir.hasNext()) {
                    t = ir.next();
                    if (t.key != null) {
                        count = count + 1;
                    }
                }
            }
        }
        return count;
    }

    public boolean isEmpty() {
        return (this.size() < 1);
    }

    /**
     * This method displays existed elements in array in sequential order
     */
    public void display(){
        LinkedList<Entry<K,V>> tempList;
        for(int i=0;i<table.length;i++){
            tempList=table[i];
            if(tempList!=null){
                Iterator<Entry<K,V>> iter=tempList.listIterator();
                System.out.print("Array Index: "+i+" -->");
                while(iter.hasNext())
                    System.out.print(iter.next()+"   ");
                System.out.println();
            }
        }
    }
}
