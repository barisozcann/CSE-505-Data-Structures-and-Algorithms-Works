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
public class Customer implements UserInterface{
    private String customerName;
    private String customerSurname;
    private String customerPassword;
    private String customerMail;
    private static int customerId=1000; //The first customer id is = 1000. It increments one-by-one when new customers subscribes
    private String realCustomerId; //It keeps customers id with string variable
    
    //private Order[] orders=new Order[20]; //Order Array of customer
    private KWArrayList<Order> orders=new KWArrayList<Order>();
    private int orderCounter=0; //Number of orders

    
    
    /**
     * 
     * @param customerName
     * @param customerSurname
     * @param customerPassword
     * @param customerMail 
     * Constructor Method
     */
    
    public Customer(String customerName, String customerSurname, String customerPassword, String customerMail) {
        this.customerName = customerName;
        this.customerSurname = customerSurname;
        this.customerPassword = customerPassword;
        this.customerMail = customerMail;
    }
    
    
     /**
     * @param userdatabase object
     * This method only need a userdatabase class to register to database
     */
    
    @Override
    public void subscribe(UserDatabase userdatabase) { //This method is //Ɵ(1) constant time
        this.realCustomerId=String.valueOf(this.customerId); //Ɵ(1) constant time
        userdatabase.addCustomer(this); //Ɵ(1) constant time
        System.out.println(this.customerName+" "
                +this.customerSurname+", you subscribed to the system. Your Customer User Id is: "
                +this.realCustomerId
        +" Your password is: "+this.customerPassword); //Ɵ(1) constant time
        this.customerId++; //Ɵ(1) constant time
    }
    
    
    @Override
    public void showUserInfo() {
        System.out.println("Name: "+this.customerName+" Surname: "+this.customerSurname+" Password:"+this.customerPassword+" "+"Email: "+this.customerMail);
    }

    
    /**
     * 
     * @param order 
     * this method uses addlast method
     */
    
    public void addOrder(Order order) 
    {
        this.orders.add(order); //Ɵ(1) constant time
        this.orderCounter++; //Ɵ(1) constant time
    }

    /**
     * This method shows all orders of the customer with indexes
     */
    
    public void checkOrders(){ //This method is O(n) linear time
        int j=0; //Ɵ(1) constant time
        if(orderCounter==0) //Ɵ(1) constant time 
        {
            System.out.println("There is no order"); //Ɵ(1) constant time
        }
        
        
        else
        {
            for(int i=0;i<orderCounter;i++) //O(n) constant time
            {
                System.out.println((i)+"."+this.orders.get(i).toString()); //Ɵ(1) constant time
            }
        }
    }
    
    
    
    /*public Order[] getOrders() {
        return orders;
    }

    public void setOrders(Order[] orders) {
        this.orders = orders;
    }*/

    public void setOrders(KWArrayList<Order> orders) {
        this.orders = orders;
    }

    public KWArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrderSituation(int orderIndex, String orderSituation)
    {
        this.orders.get(orderIndex).setSituation(orderSituation);
    }
    
    
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerSurname() {
        return customerSurname;
    }

    public void setCustomerSurname(String customerSurname) {
        this.customerSurname = customerSurname;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public String getCustomerMail() {
        return customerMail;
    }

    public void setCustomerMail(String customerMail) {
        this.customerMail = customerMail;
    }

    public static int getCustomerId() {
        return customerId;
    }

    public static void setCustomerId(int customerId) {
        Customer.customerId = customerId;
    }

    public String getRealCustomerId() {
        return realCustomerId;
    }

    

    
    
}
