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
    private Furniture[] furniture=new Furniture[15];
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
     * This methods adds a furniture object to furniture array of Branch Class
     */
    
    public void addFurniture(Furniture furniture)
    {
        if(furnitureCounter<this.furniture.length)
        {
            this.furniture[this.furnitureCounter]=furniture;
            System.out.println("Furniture is added");
            System.out.println(furniture.toString());
            furnitureCounter++;
        }
        else
        {
            System.out.println("You can't add any product because the stock is full!");
        }
        
    }
    /**
     * @param name is name of furniture
     * @param model is model of furniture
     * This method search for a furniture in the furniture array to remove by taking name and model
     */
    public void removeFurniture(String name,String model)
    {
        if(this.furnitureCounter==0)
        {
            System.out.println("There is no product to remove!");
        }
        
        else 
        {
            while(true)
            {
            int j=0; //If we find a furniture, we will increment integer j
        
            for(int i=0;i<this.furnitureCounter;i++) //Incrementing int i until the value of furnitureCounter in order to prevent null pointer error
            {
                String localName=this.furniture[i].getName();
                String localModel=this.furniture[i].getModel();
                if(localName.equals(name) && localModel.equals(model) && i==(this.furnitureCounter-1))
                {
                    this.furniture[i]=null;
                    this.furnitureCounter--; //Decreasing furnitureCounter because one furniture product removed
                    System.out.println("The product is removed");
                    j++;
                    break;
                }
                else if (localName.equals(name) && localModel.equals(model) && i<(this.furnitureCounter-1))
                {
                    int lastIndexCounter=0;
                    for(int k=i;k<(this.furnitureCounter-1);k++)
                    {
                        this.furniture[k]=this.furniture[k+1];
                        lastIndexCounter=k+1;
                    }
                this.furniture[lastIndexCounter]=null;
                System.out.println("The product is removed");
                this.furnitureCounter--; //Decreasing furnitureCounter because one furniture product removed
                j++;
                break;
                }
            }
        
        if(j==0)
        {
            System.out.println("The product that you try to remove doesn't exist in "+this.branchName);
            break;
        }
        break;
        }
      }
    }
    
    public void showAllStock()
    {
        if(this.furnitureCounter==0)
        {
            System.out.println("There is no product in "+this.branchName);
        }
        
        else
        {
            for(int i=0;i<this.furnitureCounter;i++)
            {
                Furniture localFurniture=this.furniture[i];
                String localName=localFurniture.getName();
                String localModel=localFurniture.getModel();
                double localPrice=localFurniture.getPrice();
                String[] localColor=localFurniture.getColors();
                int[] localQuantity=localFurniture.getQuantity();
                System.out.println(i+"- "+localName+" "+localModel+" is available in the stock. "+"Colors: "+Arrays.toString(localColor)+" ,Quantities with respect to the colors: "+Arrays.toString(localQuantity));
                System.out.println("Unit Price: "+localPrice);
                System.out.println("-------------------------------");
           }
        }
    }
    
    
    /**
     * @param name is name of furniture
     * @param model is model of furniture
     * This method search for a furniture in the branch
     * If it finds that specific furniture, give stock number of that product
     */
    public void queryFurniture(String name,String model)
    {
        while(true)
        {
            int j=0;
            if(this.furnitureCounter==0)
            {
                System.out.println("There is no product to query in the Stock of "+this.branchName+" !");
                j++;
            }
        
            else
            {
                for(int i=0;i<this.furnitureCounter;i++) //Incrementing int i until the value of furnitureCounter in order to prevent null pointer error
                {
                    String localName=this.furniture[i].getName();
                    String localModel=this.furniture[i].getModel();
                    String[] localColor=this.furniture[i].getColors();
                    int[] localQuantity=this.furniture[i].getQuantity();
                
                    if(localName.equals(name)&& localModel.equals(model))
                    {
                        System.out.println(localName+" "+localModel+" is available in the stock of "+this.branchName+" Colors: "+Arrays.toString(localColor)+", Quantities with respect to the colors: "+Arrays.toString(localQuantity)); 
                        j++;
                        break;
                    }
                }
            }
        if(j==0)
        {
            System.out.println("Sorry, the product is not available in the stock of "+this.branchName);
            break;
        }
        break;
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
     * When a customer wants to buy a product, employee or the customer should call this method to execute buying transaction
     */
    public void sell(Customer customer,String customersPhoneNumber,String customersAdress ,int productIndex,int orderQuantity, int colorIndex)
    {
        if(this.furnitureCounter!=0)
        {
            try
            {
                String productName=this.furniture[productIndex].getName();
                String productModel=this.furniture[productIndex].getModel();
                String[] productColors=this.furniture[productIndex].getColors();
                int[] productQuantities=this.furniture[productIndex].getQuantity();
                double productPrice=this.furniture[productIndex].getPrice();
            
                int productQuantity=productQuantities[colorIndex];
                String productColor=productColors[colorIndex];
            
                if(productQuantity==0)
                {
                    System.out.println("The product you want is not available in stock");;
                }
                else if(orderQuantity>productQuantity) //Check if stocknumber of the product is enough
                {
                    System.out.println("Sorry, there is/are only "+productQuantity+" "+productColor+" "+productName+" "+productModel+" in the stock");
                }
                else
                {
                    this.furniture[productIndex].setQuantity(colorIndex, productQuantity-orderQuantity);
                    System.out.println("You bought "+orderQuantity+" "+productColor+" "+productName+". Total price: "+productPrice*orderQuantity);
                    String customersId=customer.getRealCustomerId();
                    String orderName=productColor+" "+productName;
                    customer.addOrder(new Order(customersId,customersPhoneNumber,customersAdress,orderName,orderQuantity));
                }
            
        }catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("An error occurred: "+e);
            System.out.println("Please be sure that you enter a valid product index");
        }catch(Exception e){
            System.out.println("An error occurred: "+e);
        }
        }
        else
        {
            System.out.println("There is no product to sell!"); //If the furnitureCounter=0, the method gives that message
        }
    }
    
   
    
    
    /**
     * 
     * @param index is index of the furniture in furniture array
     * @param colorIndex
     * @param number is amount of furniture that we want to increase
     */
    
    public void increaseQuantity(int index,int colorIndex,int number)
        {
              if(this.furnitureCounter!=0)
              {
                try
                {
                  int localQuantity=this.furniture[index].getQuantity()[colorIndex];
                  this.furniture[index].setQuantity(colorIndex, localQuantity+number);
                  
                }
              catch(Exception e){
                  System.out.println("An error occurred: "+e);
              }
            }
               else
            {
            System.out.println("There is no product to increase its quantity!");
            }
        }
    
     
    
    /**
     * 
     * @param index is index of the furniture in furniture array
     * @param colorIndex
     * @param number is amount of furniture that we want to decrease
     */
    
    public void decreaseQuantity(int index,int colorIndex,int number)
    {
            if(this.furnitureCounter!=0)
            {
                try
                {
                    int localQuantity=this.furniture[index].getQuantity()[colorIndex];
                    if(number>localQuantity)
                    {
                        System.out.println("The you can't decrease the number of the product that amount!");
                    }
                    
                    else
                    {
                        this.furniture[index].setQuantity(colorIndex, localQuantity-number);
                    }
                  
                }
                catch(Exception e)
                {
                    System.out.println("An error occurred: "+e);
                }
            }
            else
            {
                System.out.println("There is no product to decrease its quantity!");
            }
    }

    public String getBranchName() {
        return branchName;
    }
    
      
  
    
}
