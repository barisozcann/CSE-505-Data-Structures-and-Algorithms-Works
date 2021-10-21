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
    private BranchEmployee[] branchEmployeeArray=new BranchEmployee[100]; //The array can take 100 different Branch Employees
    private int branchEmployeeCounter=0;
      
    private Customer[] customerArray=new Customer[1000]; //The array can take 1000 different customers
    private int customerCounter=0;
    
    private final int userIdConstant=1000; //Thanks to this constant every customer has different id by adding their index number to it.
    
    /**
     * 
     * @param customer 
     */
    public void addCustomer(Customer customer)
    {
        this.customerArray[this.customerCounter]=customer;
        System.out.println("Customer "+(this.customerCounter+userIdConstant)+" is added to the DataBase");
        this.customerCounter++;
    }
    
    
     /**
     * @param customerMail is mail of customer
     * So if admin or employee wants to remove a customer, he/she must enter customer's mail
     * Ofcourse only admin and employee can call this method
     * This method use "for loop" with integer i by the help of customerCounter that counts number of all customers
     */
    
    public void removeCustomer(String customerMail)
    {
        if(this.customerCounter!=0)
        {
            while(true)
            {
                int j=0; //If we find that customer, we will increment this integer
                for(int i=0;i<this.customerCounter;i++)
                {
                    String localCustomerMail=this.customerArray[i].getCustomerMail();
                    if(localCustomerMail.equals(customerMail) && i==(this.customerCounter-1))
                    {
                        this.customerArray[i]=null;
                        System.out.println("Customer, whose mail is "+customerMail+" has removed from the DataBase");
                        this.customerCounter--; //Decremencting customer counter
                        j++;
                        break;
                    }
            
                    else if (localCustomerMail.equals(customerMail) && i<(this.customerCounter-1))
                    {
                        int lastIndexCounter=0;
                        for(int k=i;k<(this.customerCounter-1);k++)
                        {
                            this.customerArray[k]=this.customerArray[k+1];
                            lastIndexCounter=k+1;
                        }
                        this.customerArray[lastIndexCounter]=null;
                        System.out.println("Customer whose mail is"+customerMail+" has removed from the DataBase");
                        this.customerCounter--; //Decremencting customer counter
                        j++;
                        break;
                    }
            }
        if(j==0)
        {
            System.out.println("The Customer that you try to remove doesn't exist in Database!");
            break;
        }
        break;
        
        }
        }
        else
        {
            System.out.println("There is no Customer to remove!");
        }
    }
   
    /**
     * 
     * @param customerId is Id number of customer
     * @param password is password of customer
     * @return true if both of them are correct
     * This method check if customer id and password are both true
     */
    
    public boolean loginCustomer(String customerId,String password)
    {
        if(this.customerCounter!=0)
        {
            for(int i=0;i<this.customerCounter;i++)
                if(customerId.equals(this.customerArray[i].getRealCustomerId()) && password.equals(this.customerArray[i].getCustomerPassword()))
                {
                    return true;
                }
                
        }
        return false;
    }
    
    
    /**
     * 
     * @param customerMail 
     */
    public void showCustomerInfo(String customerMail)
    {
        if(this.customerCounter!=0)
        {
            int j=0;
            for(int i=0;i<this.customerCounter;i++)
                if(customerMail.equals(this.customerArray[i].getCustomerMail()))
                {
                    this.customerArray[i].showUserInfo();
                    j++;
                }
            if(j==0)
            {
                System.out.println("The customer doesn't exist in the Database");
            }
        }
        
        
       
        else if(this.customerCounter==0)
        {
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
        {
        if(this.customerCounter!=0)
        {
            int j=0;
            for(int i=0;i<this.customerCounter;i++)
                if(customerMail.equals(this.customerArray[i].getCustomerMail()))
                {
                    j++;
                    return i;
                }
            if(j==0)
            {
                System.out.println("The customer doesn't exist in the Database");
                return -1;
            }
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
        return -1;
    }
    
    public void showAllCustomer()
    {
        if(customerCounter==0)
        {
            System.out.println("There is no Customer to show");
        }
        else
        {
            for(int i=0;i<customerCounter;i++)
            {
                this.customerArray[i].showUserInfo();
            }
        }
    }

    public Customer[] getCustomerArray() {
        return customerArray;
    }
    
    
    
    /**
     * 
     * @param branchEmployee 
     */
    
    public void addEmployee(BranchEmployee branchEmployee)
    {
        this.branchEmployeeArray[this.branchEmployeeCounter]=branchEmployee;
        System.out.println("Employee "+(this.branchEmployeeCounter+userIdConstant)+" is added to the DataBase");
        this.branchEmployeeCounter++;
    }
    
    /**
     * 
     * @param employeeMail is mail of employee
     * Only admin is able to use this method
     * This method takes mail input and compares with all employees' mail
     * So it makes search operating in BranchEmployeeArray
     */
    public void removeEmployee(String employeeMail)
    {
        if(this.branchEmployeeCounter!=0)
        {
            while(true)
            {
                int j=0; //This variable is incrementing only if method finds that employee in employee array
                for(int i=0;i<this.branchEmployeeCounter;i++)
                {
                    String localEmployeeMail=this.branchEmployeeArray[i].getEmployeeMail();
                    if(localEmployeeMail.equals(employeeMail) && i==(this.branchEmployeeCounter-1))
                    {
                        this.branchEmployeeArray[i]=null;
                        System.out.println("Employee, whose mail is "+employeeMail+" has removed from Database");
                        this.branchEmployeeCounter--; //decrementing employee counter because method remove one employee
                        j++;
                        break;
                    }
            
                    else if (localEmployeeMail.equals(employeeMail) && i<(this.branchEmployeeCounter-1))
                    {
                        int lastIndexCounter=0;
                        for(int k=i;k<(this.branchEmployeeCounter-1);k++)
                        {
                            this.branchEmployeeArray[k]=this.branchEmployeeArray[k+1];
                            lastIndexCounter=k+1;
                        }
                    this.branchEmployeeArray[lastIndexCounter]=null;
                    System.out.println("Employee, whose mail is "+employeeMail+" has removed from Database");
                    this.branchEmployeeCounter--; //decrementing employee counter because methos remove one employee
                    j++;
                    break;
                    }
                }
            if(j==0)
            {
                System.out.println("The Employee that you try to remove doesn't exist in Database!");
                break;
            }
            break;
        
            }
            }
            else
            {
                System.out.println("There is no Employee to remove!");
            }
        
    }
    
   /**
    * 
    * @param employeeId
    * @param password
    * @return 
    * This method checks if employeeId and password are both correct
    */
    public boolean loginEmployee(String employeeId,String password)
    {
        if(this.branchEmployeeCounter!=0)
        {
            for(int i=0;i<this.branchEmployeeCounter;i++)
                if(employeeId.equals(this.branchEmployeeArray[i].getRealEmployeeId()) && password.equals(this.branchEmployeeArray[i].getEmployeePassword()))
                {
                    return true;
                }
                
        }
        return false;
    }
   
   /**
    * 
    * @param employeeMail 
    * This method searchs for a specific employee by using a string mail input
    * Shows all informations of the employee
    */
    
    public void showEmployeeInfo(String employeeMail)
    {
        if(this.branchEmployeeCounter!=0)
        {
            int j=0; //It well be incremented only if the method finds an employee
            for(int i=0;i<this.branchEmployeeCounter;i++)
                if(employeeMail.equals(this.branchEmployeeArray[i].getEmployeeMail()))
                {
                    this.branchEmployeeArray[i].showUserInfo();
                    j++;
                }
            if(j==0)
            {
                System.out.println("The Employee doesn't exist in the Database");
            }
        }
        
        
       
        else if(this.customerCounter==0)
        {
            System.out.println("There is no Employee in Database yet");
        }
       
    
    }

    public BranchEmployee[] getBranchEmployeeArray() {
        return branchEmployeeArray;
    }
   
   

   /**
    * Shows all employees in employee array
    */
    public void showAllEmployee()
    {
        if(branchEmployeeCounter==0)
        {
            System.out.println("There is no Employee to show");
        }
        else
        {
            for(int i=0;i<branchEmployeeCounter;i++)
            {
                this.branchEmployeeArray[i].showUserInfo();
            }
        }
    }
    
    
}
