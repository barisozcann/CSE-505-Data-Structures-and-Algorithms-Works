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
public class Branch {
    private String branchName;
    //private Furniture[] furniture=new Furniture[15];

    private KWArrayList<Furniture> furniture=new KWArrayList<Furniture>();
    private int furnitureCounter=0; //This integer counts number of furnitures in the branch

  
    
    /**
     * 
     * @param branchName 
     * Constructor method only needs a Branch name
     */
    
    public Branch(String branchName) 
    {
        this.branchName=branchName;
    }
    
    
    
    /**
     * 
     * @param furniture 
     * This methods adds a furniture object to furniture array of Branch object class
     * It uses addlast method of arraylist
     */
    
    public void addFurniture(Furniture furniture) { //This method is //Ɵ(1) constant time
        this.furniture.add(furniture); //Ɵ(1) constant time
        furnitureCounter++; //Ɵ(1) constant time
    }
    /**
     * @param name is name of furniture
     * @param model is model of furniture
     * This method search for a furniture in the furniture array to remove wit specific name and model
     */
    public void removeFurniture(String name,String model) { //This method is O(n^2) quadratic time
        if(this.furnitureCounter==0) { //Ɵ(1) constant time
            System.out.println("There is no product to remove!"); //Ɵ(1) constant time
        }
        
        else {
            for(int i=0;i<this.furnitureCounter;i++) {  //O(n) linear time
               //Incrementing int i until the value of furnitureCounter in order to prevent null pointer error
                String localName=this.furniture.get(i).getName(); //Ɵ(1) constant time
                String localModel=this.furniture.get(i).getModel(); //Ɵ(1) constant time
                if(localName.equals(name) && localModel.equals(model)) //Ɵ(1) constant time
                {
                    this.furniture.remove(i); //O(n) linear time
                    this.furnitureCounter--;  //Ɵ(1) constant time
                    //Decreasing furnitureCounter because one furniture product removed
                    System.out.println("The product is removed"); //Ɵ(1) constant time 
                    return; //Ɵ(1) constant time
                }
            }
            System.out.println("Furniture you want to remove does not exist in "+this.branchName); //Ɵ(1) constant time
      }
    }
    
    /**
     * 
     */
    
    public void showAllStock() //O(n) linear time
    {
        if(this.furnitureCounter==0) //Ɵ(1) constant time
        {
            System.out.println("There is no product in "+this.branchName); //Ɵ(1) constant time
        }
        
        else
        {
            for(int i=0;i<this.furnitureCounter;i++) //O(n) linear time
            {
                Furniture localFurniture=this.furniture.get(i); //Ɵ(1) constant time
                String localName=localFurniture.getName(); //Ɵ(1) constant time
                String localModel=localFurniture.getModel(); //Ɵ(1) constant time
                double localPrice=localFurniture.getPrice(); //Ɵ(1) constant time
                KWArrayList<String> localColor=localFurniture.getColors(); //Ɵ(1) constant time
                KWArrayList<Integer> localQuantity=localFurniture.getQuantity(); //Ɵ(1) constant time
                System.out.println(i+"- "+localName+" "+localModel+" is available in the stock. "
                        +"Colors: "+localColor.toString()+" ,Quantities with respect to the colors: "
                        +localQuantity.toString()); //Ɵ(1) constant time
                System.out.println("Unit Price: "+localPrice); //Ɵ(1) constant time
                System.out.println("-------------------------------"); //Ɵ(1) constant time
           }
        }
    }
    
    
    /**
     * @param name is name of furniture
     * @param model is model of furniture
     * This method search for a furniture in the branch
     * If it finds that specific furniture, give stock number of that product
     */
    public void queryFurniture(String name,String model) { //This method is //Ɵ(n) linear time
        if(this.furnitureCounter==0) { //Ɵ(1) constant time
            System.out.println("There is no product to query in the Stock of "+this.branchName+" !"); //Ɵ(1) constant time
        }
        
        else {
            int j=0;
            for(int i=0;i<this.furnitureCounter;i++){ //Ɵ(n) linear time
                //Incrementing int i until the value of furnitureCounter in order to prevent null pointer error
                String localName=this.furniture.get(i).getName(); //Ɵ(1) constant time
                String localModel=this.furniture.get(i).getModel(); //Ɵ(1) constant time
                KWArrayList<String> localColor=this.furniture.get(i).getColors(); //Ɵ(1) constant time
                KWArrayList<Integer> localQuantity=this.furniture.get(i).getQuantity(); //Ɵ(1) constant time
                
                if(localName.equals(name)&& localModel.equals(model)) { //Ɵ(1) constant time
                        System.out.println(localName+" "+localModel+" is available in the stock of "+this.branchName+ 
                                " Colors: "+localColor.toString()+
                                ", Quantities with respect to the colors: "+localQuantity.toString());//Ɵ(1) constant time
                        j++; //Ɵ(1) constant time
                    }
                }
            if(j==0){ //Ɵ(1) constant time
                System.out.println("Sorry, product is not available in "+this.branchName); //Ɵ(1) constant time
            }
            }
    }
    
    
    
    /**
     * 
     * @param customer
     * @param customersPhoneNumber
     * @param customersAdress
     * @param productIndex is index of furniture in the furniture array
     * @param orderQuantity
     * @param colorIndex is index of color in the color array. Red=0,Blue=1,Black=2,Grey=3,White=4
     * When a customer want to buy a product, employee or the customer should call this method to execute buying transaction
     */
    public void sell(Customer customer,String customersPhoneNumber,String customersAdress ,int productIndex,int orderQuantity, int colorIndex)
    { //This method is Ɵ(n) linear time
        if(this.furnitureCounter!=0) //Ɵ(1) constant time
        {
            try
            {
                String productName=this.furniture.get(productIndex).getName(); //Ɵ(1) constant time
                String productModel=this.furniture.get(productIndex).getModel(); //Ɵ(1) constant time
                KWArrayList<String> productColors=this.furniture.get(productIndex).getColors(); //Ɵ(1) constant time
                KWArrayList<Integer> productQuantities=this.furniture.get(productIndex).getQuantity(); //Ɵ(1) constant time
                double productPrice=this.furniture.get(productIndex).getPrice(); //Ɵ(1) constant time
            
                int productQuantity=productQuantities.get(colorIndex); //Ɵ(n) linear time
                String productColor=productColors.get(colorIndex); //Ɵ(n) linear time
            
                if(productQuantity==0) //Ɵ(1) constant time
                {
                    System.out.println("The product you want is not available in stock");//Ɵ(1) constant time
                }
                else if(orderQuantity>productQuantity) //Check if stocknumber of the product is enough
                {
                    System.out.println("Sorry, there is/are only "+productQuantity+" "+productColor+" "+productName+" "+productModel+" in the stock"); //Ɵ(1) constant time
                }
                else
                {
                    this.furniture.get(productIndex).setQuantity(colorIndex, productQuantity-orderQuantity); //Ɵ(n) linear time
                    System.out.println("You bought "+orderQuantity+" "+productColor+" "+productName+". Total price: "+productPrice*orderQuantity); //Ɵ(1) constant time
                    String customersId=customer.getRealCustomerId(); //Ɵ(n) linear time
                    String orderName=productColor+" "+productName; //Ɵ(1) constant time
                    customer.addOrder(new Order(customersId,customersPhoneNumber,customersAdress,orderName,orderQuantity)); //Ɵ(1) constant time
                }
            
        }catch(ArrayIndexOutOfBoundsException e) //Ɵ(1) constant time
        {
            System.out.println("An error occurred: "+e); //Ɵ(1) constant time
            System.out.println("Please be sure that you enter a valid product index"); //Ɵ(1) constant time
        }catch(Exception e){ //Ɵ(1) constant time
            System.out.println("An error occurred: "+e); //Ɵ(1) constant time
        }
        }
        else
        {
            System.out.println("There is no product to sell!"); //Ɵ(1) constant time
            //If the furnitureCounter=0, the method gives that message
        }
    }
    
   
    
    
    /**
     * 
     * @param index is index of the furniture in furniture array
     * @param colorIndex
     * @param number is amount of furniture that we want to increase
     */
    
    public void increaseQuantity(int index,int colorIndex,int number)
        { //This method is O(n) linear time
              if(this.furnitureCounter!=0) //Ɵ(1) constant time
              {
                try
                {
                    int localQuantity=this.furniture.get(index).getQuantity(colorIndex); //O(n) linear time
                  this.furniture.get(index).setQuantity(colorIndex, localQuantity+number); //O(n) linear time
                  
                }
              catch(Exception e){ //Ɵ(1) constant time
                  System.out.println("An error occurred: "+e); //Ɵ(1) constant time
              }
            }
               else
            {
            System.out.println("There is no product to increase its quantity!"); //Ɵ(1) constant time
            }
        }
    
     
    
    /**
     * 
     * @param index is index of the furniture in furniture array
     * @param colorIndex
     * @param number is amount of furniture that we want to decrease
     */
    
    public void decreaseQuantity(int index,int colorIndex,int number){ //This method is O(n) linear time in worst case
            if(this.furnitureCounter!=0) //Ɵ(1) constant time
            {
                try
                {
                    int localQuantity=this.furniture.get(index).getQuantity(colorIndex); //O(n) linear time
                    if(number>localQuantity) //Ɵ(1) constant time
                    {
                        System.out.println("The you can't decrease the number of the product that amount!"); //Ɵ(1) constant time
                    }
                    
                    else
                    {
                        this.furniture.get(index).setQuantity(colorIndex, localQuantity-number); //O(n) lineartime
                    }
                  
                }
                catch(Exception e)
                {
                    System.out.println("An error occurred: "+e); //Ɵ(1) constant time
                }
            }
            else
            {
                System.out.println("There is no product to decrease its quantity!");//Ɵ(1) constant time
            }
    }

    public String getBranchName() {
        return branchName;
    }

    public int getFurnitureCounter() {
        return furnitureCounter;
    }

    /*public Furniture[] getFurniture() {
        return furniture;
    }*/

    public KWArrayList<Furniture> getFurniture() {
        return furniture;
    }
}
