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
public class UserDatabase {
    //private BranchEmployee[] branchEmployeeArray=new BranchEmployee[100]; //The array can take 100 different Branch Employees
    private KWArrayList<BranchEmployee> branchEmployeeArray=new KWArrayList<BranchEmployee>();
    private int branchEmployeeCounter=0;

      
    //private Customer[] customerArray=new Customer[1000]; //The array can take 1000 different customers

    private KWArrayList<Customer> customerArray=new KWArrayList<Customer>();
    private int customerCounter=0;
    
    private final int userIdConstant=1000; //Thanks to this constant every customer has different id by adding their index number to it.
    
    /**
     * 
     * @param customer 
     * This method uses addLast method of arraylist
     */
    public void addCustomer(Customer customer) { //This method is //Ɵ(1) constant time
        this.customerArray.add(customer); //Ɵ(1) constant time
        System.out.println("Customer "+(this.customerCounter+userIdConstant)+" is added to the DataBase"); //Ɵ(1) constant time
        this.customerCounter++;//Ɵ(1) constant time
    }
    
    
     /**
     * @param customerMail is mail of customer
     * So if admin or employee wants to remove a customer, he/she must enter customer's mail
     * Ofcourse only admin and employee can call this method
     * This method use for loop with integer i by the help of customerCounter that counts number of all customers
     */
    
    public void removeCustomer(String customerMail) { //This method is O(n^2) quadratic time

        if (this.customerCounter == 0) { //Ɵ(1) constant time
            System.out.println("There is no customer to remove in database!"); //Ɵ(1) constant time
            return; //Ɵ(1) constant time
        }
        else {
            for (int i = 0; i < this.customerCounter; i++) { //Ɵ(n) linear time
                String localCustomerMail = this.customerArray.get(i).getCustomerMail(); //Ɵ(1) constant time
                if (localCustomerMail.equals(customerMail)) { //Ɵ(1) constant time
                    this.customerArray.remove(i); //O(n) linear time
                    System.out.println("Customer, whose mail is " + customerMail + " has removed from the DataBase"); //Ɵ(1) constant time
                    this.customerCounter--; //Ɵ(1) constant time
                    //Decrementing customer counter
                    return; //Ɵ(1) constant time
                }
            }
            System.out.println("Customer, whose mail is "+customerMail+" doesn't exist in database"); //Ɵ(1) constant time
        }
    }
   
    /**
     * 
     * @param customerId is Id number of customer
     * @param password is password of customer
     * @return true if both of them are correct
     * This method check if customer id and password are both true
     */
    
    public boolean loginCustomer(String customerId,String password) { //This method is O(n) linear time
        if(this.customerCounter!=0) { //Ɵ(1) constant time
            for(int i=0;i<this.customerCounter;i++) { //O(n) linear time
                if (customerId.equals(this.customerArray.get(i).getRealCustomerId()) 
                        && password.equals(this.customerArray.get(i).getCustomerPassword())) {//Ɵ(1) constant time
                    return true;//Ɵ(1) constant time
                }
            }
        }
        return false;//Ɵ(1) constant time
    }
    
    
    /**
     * 
     * @param customerMail 
     */
    public void showCustomerInfo(String customerMail) {
        if(this.customerCounter!=0){
            for(int i=0;i<this.customerCounter;i++) {
                if (customerMail.equals(this.customerArray.get(i).getCustomerMail())) {
                    this.customerArray.get(i).showUserInfo();
                    return;
                }
            }
            System.out.println("The customer, whose mail is "+customerMail+" doesn't exist in the database");
        }

        else if(this.customerCounter==0) {
            System.out.println("There is no customer in Database yet");
        }
    
    }
    
    /**
     * 
     * @param customerMail is mail of customer
     * 
     * 
     */
    
    public int getCustomerIndex(String customerMail)
    {
        if(this.customerCounter!=0) {
            for(int i=0;i<this.customerCounter;i++) {
                if (customerMail.equals(this.customerArray.get(i).getCustomerMail())) {
                    return i;
                }
            }
            System.out.println("The customer doesn't exist in the Database");
            return -1;
        }

        else if(this.customerCounter==0)
        {
            System.out.println("There is no customer in Database yet");
            return -1;
        }
        else
        {
            return -1;
        }
    }
    
    public void showAllCustomer()
    { //This method is O(n) linear time
        if(customerCounter==0) //Ɵ(1) constant time
        {
            System.out.println("There is no Customer to show");  //Ɵ(1) constant time
        }
        else
        {
            for(int i=0;i<customerCounter;i++) //Ɵ(n) linear time
            {
                this.customerArray.get(i).showUserInfo(); //Ɵ(1) constant time
            }
        }
    }


    public KWArrayList<Customer> getCustomerArray() {
        return customerArray;
    }

    /**
     * 
     * @param branchEmployee 
     * this method uses addLast Method
     */
    
    public void addEmployee(BranchEmployee branchEmployee)
    { //This method is Ɵ(1) constant time
        this.branchEmployeeArray.add(branchEmployee); //Ɵ(1) constant time
        System.out.println("Employee "+(this.branchEmployeeCounter+userIdConstant)+" is added to the DataBase"); //Ɵ(1) constant time
        this.branchEmployeeCounter++; //Ɵ(1) constant time
        //incrementing branch employee counter
    }
    
    /**
     *
     * @param employeeMail is mail of employee
     * Only admin is able to use this method
     * This method takes mail input and compares with all employees mail
     * So it makes search operating in BranchEmployeeArray to find and remove the employee
     */
    public void removeEmployee(String employeeMail) { //This method is O(n^2) quadratic time

        if(this.branchEmployeeCounter==0){ //Ɵ(1) constant time
            System.out.println("There is no Branch Employee to remove!"); //Ɵ(1) constant time
            return;
        }

        else{
            for(int i=0;i<this.branchEmployeeCounter;i++) { //Ɵ(n) linear time
                String localEmployeeMail=this.branchEmployeeArray.get(i).getEmployeeMail(); //Ɵ(1) constant time
                    if(localEmployeeMail.equals(employeeMail)) {//Ɵ(1) constant time
                        this.branchEmployeeArray.remove(i); //O(n) constant time
                        System.out.println("Employee, whose mail is "+employeeMail+" has removed from Database");
                        this.branchEmployeeCounter--; //decrementing employee counter because method remove one employee
                        return; //Ɵ(1) constant time
                    }
                }
            System.out.println("Branch Employee, whose mail is "
                    +employeeMail
                    +" doesn't exist in database!"); //Warning message if the user doesn't exit in the database
            }
        
    }
    
   /**
    * 
    * @param employeeId
    * @param password
    * @return 
    * This method checks if employeeId and password are both correct
    */
    public boolean loginEmployee(String employeeId,String password) { //This method is Ɵ(n) linear time
        if(this.branchEmployeeCounter!=0) { //Ɵ(1) constant time
            for(int i=0;i<this.branchEmployeeCounter;i++) { //Ɵ(n) linear time
                if (employeeId.equals(this.branchEmployeeArray.get(i).getRealEmployeeId()) 
                        && password.equals(this.branchEmployeeArray.get(i).getEmployeePassword())) { //Ɵ(1) constant time
                    return true; //Ɵ(1) constant time
                }
            }
        }
        return false; //Ɵ(1) constant time
    }
   
   /**
    * 
    * @param employeeMail 
    * This method searchs for a specific employee by using a string mail input
    * Shows all informations of the employee
    */
    
    public void showEmployeeInfo(String employeeMail){
        if(this.branchEmployeeCounter!=0){
            for(int i=0;i<this.branchEmployeeCounter;i++) {
                if (employeeMail.equals(this.branchEmployeeArray.get(i).getEmployeeMail())) {
                    this.branchEmployeeArray.get(i).showUserInfo();
                    return;
                }
            }
            System.out.println("The employee, whose mail is "+employeeMail+" doesn't exist in the database");
        }

        else if(this.customerCounter==0)
        {
            System.out.println("There is no Employee in Database yet");
        }
       
    
    }


    public KWArrayList<BranchEmployee> getBranchEmployeeArray() {
        return branchEmployeeArray;
    }

    /**
    * Shows all employees in employee array
    */
    public void showAllEmployee() { //This method is O(n) linear time
        if(branchEmployeeCounter==0) {  //Ɵ(1) constant time
            System.out.println("There is no Employee to show"); //Ɵ(1) constant time
        }
        else {
            for(int i=0;i<branchEmployeeCounter;i++) { //Ɵ(n) linear time
                this.branchEmployeeArray.get(i).showUserInfo(); //Ɵ(1) constant time
            }
        }
    }
    
    
}
