/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package main;

import java.util.Arrays;

/**
 *
 * @author Baris Ozcan 215008003003
 */
public class Furniture {
    private String name;
    private String model;
    private String[] colors={"Red","Blue","Black","Grey","White"};
    private double price;
    private int quantity[]=new int[5]; //There 5 corresponding stocknumber with colors. Red=index0,Blue=index1=Black=index2,Grey=index3,White=index4

    /**
     * 
     * @param name
     * @param model
     * @param price
     * @param quantity 
     * This is constructor method
     */
    public Furniture(String name, String model,double price,int[] quantity) 
    {
        this.name = name;
        this.model = model;
        this.price = price;
        this.quantity=quantity;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getModel() 
    {
        return model;
    }

    public void setModel(String model) 
    {
        this.model = model;
    }

    public String[] getColors() 
    {
        return colors;
    }

    public void setColors(String[] colors) 
    {
        this.colors = colors;
    }

    public double getPrice() 
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public int[] getQuantity() 
    {
        return quantity;
    }

     /**
     * @param quantity is quantity array with that corresponds to colors
     */
    public void setQuantity(int[] quantity) 
    {
        this.quantity = quantity;
    }
    
    
    /**
     * 
     * @param index is index of color with respect to quantity array
     * This method changes the stocknumber of furniture with specific color
     * @param number 
     */
    
    public void setQuantity(int index,int number) 
    { //Overloading
        this.quantity[index]=number;
    }

    @Override
    public String toString() {
        return "Furniture{" + "name=" + name + ", model=" + model  + ", price=" + price + ", colors=" + Arrays.toString(colors)+", quantities with respect to colors=" +Arrays.toString(quantity) + '}';
    }

    


    
    

   
}
