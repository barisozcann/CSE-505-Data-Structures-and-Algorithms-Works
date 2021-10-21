/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author baris
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Intersing elements to heap1 and heap2*/
        ClassicHeap heap1=new ClassicHeap();
        heap1.insert(25);
        heap1.insert(14);
        heap1.insert(2);
        heap1.insert(20);
        heap1.insert(10);
        heap1.insert(50);
        heap1.insert(60);
        System.out.println("Heap Data: ");
        heap1.display();

        heap1.insert(40);
        System.out.println("Heap Data: ");
        heap1.display();

        int element=heap1.deleteMax(); 
        System.out.println("Deleted element: "+element);
        heap1.display();
        
        heap1.deleteAnyMax(3); //deleting 3th max element
        heap1.display();
        
        heap1.search(14);
        heap1.display();
        
        heap1.search(27);
        heap1.display();
        
       /*Creating Heap2*/
        ClassicHeap heap2=new ClassicHeap();
        heap2.insert(15);
        heap2.insert(35);
        heap1.merge(heap2); //Merging heap1 and heap2
        heap1.display();
        heap2.display();
        heap2.deleteMax();
        heap2.deleteMax();
        
        heap2.insert(120);
        heap2.insert(130);
        
        System.out.println("************");
        
       /*Testing Iterator*/
        ClassicHeapIterator heap_iter=new ClassicHeapIterator(heap1);
        heap_iter.next();
        heap_iter.next();
        heap_iter.set(48);
        heap1.display();
        
        Scanner input=new Scanner(System.in);
        
        System.out.println("There are 2 Heaps in the system: Heap1 and Heap2");
        int loopController=0;
        int transaction;
        while(loopController!=-1){
            System.out.println("********************************************************");
            System.out.println("Welcome to the testing menu");
            System.out.println("Press [1] to Display Elements of A Heap");
            System.out.println("Press [2] to Search An Element in A Heap");
            System.out.println("Press [3] to Merge Heap1 with Heap2");
            System.out.println("Press [4] to Remove ith Largest Element From The Heap");
            System.out.println("Press [5] to Set an Element of The Heap by Using Iterator");
            System.out.println("Press [6] to exit");
            transaction=input.nextInt();
            switch(transaction){
                case 1:
                    System.out.println("Press [1] to display elements of Heap1");
                    System.out.println("Press [2] to display elements of Heap2");
                    int whichHeap1=input.nextInt();
                    if(whichHeap1==1)
                        heap1.display();
                    else if(whichHeap1==2)
                        heap2.display();
                    else
                        System.out.println("Please enter a valid number(1 or 2)");
                    break;
                case 2:
                    System.out.println("Press [1] to Search An Element in A Heap1");
                    System.out.println("Press [2] to Search An Element in A Heap2");
                    int whichHeap2=input.nextInt();
                    System.out.println("Please enter the element that you want to search in Heap"+whichHeap2);
                    int searchElement=input.nextInt();
                    if(whichHeap2==1)
                        heap1.search(searchElement);
                    else if(whichHeap2==2)
                        heap2.search(searchElement);
                    else
                        System.out.println("Please enter a valid number(1 or 2)");
                    break;
                case 3:
                    heap1.merge(heap2);
                    System.out.println("Heap1 is merged with Heap2!");
                    heap1.display();
                    break;
                case 4:
                    System.out.println("Press [1] to Remove ith Largest Element From The Heap1");
                    System.out.println("Press [2] to to Remove ith Largest Element From The Heap2");
                    int whichHeap4=input.nextInt();
                    System.out.println("Please enter the ith max element that you want to remove from Heap"+whichHeap4);
                    int whichMax=input.nextInt();
                    if(whichHeap4==1){
                        heap1.deleteAnyMax(whichMax);
                        heap1.display();
                    }
                    else if(whichHeap4==2){
                        heap2.deleteAnyMax(whichMax);
                        heap2.display();
                    }
                    else
                        System.out.println("Please enter a valid number(1 or 2)");
                    break;
                case 5:
                    System.out.println("Press [1] to Set an Element of The Heap1 by Using Iterator");
                    System.out.println("Press [2] to Set an Element of The Heap2 by Using Iterator");
                    int whichHeap5=input.nextInt();
                    System.out.println("Please enter the index of element that you want to set in Heap"+whichHeap5);
                    int index=input.nextInt();
                    System.out.println("Please enter the new element of "+index+".Index");
                    int newElement=input.nextInt();
                    
                    if(whichHeap5==1){
                        ClassicHeapIterator iterator=new ClassicHeapIterator(heap1);
                        iterator.set(newElement,index);
                        
                    }
                    else if(whichHeap5==2){
                        ClassicHeapIterator iterator=new ClassicHeapIterator(heap2);
                        iterator.set(newElement,index);
                    }
                    else
                        System.out.println("Please enter a valid number(1 or 2)");
                    break;
                    
                case 6:
                    loopController--;
                    break;
                default:
                    System.out.println("Please enter a valid number between 1-6");
                    break;   
            }       
        }
        System.out.println("Terminating Program...");     
    }
    
}
