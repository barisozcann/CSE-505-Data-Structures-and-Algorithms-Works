/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package main;

import java.util.Arrays;
import java.util.ListIterator;

/**
 *
 * @author Baris Ozcan 215008003003
 * There is only one admin
 */
public class Administrator{
    private String adminId="admin";
    private String password="123456";

    //private Branch[] branchArray=new Branch[10];
    
    KWLinkedList<Branch> branchList=new KWLinkedList<Branch>();

    private int branchCounter=0;
    
    /**
     * 
     * @param id is just admin
     * @param parola is admin's password
     * @return 
     * Check if admin id and password are both correct
     */
    
    public boolean login(String id,String parola){
        if(this.adminId.equals(id) && this.password.equals(parola))
        {
            System.out.println("You logged in as Administrator");
            return true;
        }
        else{
            System.out.println("Wrong password!");
            return false;
        }
    }

    public String getAdminId() 
    {
        return adminId;
    }

    public String getPassword() 
    {
        return password;
    }

    /*public Branch[] getBranchArray() {
        return branchArray;
    }*/

    public KWLinkedList<Branch> getBranchList() {
        return branchList;
    }

    /**
     * 
     * @param branch 
     * The method adds a new Branch to Branch List
     */
    public void addBranch(Branch branch) { //This method is always Ɵ(1) constant time because it uses addLast method
        this.branchList.addLast(branch); //Ɵ(1) constant time
        System.out.println(branch.getBranchName()+" is added to the system"); //Ɵ(1) constant time
        branchCounter++; //Ɵ(1) constant time

    }
    
    /**
     * 
     * @param branchName 
     * The method removes a new Branch from Branch Linkedlist by taking string Branch name as an input
     */
    public void removeBranch(String branchName) { //This method is O(n) linear time because reaching middle element in linked list is linear
        if(this.branchCounter==0) { //Ɵ(1) constant time
            System.out.println("There is no branch to remove!"); //Ɵ(1) constant time
        } //Ɵ(1) constant time
        
        else {
            ListIterator<Branch> list_Iter = branchList.listIterator(); //Ɵ(1) constant time
            while(list_Iter.hasNext()){ //O(n) linear time time in worst case
                Branch localBranch= list_Iter.next(); //Ɵ(1) constant time
                String localBranchName=localBranch.getBranchName(); //Ɵ(1) constant time
                if(localBranchName.equals(branchName)) {//Ɵ(1) constant time
                    list_Iter.remove();//Ɵ(1) constant time
                    this.branchCounter--; //Ɵ(1) constant time
                    //Decreasing furnitureCounter because one furniture product removed
                    return;//Ɵ(1) constant time
                }
            }
            System.out.println("The branch, whose name is "+branchName+" does not exist in the database"); //Ɵ(1) constant time
        }
    }
    
    /**
     * The method shows all branches in branch list
     */
    
    public void showAllBranch() { //This method is Ɵ(n) linear time
        if(this.branchCounter==0) {//Ɵ(1) constant time
            System.out.println("There is no branch in the system");//Ɵ(1) constant time
        }
        
        else {
            ListIterator<Branch> list_Iter = branchList.listIterator(); //Ɵ(1) constant time
            while(list_Iter.hasNext()){ //Ɵ(n) linear time
                Branch localBranch= list_Iter.next(); //Ɵ(1) constant time
                System.out.println(localBranch.getBranchName()); //Ɵ(1) constant time
            }
        }
    }

    
    
    /**
     * 
     * @param name
     * @param model 
     * This method search a product in all branches in branch list
     * So, search operation checks 2 nested lists which are branch list and furniture list in it
     */
    public void searchProduct(String name,String model) { //This method is Ɵ(n^2) quadratic time
        try {
            if(this.branchCounter==0) { //Ɵ(1) constant time
            System.out.println("There is no Branch to query its stock!"); //Ɵ(1) constant time
            }
        
            else {
                ListIterator<Branch> list_Iter = branchList.listIterator(); //Ɵ(1) constant time
                while (list_Iter.hasNext()) { //Ɵ(n) linear time
                    Branch localBranch = list_Iter.next();//Ɵ(1) constant time
                    localBranch.queryFurniture(name, model); //Ɵ(n) linear time
                }
            }

        
       } catch(Exception e)//Ɵ(1) constant time
       {
           System.out.println("An error occurred: "+e); //Ɵ(1) constant time
       }
    }


   /*



    public void queryProductStock()
    {
        for(int i=0;i<branchCounter;i++)
        {
            Branch localBranch=this.branchArray[i];
            int localFurnitureCounter=localBranch.getFurnitureCounter();
            for(int j=0;j<localFurnitureCounter;j++)
            {
                Furniture localFurniture=this.branchArray[i].getFurniture()[j];
                int[] localProductQuantity=localFurniture.getQuantity();
                String[] localProductColor=localFurniture.getColors();
                for(int k=0;k<localProductQuantity.length;k++)
                {
                    int productNumber=localProductQuantity[k];
                    if(productNumber==0)
                    {
                        String localColor=localProductColor[k];
                        System.out.println("There is no "+localColor+" "+localFurniture.getModel()+
                                " "+localFurniture.getName()+ " in "+this.branchArray[i].getBranchName());
                    }
                }
            }
        }
    }
    */
    

    /**
     * 
     * @param branchIndex is index of branch im branch list
     * This method makes a query to see stock of a specific branch
     */
    public void queryStock(int branchIndex) //This method is O(n) linear time
    {
       try {
            if(this.branchCounter==0) { //Ɵ(1) constant time
            System.out.println("There is no Branch to query its stock!"); //Ɵ(1) constant time
            }
        
            else if(branchIndex<(this.branchCounter)) //Ɵ(1) constant time
            {
                System.out.println(this.branchList.get(branchIndex).getBranchName()); //Ɵ(1) constant time
                this.branchList.get(branchIndex).showAllStock(); //Ɵ(n) linear time
            }
            else if(branchIndex>this.branchCounter) { //Ɵ(1) constant time
                System.out.println("The index you entered is out of range!"); //Ɵ(1) constant time
            }
       } catch(Exception e) //Ɵ(1) constant time
        {
           System.out.println("An error occurred: "+e); //Ɵ(1) constant time
        }
       
    }
    
    /**
     * 
     * @param userDatabase
     * @param branchEmployee 
     * The method adds a new employee to database
     * It uses addLast method
     */
    public void addBranchEmployee(UserDatabase userDatabase,BranchEmployee branchEmployee) { //This method is Ɵ(1) constant time
        userDatabase.addEmployee(branchEmployee); //Ɵ(1) constant time
        System.out.println("Employee is added to the Database by Administrator"); //Ɵ(1) constant time
    }
    
    /**
     * 
     * @param userDatabase
     * @param employeeMail
     * The method removes employee from database by taking his/her mail
     * So this method carry outs searching and removing operations both
     */
    public void removeBranchEmployee(UserDatabase userDatabase,String employeeMail) {//This method is O(n^2) quadratic time worst case
        userDatabase.removeEmployee(employeeMail); //O(n^2) 
        System.out.println("Employee is removed from the Database by Administrator"); //Ɵ(1) constant time
    }
   /**
    * 
    * @param userDatabase
    * @param employeeMail 
    * Shows all information of a specific employee
    */
    
    public void queryEmployee(UserDatabase userDatabase,String employeeMail) { //This method is O(n) linear time
        userDatabase.showEmployeeInfo(employeeMail); //O(n) linear time
    }
    
    /**
     * 
     * @param userDatabase
     * @param customer
     * The methos adds new customer to database
     * This method uses addLast method
     */
    public void addCustomer(UserDatabase userDatabase,Customer customer) { //This method is //Ɵ(1) constant time
        userDatabase.addCustomer(customer); //Ɵ(1) constant time
        System.out.println("Customer is added to the Database by Administrator");//Ɵ(1) constant time
    }
    
    /**
     * 
     * @param userDatabase
     * @param customerMail 
     * The method removes customer from database by taking his/her mail
     *  So this method carry outs searching and removing operations both
     */
    public void removeCustomer(UserDatabase userDatabase,String customerMail) { //This method is O(n^2) quadratic time in worst case
        userDatabase.removeCustomer(customerMail); //O(n^2) 
        System.out.println("Customer is removed from the Database by Administrator"); //Ɵ(1) constant time
    }
    
    /**
     * 
     * @param userDatabase
     * @param customerMail 
     * Shows all information about a specific customer
     */
    public void queryCustomer(UserDatabase userDatabase,String customerMail) //This method is O(n) linear time
    {
        userDatabase.showCustomerInfo(customerMail); //O(n) linear time
    }
    
    
    
}
