import java.util.Random;

public class Main {

    public static void main(String[] args){

        /**
         * Part 1 begins here
         */
        SkipList<Integer> slist=new SkipList<Integer>();
        for(int i=0;i<4;i++)
            slist.insert(i);
        System.out.println(slist.toString());

        slist.remove();
        slist.remove();

        slist.iteratorConstructor();
        System.out.println(slist.next());
        System.out.println(slist.next());
        System.out.println(slist.next());
        System.out.println(slist.next());
        System.out.println(slist.next());
        System.out.println(slist.next());
        System.out.println(slist.next());
        System.out.println(slist.next());

        AVLTree<Integer> avlTree=new AVLTree<Integer>();
        for(int i=0;i<10;i++)
            avlTree.insert(i);
        avlTree.iteratorConstructor();
        System.out.println(avlTree.next());
        System.out.println(avlTree.next());
        System.out.println(avlTree.next());
        System.out.println(avlTree.next());
        System.out.println(avlTree.next());
        System.out.println(avlTree.next());
        System.out.println(avlTree.next());
        System.out.println(avlTree.next());
        System.out.println(avlTree.next());
        System.out.println(avlTree.next());

        avlTree.tailSet(6);
        avlTree.headSet(6);


        /**
         * Part 2 Begins here
         */
        BinarySearchTree<Integer> bst_unbalanced=new BinarySearchTree<Integer>();
        for(int i=1;i<4;i++)
            bst_unbalanced.add(i);
        System.out.println(bst_unbalanced.isBalanced(bst_unbalanced.root));

        BinarySearchTree<Integer> bst_balanced=new BinarySearchTree<Integer>();

        bst_balanced.add(2);
        bst_balanced.add(3);
        bst_balanced.add(1);
        System.out.println(bst_balanced.isBalanced(bst_balanced.root));




        /**
         * Part 3 begins here
         */

        BinarySearchTree<Integer> bst=new BinarySearchTree<>();
        Random rand = new Random();
        int randomInteger;
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10000;i++){
            bst.add(rand.nextInt(2147483646));
        }
        long end1 = System.currentTimeMillis();
        long elapsedTime1 = end1 - start1;
        System.out.println("Elapsed time of insertion of 10000 elements to Binary Search Tree: "
                +elapsedTime1+" MilliSeconds");

        bst=null;
        bst=new BinarySearchTree<>();

        long start2 = System.currentTimeMillis();
        for(int i=0;i<20000;i++){
            bst.add(rand.nextInt(2147483646));
        }
        long end2 = System.currentTimeMillis();
        long elapsedTime2 = end2 - start2;
        System.out.println("Elapsed time of insertion of 20000 elements to Binary Search Tree: "
                +elapsedTime2+" MilliSeconds");

        bst=null;
        bst=new BinarySearchTree<>();

        long start3 = System.currentTimeMillis();
        for(int i=0;i<40000;i++){
            bst.add(rand.nextInt(2147483646));
        }
        long end3 = System.currentTimeMillis();
        long elapsedTime3 = end3 - start3;
        System.out.println("Elapsed time of insertion of 40000 elements to Binary Search Tree: "
                +elapsedTime3+" MilliSeconds");

        bst=null;
        bst=new BinarySearchTree<>();

        long start4 = System.currentTimeMillis();
        for(int i=0;i<80000;i++){
            bst.add(rand.nextInt(2147483646));
        }
        long end4 = System.currentTimeMillis();
        long elapsedTime4 = end4 - start4;
        System.out.println("Elapsed time of insertion of 80000 elements to Binary Search Tree: "
                +elapsedTime4+" MilliSeconds");


        RedBlackTree<Integer> rbTree=new RedBlackTree<>();
        long start5 = System.currentTimeMillis();
        for(int i=0;i<10000;i++){
            rbTree.add(rand.nextInt(2147483646));
        }
        long end5 = System.currentTimeMillis();
        long elapsedTime5 = end5 - start5;
        System.out.println("Elapsed time of insertion of 10000 elements to Red Black Tree: "
                +elapsedTime5+" MilliSeconds");

        rbTree=null;
        rbTree=new RedBlackTree<>();
        long start6 = System.currentTimeMillis();
        for(int i=0;i<20000;i++){
            rbTree.add(rand.nextInt(2147483646));
        }
        long end6 = System.currentTimeMillis();
        long elapsedTime6 = end6 - start6;
        System.out.println("Elapsed time of insertion of 20000 elements to Red Black Tree: "
                +elapsedTime6+" MilliSeconds");

        rbTree=null;
        rbTree=new RedBlackTree<>();
        long start7 = System.currentTimeMillis();
        for(int i=0;i<40000;i++){
            rbTree.add(rand.nextInt(2147483646));
        }
        long end7 = System.currentTimeMillis();
        long elapsedTime7 = end7 - start7;
        System.out.println("Elapsed time of insertion of 40000 elements to Red Black Tree: "
                +elapsedTime7+" MilliSeconds");

        rbTree=null;
        rbTree=new RedBlackTree<>();
        long start8 = System.currentTimeMillis();
        for(int i=0;i<80000;i++){
            rbTree.add(rand.nextInt(2147483646));
        }
        long end8 = System.currentTimeMillis();
        long elapsedTime8 = end8 - start8;
        System.out.println("Elapsed time of insertion of 80000 elements to Red Black Tree: "
                +elapsedTime8+" MilliSeconds");


        TwoThreeFourTree<Integer> ttTree=new TwoThreeFourTree<>();
        long start9 = System.currentTimeMillis();
        for(int i=0;i<10000;i++){
            ttTree.add(rand.nextInt(2147483646));
        }
        long end9 = System.currentTimeMillis();
        long elapsedTime9 = end9 - start9;
        System.out.println("Elapsed time of insertion of 10000 elements to 2-3 Tree: "
                +elapsedTime9+" MilliSeconds");

        ttTree=null;
        ttTree=new TwoThreeFourTree<>();
        long start10 = System.currentTimeMillis();
        for(int i=0;i<20000;i++){
            ttTree.add(rand.nextInt(2147483646));
        }
        long end10 = System.currentTimeMillis();
        long elapsedTime10 = end10 - start10;
        System.out.println("Elapsed time of insertion of 20000 elements to 2-3 Tree: "
                +elapsedTime10+" MilliSeconds");

        ttTree=null;
        ttTree=new TwoThreeFourTree<>();
        long start11 = System.currentTimeMillis();
        for(int i=0;i<40000;i++){
            ttTree.add(rand.nextInt(2147483646));
        }
        long end11 = System.currentTimeMillis();
        long elapsedTime11 = end11 - start11;
        System.out.println("Elapsed time of insertion of 40000 elements to 2-3 Tree: "
                +elapsedTime11+" MilliSeconds");

        ttTree=null;
        ttTree=new TwoThreeFourTree<>();
        long start12 = System.currentTimeMillis();
        for(int i=0;i<80000;i++){
            ttTree.add(rand.nextInt(2147483646));
        }
        long end12 = System.currentTimeMillis();
        long elapsedTime12 = end12 - start12;
        System.out.println("Elapsed time of insertion of 80000 elements to 2-3 Tree: "
                +elapsedTime12+" MilliSeconds");



        BTree<Integer,Integer> bTree=new BTree<>();

        long start13 = System.currentTimeMillis();
        for(int i=0;i<10000;i++){
            bTree.put(rand.nextInt(2147483646),rand.nextInt(2147483646));
        }
        long end13 = System.currentTimeMillis();
        long elapsedTime13 = end13 - start13;
        System.out.println("Elapsed time of insertion of 10000 elements to BTree: "
                +elapsedTime13+" MilliSeconds");

        bTree=null;
        bTree=new BTree<>();

        long start14 = System.currentTimeMillis();
        for(int i=0;i<20000;i++){
            bTree.put(rand.nextInt(2147483646),rand.nextInt(2147483646));
        }
        long end14 = System.currentTimeMillis();
        long elapsedTime14 = end14 - start14;
        System.out.println("Elapsed time of insertion of 20000 elements to BTree: "
                +elapsedTime14+" MilliSeconds");

        bTree=null;
        bTree=new BTree<>();

        long start15 = System.currentTimeMillis();
        for(int i=0;i<40000;i++){
            bTree.put(rand.nextInt(2147483646),rand.nextInt(2147483646));
        }
        long end15 = System.currentTimeMillis();
        long elapsedTime15 = end15 - start15;
        System.out.println("Elapsed time of insertion of 40000 elements to BTree: "
                +elapsedTime15+" MilliSeconds");

        bTree=null;
        bTree=new BTree<>();

        long start16 = System.currentTimeMillis();
        for(int i=0;i<80000;i++){
            bTree.put(rand.nextInt(2147483646),rand.nextInt(2147483646));
        }
        long end16 = System.currentTimeMillis();
        long elapsedTime16 = end16 - start16;
        System.out.println("Elapsed time of insertion of 80000 elements to BTree: "
                +elapsedTime16+" MilliSeconds");



        SkipList<Integer> skipList=new SkipList<>();

        long start17 = System.currentTimeMillis();
        for(int i=0;i<10000;i++){
            skipList.insert(rand.nextInt(2147483646));
        }
        long end17 = System.currentTimeMillis();
        long elapsedTime17 = end17 - start17;
        System.out.println("Elapsed time of insertion of 10000 elements to Skip List: "
                +elapsedTime17+" MilliSeconds");

        skipList=null;
        skipList=new SkipList<>();

        long start18 = System.currentTimeMillis();
        for(int i=0;i<20000;i++){
            skipList.insert(rand.nextInt(2147483646));
        }
        long end18 = System.currentTimeMillis();
        long elapsedTime18 = end18 - start18;
        System.out.println("Elapsed time of insertion of 20000 elements to Skip List: "
                +elapsedTime18+" MilliSeconds");

        skipList=null;
        skipList=new SkipList<>();

        long start19 = System.currentTimeMillis();
        for(int i=0;i<40000;i++){
            skipList.insert(rand.nextInt(2147483646));
        }
        long end19 = System.currentTimeMillis();
        long elapsedTime19 = end19 - start19;
        System.out.println("Elapsed time of insertion of 40000 elements to Skip List: "
                +elapsedTime19+" MilliSeconds");

        skipList=null;
        skipList=new SkipList<>();

        long start20 = System.currentTimeMillis();
        for(int i=0;i<80000;i++){
            skipList.insert(rand.nextInt(2147483646));
        }
        long end20 = System.currentTimeMillis();
        long elapsedTime20 = end20 - start20;
        System.out.println("Elapsed time of insertion of 80000 elements to Skip List: "
                +elapsedTime20+" MilliSeconds");


        /*100 element test*/

        long start21 = System.nanoTime();
        for(int i=0;i<100;i++){
            bst.add(rand.nextInt(2147483646));
        }
        long end21 = System.nanoTime();
        long elapsedTime21 = end21 - start21;
        System.out.println("Elapsed time of inserting 100 extra elements to BST(80000): "
                +elapsedTime21+" NanoSeconds");

        long start22 = System.nanoTime();
        for(int i=0;i<100;i++){
            rbTree.add(rand.nextInt(2147483646));
        }
        long end22 = System.nanoTime();
        long elapsedTime22 = end22 - start22;
        System.out.println("Elapsed time of inserting 100 extra elements to Red-BlackTree(80000): "
                +elapsedTime22+" NanoSeconds");

        long start23 = System.nanoTime();
        for(int i=0;i<100;i++){
            ttTree.add(rand.nextInt(2147483646));
        }
        long end23 = System.nanoTime();
        long elapsedTime23 = end23 - start23;
        System.out.println("Elapsed time of inserting 100 extra elements to 2-3Tree(80000): "
                +elapsedTime23+" NanoSeconds");

        long start24 = System.nanoTime();
        for(int i=0;i<100;i++){
            bTree.put(rand.nextInt(2147483646),rand.nextInt(2147483646));
        }
        long end24 = System.nanoTime();
        long elapsedTime24 = end24 - start24;
        System.out.println("Elapsed time of inserting 100 extra elements to BTree(80000): "
                +elapsedTime24+" NanoSeconds");

        long start25 = System.nanoTime();
        for(int i=0;i<100;i++){
            skipList.insert(rand.nextInt(2147483646));
        }
        long end25 = System.nanoTime();
        long elapsedTime25 = end25 - start25;
        System.out.println("Elapsed time of inserting 100 extra elements to SkipList(80000): "
                +elapsedTime25+" NanoSeconds");


    }
}
