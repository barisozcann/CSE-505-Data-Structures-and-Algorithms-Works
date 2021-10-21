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
 * There is only one admin
 */
public class Administrator{
    private String adminId="admin";
    private String password="123456";
    private Branch[] branchArray=new Branch[10];
    private int branchCounter=0;
    
    /**
     * 
     * @param id
     * @param parola
     * @return 
     * Checks if admin id and password are both correct
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

    public Branch[] getBranchArray() 
    {
        
        return branchArray;
       
        
    }
  
    
    
    /**
     * 
     * @param branch 
     * The method adds a new Branch to Branch Array
     */
    public void addBranch(Branch branch)
    {
        if(this.branchCounter<this.branchArray.length)
        {
            this.branchArray[this.branchCounter]=branch;
            System.out.println(branch.getBranchName()+" is added to the system");
            branchCounter++;
        }
        else
        {
            System.out.println("You can't add any branch because you reached to the limit!(10)");
        }
        
    }
    
    /**
     * 
     * @param branchName 
     * The method removes a Branch from Branch Array by taking String Branch name input
     */
    public void removeBranch(String branchName)
    {
        if(this.branchCounter==0)
        {
            System.out.println("There is no branch to remove!");
        }
        
        else {
        while(true)
        {
            int j=0; //will be decrement only if the method finds the branch
        
            for(int i=0;i<this.branchCounter;i++) //Incrementing int i until the value of furnitureCounter in order to prevent null pointer error
            {
                String localBranchName=this.branchArray[i].getBranchName();
                if(localBranchName.equals(branchName) &&  i==(this.branchCounter-1))
                {
                    this.branchArray[i]=null;
                    this.branchCounter--; //Decreasing furnitureCounter because one furniture product removed
                    j++;
                    break;
                }
                else if (localBranchName.equals(branchName) &&  i<(this.branchCounter-1))
                {
                    int lastIndexCounter=0;
                    for(int k=i;k<(this.branchCounter-1);k++)
                    {
                        this.branchArray[k]=this.branchArray[k+1];
                        lastIndexCounter=k+1;
                    }
                this.branchArray[lastIndexCounter]=null;
                this.branchCounter--;
                j++;
                break;
                }
            }
        
        if(j==0)
        {
            System.out.println("The Branch that you try to remove doesn't exist in the system");
            break;
        }
        break;
        }
      }
    }
    
    /**
     * The method shows all branches in branch array
     */
    
    public void showAllBranch()
    {
        if(this.branchCounter==0)
        {
            System.out.println("There is no branch in the system");
        }
        
        else
        {
            
        
        for(int i=0;i<this.branchCounter;i++)
        {
            System.out.println(i+" - "+this.branchArray[i].getBranchName());
        }
        }
    }
    
    
    /**
     * 
     * @param name
     * @param model 
     * This method search for a product in all branches by using branch array
     */
    public void searchProduct(String name,String model)
    {
        try
        {
        if(this.branchCounter==0)
        {
            System.out.println("There is no Branch to query its stock!");
        }
        
        else
        {
            for(int i=0;i<this.branchCounter;i++)
            {
                this.branchArray[i].queryFurniture(name, model);
            }
        }
        
       } catch(Exception e)
       {
           System.out.println("An error occurred: "+e);
       }
    }
    
    
    /**
     * 
     * @param branchIndex is index of branch im branch array
     * This method query a stocklist of a specific branch
     */
    public void queryStock(int branchIndex)
    {
       try
        {
            if(this.branchCounter==0)
            {
            System.out.println("There is no Branch to query its stock!");
            }
        
            else if(branchIndex<(this.branchCounter) && this.branchCounter!=0)
            {
                System.out.println(this.branchArray[branchIndex].getBranchName());
                this.branchArray[branchIndex].showAllStock();
            }
            else if(branchIndex>this.branchCounter)
            {
                System.out.println("The index you entered is out of range!");
            }
        } catch(Exception e)
        {
           System.out.println("An error occurred: "+e);
        }
       
    }
    
    /**
     * 
     * @param userDatabase
     * @param branchEmployee 
     * The method adds a new employee to database
     */
    public void addBranchEmployee(UserDatabase userDatabase,BranchEmployee branchEmployee)
    {
        userDatabase.addEmployee(branchEmployee);
        System.out.println("Employee is added to the Database by Administrator");
    }
    
    /**
     * 
     * @param userDatabase
     * @param employeeMail
     * The method removes employee from database by taking his/her mail
     */
    public void removeBranchEmployee(UserDatabase userDatabase,String employeeMail)
    {
        userDatabase.removeEmployee(employeeMail);
        System.out.println("Employee is removed from the Database by Administrator");
    }
   /**
    * 
    * @param userDatabase
    * @param employeeMail 
    * Shows all information of a specific employee
    */
    
    public void queryEmployee(UserDatabase userDatabase,String employeeMail)
    {
        userDatabase.showEmployeeInfo(employeeMail);
    }
    
    /**
     * 
     * @param userDatabase
     * @param customer
     * The method adds a new customer to database
     */
    public void addCustomer(UserDatabase userDatabase,Customer customer)
    {
        userDatabase.addCustomer(customer);
        System.out.println("Customer is added to the Database by Administrator");
    }
    
    /**
     * 
     * @param userDatabase
     * @param customerMail 
     * The method removes customer from database by taking his/her mail
     */
    public void removeCustomer(UserDatabase userDatabase,String customerMail)
    {
        userDatabase.removeCustomer(customerMail);
        System.out.println("Customer is removed from the Database by Administrator");
    }
    
    /**
     * 
     * @param userDatabase
     * @param customerMail 
     * Shows all information of a specific customer
     */
    public void queryCustomer(UserDatabase userDatabase,String customerMail)
    {
        userDatabase.showCustomerInfo(customerMail);
    }
    
    
  
  
    
}
