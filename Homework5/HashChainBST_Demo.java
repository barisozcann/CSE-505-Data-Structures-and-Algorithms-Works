public class HashChainBST_Demo{
    private int hashTableSize;
    private BST hashTable[]; //Binary Search Tree

    /**
     * Zero Parameter constructor of HashChainBST_Demo
     * hashTableSize is equal to 30 always
     * So, this is only a demo class of hashtable that uses a binary search tree
     */
    public HashChainBST_Demo(){
        hashTableSize=30; //capacity=30
        hashTable=new BST[hashTableSize]; //Array that keeps Binary Search Trees
        for(int i=0;i<hashTableSize;i++)
            hashTable[i]=new BST(); //Adds Binary Search Trees to every index of Array
    }

    /**
     * This method calculates hashcode of given key
     * In this class given key is equal to value itself
     * So hashcode becomes the key of given value automatically
     * @param key
     * @return
     */
    public int myHashCode(Comparable key){
        return Math.abs(key.hashCode()% hashTableSize);
    }

    /**
     * This method puts a new element in to hashtable's Binary Search Tree
     * @param element
     */
    public void put(Comparable element){
        int i=myHashCode(element);
        hashTable[i].insert(element);

    }

    /**
     * This method searches element if returns true if it finds the element
     * This method uses find method of BST class
     * @param element
     * @return
     */
    public boolean search(Comparable element){
        int i=myHashCode(element);
        BST tempBST=hashTable[i];
        return tempBST.find(element)!=null;
    }

    /**
     * This method first searches to element if it exists, than removes the existed element in BST of hashtable
     * @param element
     * @return
     */
    public boolean remove(Comparable element){
        if(!search(element))
            return false;
        int i=myHashCode(element);
        hashTable[i].remove(element);
        return true;
    }

    /**
     * This method displays existed elements of hashtable in sequential order
     */
    public void display() {
        for(int i=0;i<hashTableSize;i++) {
            System.out.print("[" + i + "]-->");
            if(!hashTable[i].isEmpty())
                hashTable[i].print(); //BST display metodu
            System.out.println();
        }
        System.out.println();
    }

}
