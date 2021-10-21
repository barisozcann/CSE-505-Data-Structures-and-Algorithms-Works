/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package main;

/**
 *
 * @author Baris Ozcan 215008003003
 */
public class Order {
    private String customersId,
            customersPhoneNumber,
            customersAdress,
            orderName;
    private String situation="Packing"; //Ofcouse this is the first situation of an order
    private int orderQuantity;
    
    
    /**
     * This is constructor method
     * @param customersId
     * @param customersPhoneNumber
     * @param customersAdress
     * @param orderName
     * @param orderQuantity 
     */
    public Order(String customersId, String customersPhoneNumber, String customersAdress, String orderName, int orderQuantity) {
        this.customersId = customersId;
        this.customersPhoneNumber = customersPhoneNumber;
        this.customersAdress = customersAdress;
        this.orderName = orderName;
        this.orderQuantity = orderQuantity;
    }

    public String getOrderName() {
        return orderName;
    }
    

    
    
    

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    @Override
    public String toString() {
        return "Order{" + "customersId=" + customersId + ", customersPhoneNumber=" + customersPhoneNumber + ", customersAdress=" + customersAdress + ", orderName=" + orderName + ", situation=" + situation + ", orderQuantity=" + orderQuantity + '}';
    }

    

    
    
    
    
    
    
}
