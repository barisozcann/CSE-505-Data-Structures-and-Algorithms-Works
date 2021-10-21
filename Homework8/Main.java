import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args){
        /**
         * Part 1
         */

        /**
         * Matrix Graph
         */
        System.out.println("***************** Part 1 Begins ***********************");
        MatrixGraph mGraph=new MatrixGraph(5,true);
        Edge e1=new Edge(0,1,12.0);
        Edge e2=new Edge(2,3,10.0);
        Edge e3=new Edge(1,2,20.0);
        Edge e4=new Edge(2,4,5.0);
        Edge e5=new Edge(3,4,7.0);
        Edge e6=new Edge(1,3,15.0);
        mGraph.insert(e1);
        mGraph.insert(e2);
        mGraph.insert(e3);
        mGraph.insert(e4);
        mGraph.insert(e5);
        //mGraph.insert(e6);
        DijkstrasAlgorithm dAlgorith=new DijkstrasAlgorithm(mGraph,0);
        dAlgorith.getResults();

        /**
         * listGraph
         */

        ListGraph lGraph=new ListGraph(5,true);
        lGraph.insert(e1);
        lGraph.insert(e2);
        lGraph.insert(e3);
        lGraph.insert(e4);
        lGraph.insert(e5);
        dAlgorith=new DijkstrasAlgorithm(lGraph,0);
        dAlgorith.getResults();

        /**
         * Part2
         */


        /**
         * BFS Testing
         */
        System.out.println("**************** Part 2 Begins *******************");

        long start,stop;
        start = System.nanoTime();
        BFS.test1000();
        stop = System.nanoTime();

        System.out.println("\ntotal time for 1000 Vertices:" + (stop - start));

        start = System.nanoTime();
        BFS.test2000();
        stop = System.nanoTime();

        System.out.println("\ntotal time for 2000 Vertices:" + (stop - start));

        start = System.nanoTime();
        BFS.test5000();
        stop = System.nanoTime();

        System.out.println("\ntotal time for 5000 Vertices:" + (stop - start));

        start = System.nanoTime();
        BFS.test10000();
        stop = System.nanoTime();

        System.out.println("\ntotal time for 10000 Vertices:" + (stop - start));


        /**
         * DFS testing
         */
        start = System.nanoTime();
        DFS.test1000();
        stop = System.nanoTime();

        System.out.println("\ntotal time for 1000 Vertices:" + (stop - start));

        start = System.nanoTime();
        DFS.test2000();
        stop = System.nanoTime();

        System.out.println("\ntotal time for 2000 Vertices:" + (stop - start));

        start = System.nanoTime();
        DFS.test5000();
        stop = System.nanoTime();

        System.out.println("\ntotal time for 5000 Vertices:" + (stop - start));

        start = System.nanoTime();
        DFS.test10000();
        stop = System.nanoTime();

        System.out.println("\ntotal time for 10000 Vertices:" + (stop - start));


        /**
         * Part 3
         */
        System.out.println("**************** Part 3 Begins *******************");

        // Number of vertices
        int vertices = 6;

        // Adjacency list for storing connected vertices
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(vertices);
        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<Integer>());
        }

        /*The graph according to given figure in my report*/
        UWclass.addEdge(adj, 0, 1);
        UWclass.addEdge(adj, 0, 4);
        UWclass.addEdge(adj, 1, 2);
        UWclass.addEdge(adj, 1, 3);
        UWclass.addEdge(adj, 1, 4);
        UWclass.addEdge(adj, 2, 3);
        UWclass.addEdge(adj, 2, 5);
        UWclass.addEdge(adj, 3, 4);
        UWclass.addEdge(adj, 3, 5);
        UWclass.addEdge(adj, 4, 5);
        int source = 0, dest = 5;

        System.out.print("The importance of vertex "+1+" is: ");
        UWclass.calculate(vertices, 1,adj);
        System.out.print("The importance of vertex "+2+" is: ");
        UWclass.calculate(vertices, 2,adj);




    }
}
