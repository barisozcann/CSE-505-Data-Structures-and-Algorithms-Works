// Java program to find shortest path in an undirected
// graph
//package cse222_hw8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
 
public class UWclass {


    /**
     * This method is the main function of UWclass
     * It makes calculations with helper methods and returns the final results
     * @param adj
     * @param length
     * @param reference is the reference node for calculations
     */
    static void calculate(int length,int reference,ArrayList<ArrayList<Integer>> adj){
        double up = 0, down = 0;
        double res = 0;
        for(int i = 0;i<length;i++){
            for(int j = 0;j< length;j++){
                if(i == j) continue;
                up+= getShortest(adj, i, j, length);
                down += getAlternativeShortest(adj, i, j, length, reference);
                res += (down/up);
            }
        }
        System.out.println("The result is :"+(res/(length*length)));
    }


    /**
     * This method adds a new edge
     * All edges are undirected
     * @param adj
     * @param i
     * @param j
     */
    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int i, int j)
    {
        adj.get(i).add(j);
        adj.get(j).add(i);
    }

    /**
     * This method prints out shortest distance
     * between two vertices
     * @param adj
     * @param s
     * @param dest
     * @param v
     * @return
     */
    private static int getShortest(
                     ArrayList<ArrayList<Integer>> adj,
                             int s, int dest, int v)
    {
        /* pred[i] stores predecessor of
         i and distance array stores distance of i
         from s*/
        int pred[] = new int[v];
        int dist[] = new int[v];
 
        if (BFS(adj, s, dest, v, pred, dist) == false) {
            return 0;
        }
 
        // LinkedList below stores paths
        LinkedList<Integer> path = new LinkedList<Integer>();
        int crawl = dest;
        path.add(crawl);
        while (pred[crawl] != -1) {
            path.add(pred[crawl]);
            crawl = pred[crawl];
        }
 
        // Print distance
        return dist[dest];
        
    }

    /**
     * This method is helper method of getShortest method
     *It tries to find alternative shortest paths
     * @param adj
     * @param s
     * @param dest
     * @param length
     * @param v
     * @return
     */
    private static int getAlternativeShortest(
                     ArrayList<ArrayList<Integer>> adj,
                             int s, int dest,int length,int v)
    {
        /* pred[i] stores predecessor of
        i and distance array stores distance of i
        from s*/
        int pred[] = new int[length];
        int dist[] = new int[length];
 
        if (BFS(adj, s, dest, length, pred, dist) == false) {
            return 0;
        }

        // LinkedList below stores paths
        LinkedList<Integer> path = new LinkedList<Integer>();
        int crawl = dest;
        path.add(crawl);
        while (pred[crawl] != -1) {
            path.add(pred[crawl]);
            crawl = pred[crawl];
        }
 

        for (int i = path.size() - 1; i >= 0; i--) {
            if(path.get(i) == v)
                return 1;
        }
        
        return 0;
        
    }




    /**
     * This method uses BFS algorithm to store
     * predecessor of each vertex with its dist
     * @param adj
     * @param src
     * @param dest
     * @param v
     * @param pred
     * @param dist
     * @return
     */
    private static boolean BFS(ArrayList<ArrayList<Integer>> adj, int src,
                                  int dest, int v, int pred[], int dist[])
    {

        LinkedList<Integer> queue = new LinkedList<Integer>();
 
        /* boolean array visited[] stores the
        information whether ith vertex is reached
        at least once in the Breadth first search*/
        boolean visited[] = new boolean[v];
 
        /* All vertices are unvisited by default
         At the beginning*/
        for (int i = 0; i < v; i++) {
            visited[i] = false;
            dist[i] = Integer.MAX_VALUE; //Maximum integer value
            pred[i] = -1;
        }
 
        /* now source is first to be visited and
         distance from source to itself should be 0*/
        visited[src] = true;
        dist[src] = 0;
        queue.add(src);
 
        // BFS takes action here
        while (!queue.isEmpty()) {
            int u = queue.remove();
            for (int i = 0; i < adj.get(u).size(); i++) {
                if (visited[adj.get(u).get(i)] == false) {
                    visited[adj.get(u).get(i)] = true;
                    dist[adj.get(u).get(i)] = dist[u] + 1;
                    pred[adj.get(u).get(i)] = u;
                    queue.add(adj.get(u).get(i));
 
                    //If it finds the destination, it returns true value
                    if (adj.get(u).get(i) == dest)
                        return true;
                }
            }
        }
        return false;
    }

}