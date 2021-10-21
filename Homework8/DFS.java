/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Baris
 */


import java.io.*;
import java.util.*;

/**
 * This class uses adjList list Graph representation
 */
public class DFS {
    private int V; // Number of vertices
    private int res = 0;
    
    
    // adj List in LinkedList form
    private LinkedList<Integer> adjList[];
 
    // Constructor
    @SuppressWarnings("unchecked") DFS(int v)
    {
        V = v;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adjList[i] = new LinkedList();
    }

    /**
     * This method adds and edge
     * @param v
     * @param w
     */
    private void addEdge(int v, int w)
    {
        adjList[v].add(w); // Add w to v's list.
    }

    /**
     * DFS Helper Method
     * @param v
     * @param visited
     */
    private void DFSUtil(int v, boolean visited[])
    {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");
 
        // Recur for all the vertices adjListacent to this
        // vertex
        Iterator<Integer> i = adjList[v].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n]){
                DFSUtil(n, visited);
                res++;
            }
                
        }
    }

    /**
     * This is the main DFS function
     * @param v
     * @return
     */
    private int DFS(int v)
    {
        // Mark all the vertices as not visited
        boolean visited[] = new boolean[V];
 
        //Calling Helper Method
        DFSUtil(v, visited);
        return res;
    }
 
    
    public static void test1000(){
        DFS g = new DFS(1000);
        Random rand = new Random();
        for(int i = 0;i< 1000;i++){
            int a = i;
            while(a == i)
                a = rand.nextInt(1000);
            g.addEdge(i, a);
            g.addEdge(a, i);
        }
        System.out.println("Depth First Traversal with 1000 vertices");
        g.DFS(0);
    }
    
    public static void test2000(){
        DFS g = new DFS(2000);
        Random rand = new Random();
        for(int i = 0;i< 2000;i++){
            int a = i;
            while(a == i)
                a = rand.nextInt(2000);
            g.addEdge(i, a);
            g.addEdge(a, i);
        }
        System.out.println("Depth First Traversal with 2000 vertices");
        g.DFS(0);
    }
    
    public static void test5000(){
        DFS g = new DFS(5000);
        Random rand = new Random();
        for(int i = 0;i< 5000;i++){
            int a = i;
            while(a == i)
                a = rand.nextInt(5000);
            g.addEdge(i, a);
            g.addEdge(a, i);
        }
        System.out.println("Depth First Traversal with 5000 vertices");
        g.DFS(0);
    }
    
    public static void test10000(){
        DFS g = new DFS(10000);
        Random rand = new Random();
        for(int i = 0;i< 10000;i++){
            int a = i;
            while(a == i)
                a = rand.nextInt(10000);
            g.addEdge(i, a);
            g.addEdge(a, i);
        }
        System.out.println("Depth First Traversal with 10000 vertices");
        g.DFS(0);
    }
    
    
    
}