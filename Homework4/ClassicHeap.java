/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.*;
import java.util.function.Consumer;

/**
 *
 * @author baris
 */
public class ClassicHeap {
    
    protected int data[];
    protected int maxsize;
    int csize;

    /**
     * This is constructor Method
     * Max size declares the size of Array (20)
     * csize declares current size of Heap
     * data is the Array that we're using to simulate a Heap
     * Heap starts from index 1. So index 0 is always empty in Array. 
     * All empty slots in array is signed as -1
     */
    
    public ClassicHeap(){
        maxsize=20;
        data=new int[maxsize];
        csize=0;
        for(int i=0;i<maxsize;i++) //Assign -1 to empyt slots in Heap
            data[i]=-1;
    }

    
    /**
     * 
     * @return size of Array
     * Time complexity: O(1)
     */
    public int length(){
        return csize;
    }

    /**
     * 
     * @return checks if the array is empty
     * Time complexity: O(1)
     */
    
    public boolean isEmpty(){
        return csize==0;
    }

   /**
     * 
     * @return checks if the array is full
     * Time complexity: O(1)
     */
    
    public boolean isFull(){
        return csize==maxsize;
    }

    /**
     * 
     * @param e is the element that is inserting in the heap by user
     * Time Complexity: O(n*logn)
     */
    
    public void insert(int e){
        if(isFull()){
            System.out.println("No Space in Heap!");
            return;
        }
        csize++;
        int hi=csize;
        while(hi>1 && e>data[hi/2]){ //Swap if bigger than parent. Up-Heap Bubbling
            data[hi]=data[hi/2];
            hi/=2;
        }
        data[hi]=e;
    }

    
    /**
     * @return is deleted element
     * This method deletes the maximum element of heap
     * Time complexity: O(n*logn)
     */
    
    public int deleteMax(){
        if(isEmpty()){
            System.out.println("Heap is Empty");
            return -1;
        }
        int e=data[1];
        data[1]=data[csize]; //Assigning last element to the root node
        data[csize]=-1; //-1 means last elements slot is empyt
        csize--; //decrementing current size
        int i=1; //This variable represents the parent node
        int j=i*2; //This variable represents the child node of parent node above
        while(j<=csize){ ///Down-Heap Bubbling operation
            if(data[j]<data[j+1])
                j=j+1;
            if(data[i]<data[j]){ //checks if parent node is less than child node
                int temp=data[i];
                data[i]=data[j];
                data[j]=temp;
                i=j; //parent node moves to next parent node
                j=i*2; //child node moves to next child node
            }
            else
                break;
        }
        return e;

    }
    
    /**
     * 
     * @param anyMax is the order of maximum element that is entered by user
     * This method removes ith maximum element from Heap by using a Stack
     * Time complexity: O((n^2)*logn)
     */
    
    public void deleteAnyMax(int anyMax){
        if(isEmpty()){ //checks if Heap is empyt
            System.out.println("Heap is Empty");
            return;
        }
        else if(anyMax<=0 || anyMax>csize){ //Checks if number is valid
            System.err.println("Please enter a valid number between 1-"+csize);
            return;
        }
        else if(anyMax==1)
            deleteMax();
        else{
            Stack tempStack=new Stack(); //Using Stack for keeping temporary deleted elements
            int tempElement;
            for(int i=1;i<anyMax;i++){
                tempElement=deleteMax();
                tempStack.push(tempElement);
            }
            int deletedElement=deleteMax(); //This is the deleted element
            System.out.println(deletedElement+" is deleted from Heap");
            for(int i=1;i<anyMax;i++){
                insert((int) tempStack.pop()); //putting deleted elements back to heap
            }
        } 
    }
    
    /**
     * This method search an element in Heap an return True if it find the element in the Heap
     * @param element is entered by user
     * @return 
     * This method uses stack for checking elements in the Heap
     * Time complexity: O((n^2)*logn)
     */
    
    public boolean search(int element){
        if(isEmpty()){
            System.out.println("Heap is empty!");
            return false;
        }
        Stack tempStack=new Stack(); //Creating stack to use pusp-pop for checking
        int tempElement=max();
        while(tempElement>element){
            tempElement=deleteMax(); //deleting element from heap for a short time to check
            tempStack.push(tempElement); //Storing temporary deleted element into stack
            if(element==tempElement){
                System.out.println(element+" is founded in Heap");
                while(!tempStack.isEmpty())
                    insert((int) tempStack.pop()); //putting elements back to the Heap
                return true;
            }
        }
        System.out.println(element+" is not founded in Heap");
        while(!tempStack.isEmpty())
                    insert((int) tempStack.pop());//putting elements back to the Heap
        return false;
    }

    
    /**
     * This method the Heap with another Heap and saves
     * @param secondHeap is the 2nd Heap that is entered by user
     * This method uses stack to take elements of 2nd heap properly
     * Time complexity: O((n^2)*logn)
     */
    public void merge(ClassicHeap secondHeap){
        if(isFull()){
            System.out.println("The first Heap is full. You can't merge!");
            return;
        }
        else if(secondHeap.isEmpty()){
            System.out.println("The second heap is empty!");
            return;
        }
        int tempElement;
        Stack tempStack=new Stack(); //creating stack to keep deleted elements of Heap2
        while(!secondHeap.isEmpty()){
            tempElement=secondHeap.deleteMax();
            tempStack.push(tempElement); //Storing deleted elements of heap2
            insert(tempElement); //inserting deleted elements to heap1
        }
        while(!tempStack.isEmpty())
            secondHeap.insert((int) tempStack.pop()); //putting deleted elements back to heap2
    }
    
    /**
     * 
     * @return maximum element in Heap
     * Time complexity: O(1)
     */
    
    public int max(){
        if(isEmpty()){
            System.out.println("Heap is Empty");
            return -1;
        }
        return data[1];
    }
    

    /**
     * Displays all elements of Heap
     * Time complexity: O(n)
     */
    
    public void display(){
        for(int i=0;i<data.length;i++)
            System.out.print(data[i]+" ");
        System.out.println();
    }


    
    
}
