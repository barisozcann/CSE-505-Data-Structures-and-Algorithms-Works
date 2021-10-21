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
public class ClassicHeapIterator implements Iterator<Object>{

    private int nextItem;
    private int lastItemReturned;
    private int index=1;
    private ClassicHeap heap=new ClassicHeap();

    /**
     *  This is constructor MEthod of Heap Iterator
     * @param heap is the input heap
     * @param i is index
     */
    
    public ClassicHeapIterator(ClassicHeap heap,int i){
        //Validate i parameter
        this.heap=heap;
        if(i < 1 || i > heap.csize){
            throw new IndexOutOfBoundsException("Ivalid index " + i);
            }
           
            //special case of last item
            if(i == 1){
                index = i;
                lastItemReturned=-1;
                nextItem = heap.data[index];
            }
            else if(i>heap.csize){
                System.out.println("Index is out of Heap");
                
            }
            else{
                index=i;
                nextItem=heap.data[index];
                lastItemReturned=heap.data[index-1];
            }
        }
        
        
    /**
     * @overloading
     * @param heap 
     * If there is no index declared, iterator starts from index 1
     */
    public ClassicHeapIterator(ClassicHeap heap) //Iterator stars from beginning if no index is declared
        {
            this.heap=heap;
            index=1; 
            nextItem=heap.data[index];
            lastItemReturned=-1;
            
        }
        
        /**
         * 
         * @return 
         * Time complexity: O(1)
         */
        @Override
        public boolean hasNext() {
            return nextItem!=-1; // if element is not equal to -1 then go on
        }

        /**
         * * Time complexity: O(1)
         * @return 
         */
        
        @Override
        public Object next() {
            System.out.println(nextItem);
            if(!hasNext()) //if there is no element to return, throw an exception
               throw new NoSuchElementException();
            index++;
            lastItemReturned = nextItem;
            nextItem = heap.data[index];
            return lastItemReturned;
        }

        @Override
        public void remove() {
            Iterator.super.remove(); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void forEachRemaining(Consumer<? super Object> action) {
            Iterator.super.forEachRemaining(action); //To change body of generated methods, choose Tools | Templates.
        }
        
       /**
        * Set method with index
        * @param setIndex
        * @param element 
        * * Time complexity: O(n)
        */
        public ClassicHeap set(int element,int setIndex){
            for(int i=0;i<setIndex;i++)
                next();
            nextItem=element;
            heap.data[index]=nextItem;
            return heap;
        }
        
        
        /**
         * Set method without index
         * Overloading
         * @param element 
         * * Time complexity: O(1)
         */
        public ClassicHeap set(int element){
            nextItem=element;
            heap.data[index]=nextItem;
            return heap;
        }
    
}
