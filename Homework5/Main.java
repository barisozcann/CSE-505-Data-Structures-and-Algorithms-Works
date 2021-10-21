public class Main {

    public static void main(String args[]){
        /**
         * Part 1
         * This block shows MapIterator functions
         * MapIterator is inner class of HashTableChain
         * HashTableChain delegates the methods of MapIterator
         */

        //Putting elements
        HashTableChain<Integer,Integer> myHashTable=new HashTableChain<Integer,Integer>();
        myHashTable.put(1,11);
        myHashTable.put(2,100);
        myHashTable.put(3,55);
        myHashTable.put(4,65);
        myHashTable.put(5,75);
        myHashTable.put(120,240);
        myHashTable.put(160,320);

        /**
         * Removing and displaying elements by using MapIterator
         */
        myHashTable.remove(5,75);
        myHashTable.remove(6,75);
        myHashTable.display();

        /**
         * Start MapIterator at index 1
         */
        myHashTable.iteratorConstructor(1);

        /**
         * This part shows next() method of MapIterator
         * It always calls hasNext() method to check if the iterator reached the end of the Array
         * When iterator reaches the last element of Hashtable, it restarts from the beginning
         */
        System.out.println(myHashTable.next());
        System.out.println(myHashTable.next());
        System.out.println(myHashTable.next());
        System.out.println(myHashTable.next());
        System.out.println(myHashTable.next());
        System.out.println(myHashTable.next());
        System.out.println(myHashTable.next());
        System.out.println(myHashTable.next());
        System.out.println(myHashTable.next());
        System.out.println(myHashTable.next());


        /**
         * This part shows prev() method of MapIterator
         * It always calls hasPrev() method to check if the iterator reached the beginning of the Array
         * When iterator reaches the first element of Hashtable,
         * it doesn't moves to anywhere until the next() method is called
         */
        System.out.println("***************************");
        System.out.println(myHashTable.prev());
        System.out.println(myHashTable.prev());
        System.out.println(myHashTable.prev());
        System.out.println(myHashTable.prev());
        System.out.println(myHashTable.prev());
        System.out.println(myHashTable.prev());
        System.out.println(myHashTable.next());
        System.out.println(myHashTable.next());

        /**
         * This part shows zero parameter constructor of MapIterator
         * Every time it constructs, Iterator stars from a random point at the hashtable
         */
        myHashTable.iteratorConstructor();
        System.out.println(myHashTable.next());
        System.out.println(myHashTable.next());
        myHashTable.iteratorConstructor();
        System.out.println(myHashTable.next());
        System.out.println(myHashTable.next());
        myHashTable.iteratorConstructor();
        System.out.println(myHashTable.next());
        System.out.println(myHashTable.next());



        /**
         * Part 2
         * Part 2.1: Shows the HashTableChain that uses LinkedList
         * Part 2.2: Shows the HashTableChain that uses BinarySearchTree
         * Part 2.3: Sorry i couldn't make this part
         */

        /**
         * Part 2.1 and 2.2
         */

        /**
         * HashTableChain, Key=Integer, Value=Integer
         */


        HashTableChain<Integer,Integer> smallHashTable=new HashTableChain<Integer,Integer>();
        for(int i=0;i<10;i++){ //Puts elements 0-9
            smallHashTable.put(i,i*i);
        }
        /**
         * Displays elements of small hashtable
         */
        smallHashTable.display();
        System.out.println("Stats of small hashtable(linked list");
        smallHashTable.printStats();
        System.out.println("******************** Small HashTable(Linked List) Ends ********************");
        System.out.println();

        HashTableChain<Integer,Integer> mediumHashTable=new HashTableChain<Integer,Integer>();
        for(int i=0;i<100;i++){ //Puts elements 0-99
            mediumHashTable.put(i,i*i);
        }
        /**
         * Displays elements of medium hashtable
         */
        mediumHashTable.display();
        System.out.println("Stats of medium hashtable(linked list");
        mediumHashTable.printStats();
        System.out.println("******************** Medium HashTable(Linked List)  Ends ********************");
        System.out.println();

        HashTableChain<Integer,Integer> bigHashTable=new HashTableChain<Integer,Integer>();
        for(int i=0;i<1000;i++){ //Puts elements 0-999
            bigHashTable.put(i,i*i);
        }
        /**
         * Displays elements of big hashtable
         */
        bigHashTable.display();
        System.out.println("Stats of big hashtable(linked list");
        bigHashTable.printStats();
        System.out.println("******************** Big HashTable(Linked List)  Ends ********************");
        System.out.println();


        /**
         * part 2.2
         * This Part shows a demo class of HashTable that uses Binary Search Trees
         * Unfortunately this class doesn't have rehashing
         * Also keys are automatically assigned in this class. Hashcodes are keys of elements
         * To make a fair observation, i will put maximum 100 elements in to it
         */

        HashChainBST_Demo smallHashChain=new HashChainBST_Demo();
        for(int i=0;i<10;i++){ //Puts elements 0-9
            smallHashChain.put(i*i);
        }
        smallHashChain.display();
        System.out.println("******************* Small Hashtable (Binary Search Tree) Ends ******************");
        System.out.println();

        HashChainBST_Demo mediumHashChain=new HashChainBST_Demo();
        for(int i=0;i<100;i++){ //Puts elements 0-99
            mediumHashChain.put(i*i);
        }
        mediumHashChain.display();
        System.out.println("******************* Medium Hashtable (Binary Search Tree) Ends ******************");
        System.out.println();

        /**
         * Comparison between medium HashTables of LinkedList and Binary Search Tree
         */

        /**
         * Searching existed elements
         */

        /*LinkedList HashTable Part */
        System.out.println("LL Hashtable Searching has started");
        mediumHashTable.get(49);
        mediumHashTable.get(121);
        mediumHashTable.get(324);
        System.out.println("LL Hashtable Searching has finished");

        /*BST HashTable Part*/
        System.out.println("BST Hashtable Searching has started");
        mediumHashChain.search(49);
        mediumHashChain.search(121);
        mediumHashChain.search(324);
        System.out.println("BST Hashtable Searching has finished");

        /**
         * Searching not existed elements
         */

        /*LinkedList HashTable Part */
        System.out.println("LL Hashtable Searching has started");
        mediumHashTable.get(50);
        mediumHashTable.get(122);
        mediumHashTable.get(325);
        System.out.println("LL Hashtable Searching has finished");

        /*BST HashTable Part*/
        System.out.println("BST Hashtable Searching has started");
        mediumHashChain.search(50);
        mediumHashChain.search(122);
        mediumHashChain.search(325);
        System.out.println("BST Hashtable Searching has finished");

        /**
         * Removing existed elements
         */

        /*LinkedList HashTable Part */
        System.out.println("LL Hashtable Removing has started");
        mediumHashTable.remove(7,49);
        mediumHashTable.remove(20,400);
        mediumHashTable.remove(30,900);
        System.out.println("LL Hashtable Removing has finished");

        /*BST HashTable Part*/
        System.out.println("BST Hashtable Removing has started");
        mediumHashChain.remove(49);
        mediumHashChain.remove(400);
        mediumHashChain.remove(900);
        System.out.println("BST Hashtable Removing has finished");

        /**
         * Removing non-existed elements
         */

        /*LinkedList HashTable Part */
        System.out.println("LL Hashtable Removing has started");
        mediumHashTable.remove(7,50);
        mediumHashTable.remove(20,401);
        mediumHashTable.remove(30,901);
        System.out.println("LL Hashtable Removing has finished");

        /*BST HashTable Part*/
        System.out.println("BST Hashtable Removing has started");
        mediumHashChain.remove(50);
        mediumHashChain.remove(401);
        mediumHashChain.remove(901);
        System.out.println("LL Hashtable Removing has finished");

        /**
         * I already showed adding elements so testing part is over
         * Part 2 is over, so driver functions is over
         */

        System.out.println("Driver function is terminated.....");


    }

}

