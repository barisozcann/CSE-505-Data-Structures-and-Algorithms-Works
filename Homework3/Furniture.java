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
    //private String[] colors={"Red","Red","Black","Grey","White"};
    private KWArrayList<String> colors=new KWArrayList<String>(5);



    //private int quantity[]=new int[5]; //There 5 corresponding stocknumber with colors. Red=index0,Blue=index1=Black=index2,Grey=index3,White=index4
    private KWArrayList<Integer> quantity=new KWArrayList<Integer>(5);
    private double price;

    /**
     * 
     * @param name
     * @param model
     * @param price
     * @param quantity 
     * This is constructor method
     */
    public Furniture(String name, String model,double price,KWArrayList<Integer> quantity)
    {
        this.name = name;
        this.model = model;
        this.price = price;
        this.quantity=quantity;

        colors.add("Red");
        colors.add("Blue");
        colors.add("Black");
        colors.add("Grey");
        colors.add("White");
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


    /*public String[] getColors()
    {
        return colors;
    }



    public void setColors(String[] colors) 
    {
        this.colors = colors;
    }*/

    public KWArrayList<String> getColors() {
        return colors;
    }

    public void setColors(KWArrayList<String> colors) {
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

    /*public int[] getQuantity()
    {
        return quantity;
    }*/

     /**
     * @param quantity is quantity array with respect to colors
     */
    public void setQuantity(KWArrayList<Integer> quantity)
    {
        this.quantity = quantity;
    }


    public KWArrayList<Integer> getQuantity() {
        return quantity;
    }

    public int getQuantity(int index) {
        return quantity.get(index);
    }

    /**
     * 
     * @param index is index of color with respect to quantity array
     * This method changes the stocknumber of furniture with specific color
     * @param number 
     */
    
    public void setQuantity(int index,int number) 
    { //This method is O(n) linear time
        this.quantity.set(index,number); //O(n) linear time
    }

    @Override
    public String toString() {
        return "Furniture{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", colors=" + colors +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
