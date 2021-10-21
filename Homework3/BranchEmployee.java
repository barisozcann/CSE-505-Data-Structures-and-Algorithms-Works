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
public class BranchEmployee implements UserInterface{
    private String employeeName;
    private String employeeSurname;
    private String employeePassword;
    private String employeeMail;
    private static int employeeId=1000;
    private String realEmployeeId;

    /**
     * 
     * @param employeeName
     * @param employeeSurname
     * @param employeePassword
     * @param employeeMail 
     * Constructor method
     */
    
    
    public BranchEmployee(String employeeName, String employeeSurname, String employeePassword, String employeeMail) 
    {
        this.employeeName = employeeName;
        this.employeeSurname = employeeSurname;
        this.employeePassword = employeePassword;
        this.employeeMail = employeeMail;
    }
    /**
     * Inder order to subscribe database, the employee should call a userdatabase
     * @param userdatabase keeps employee's information
     * It uses addlast method
     */
    
    @Override
    public void subscribe(UserDatabase userdatabase) { //This method is //Ɵ(1) constant time
        this.realEmployeeId=String.valueOf(this.employeeId); //Ɵ(1) constant time
        userdatabase.addEmployee(this); //Ɵ(1) constant time
        System.out.println(this.employeeName+" "
                +this.employeeSurname+", you subscribed to the system. Your Employee User Id is: "
                +this.realEmployeeId
        +" Your password is: "+this.employeePassword); //Ɵ(1) constant time
        this.employeeId++; //Ɵ(1) constant time
    }

    /**
     * This is method shows main informations of Employee
     * 
     */
    
    @Override
    public void showUserInfo() 
    {
        System.out.println("Name: "+this.employeeName+" Surname: "+this.employeeSurname+" Password:"+this.employeePassword+" "+"Email: "+this.employeeMail);
    }
    
    /**
     * @param branch is a object of branch
     * This method shows all stock of a Branch
     * 
     */
    public void inquireStock(Branch branch){ //this method is Ɵ(n) constant time
        branch.showAllStock(); //Ɵ(n) linear time time
    }
    
    /**
     * @param branch a Branch object.
     * @param furniture furniture object
     * This method takes a branch and a furniture to add it
     * 
     */
    
    public void addStock(Branch branch,Furniture furniture){ //this method is Ɵ(n) linear time
        branch.addFurniture(furniture); //Ɵ(1) constant time
    }
    
    /**
     * @param branch a Branch object.
     * @param furnitureName is name of furniture
     * @param furnitureModel is model of furniture
     * In order to remove a furniturei employee must enter furniture model and furniture name
     * 
     */
    
   
    
    public void removeStock(Branch branch,String furnitureName,String furnitureModel){ //This method is O(n^2) quadratic time
        branch.removeFurniture(furnitureName, furnitureModel); //O(n^2) quadratic time
    }

    
    
    /**
     * 
     * @param branch
     * @param productIndex is index of product in a specific Branch
     * @param colorIndex
     * @param number is number of product that employee wants to increase
     */
    
    public void increaseStockNumber(Branch branch,int productIndex,int colorIndex,int number)
    { //This method is O(n) linear time
      branch.increaseQuantity(productIndex, colorIndex, number); //O(n) linear time
        
    }
    
    /**
     * 
     * @param branch
     * @param productIndex is index of product in a specific Branch
     * @param colorIndex
     * @param number is number of product that employee wants to decrease
     */
    public void decreaseStockNumber(Branch branch,int productIndex,int colorIndex,int number)
    { //This method is O(n) linear time
        branch.decreaseQuantity(productIndex, colorIndex, number); //O(n) linear time
    }
    
    /**
     * @param customer  a Customer object.
     * @param userDataBase is the database that employee registers customer
     * Thanks to this method employee can add customer when he/she is in the branch
     * 
     */
    
    
    public void subscribeCustomer(Customer customer,UserDatabase userDataBase) 
    {
        customer.subscribe(userDataBase);
        System.out.println("Employee "+this.realEmployeeId+" has enrolled you to the Database");
    }
    
    public void removeCustomer(String customerMail,UserDatabase userDataBase)
    { // this method is O(n) linear time
        userDataBase.removeCustomer(customerMail); //O(n) linear time
    }
            
            
    /**
     * 
     * @param branch a Branch object.
     * @param customer
     * @param customersPhoneNumber
     * @param customersAdress
     * @param productIndex
     * @param orderQuantity is number of product that customer wants to buy
     * @param colorIndex 
     * So, employee must call branch object's sell method because only this method makes change in the branches stock
     */
    
    public void purchaseProduct(Branch branch,Customer customer,String customersPhoneNumber,String customersAdress ,int productIndex,int orderQuantity, int colorIndex)
    { // this method is O(n) linear time
        branch.sell(customer, customersPhoneNumber, customersAdress, productIndex, orderQuantity, colorIndex); //O(n) linear time
    }
    
    
    
    /**
     * 
     * @param customer
     * @param orderIndex is index of order in order array. Every customer has order array.
     * @param orderSituation 
     */
    public void updateOrderSituation(Customer customer,int orderIndex,String orderSituation)
    {//This method is Ɵ(n) linear time
        customer.setOrderSituation(orderIndex, orderSituation); //Ɵ(n) linear time
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) 
    {
        this.employeeName = employeeName;
    }

    public String getEmployeeSurname() {
        return employeeSurname;
    }

    public void setEmployeeSurname(String employeeSurname) 
    {
        this.employeeSurname = employeeSurname;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public void setEmployeePassword(String employeePassword) 
    {
        this.employeePassword = employeePassword;
    }

    public String getEmployeeMail() {
        return employeeMail;
    }

    public void setEmployeeMail(String employeeMail) 
    {
        this.employeeMail = employeeMail;
    }

    public static int getEmployeeId() {
        return employeeId;
    }

    public static void setEmployeeId(int employeeId) 
    {
        BranchEmployee.employeeId = employeeId;
    }

    public String getRealEmployeeId() {
        return realEmployeeId;
    }

    public void setRealEmployeeId(String realEmployeeId) 
    {
        this.realEmployeeId = realEmployeeId;
    }
  
    
}
