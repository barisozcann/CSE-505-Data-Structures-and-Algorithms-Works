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
 * This class uses adjList Graph Representation
 */
public class BFS
{
    private int V;   // Number of Vertices
    private LinkedList<Integer> adjList[]; // adj List in LinkedList form

    /**
     * Constructor Method
     * @param v
     */
    public BFS(int v)
    {
        V = v;
        adjList = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adjList[i] = new LinkedList();
    }

    /**
     * This method adds an edge
     * @param v
     * @param w
     */
    private void addEdge(int v,int w)
    {
        adjList[v].add(w);
    }

    /**
     * This Method prints BFS traversal from a given source s
     * @param s
     * @return
     */
    private int BFS(int s)
    {
        // Mark all the vertices as not visited
        boolean visited[] = new boolean[V];
        int res = 0;
        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();
 
        // Mark the current node as visited and enqueue it
        visited[s]=true;
        queue.add(s);
 
        while (queue.size() != 0)
        {
            // Take a vertex from queue and print it
            s = queue.poll();
            System.out.print(s+" ");
 
            
            // If a adjListacent has not been visited, then mark it
            Iterator<Integer> i = adjList[s].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                    res++;
                }
            }
        }
        return res;
    }


    
    public static void test1000(){
        BFS g = new BFS(1000);
        Random rand = new Random();
        for(int i = 0;i< 1000;i++){
            int a = i;
            while(a == i)
                a = rand.nextInt(1000);
            g.addEdge(i, a);
            g.addEdge(a, i);
        }
        System.out.println("Breadth First Traversal With 1000 Vertices" );
        g.BFS(0);
    }
    
    public static void test2000(){
        BFS g = new BFS(2000);
        Random rand = new Random();
        for(int i = 0;i< 2000;i++){
            int a = i;
            while(a == i)
                a = rand.nextInt(2000);
            g.addEdge(i, a);
            g.addEdge(a, i);
        }
        System.out.println("Breadth First Traversal With 2000 Vertices");
        g.BFS(0);
    }
    
    public static void test5000(){
        BFS g = new BFS(5000);
        Random rand = new Random();
        for(int i = 0;i< 5000;i++){
            int a = i;
            while(a == i)
                a = rand.nextInt(5000);
            g.addEdge(i, a);
            g.addEdge(a, i);
        }
        System.out.println("Breadth First Traversal With 5000 Vertices");
        g.BFS(0);
    }
    
    public static void test10000(){
        BFS g = new BFS(10000);
        Random rand = new Random();
        for(int i = 0;i< 10000;i++){
            int a = i;
            while(a == i)
                a = rand.nextInt(10000);
            g.addEdge(i, a);
            g.addEdge(a, i);
        }
        System.out.println("Breadth First Traversal With 10000 Vertices");
        g.BFS(0);
    }
    
    
}
