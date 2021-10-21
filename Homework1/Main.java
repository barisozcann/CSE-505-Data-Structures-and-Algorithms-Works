/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package main;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Baris Ozcan 215008003003
 */
public class Main {

    /**
     * @param args the command line arguments
     * I designed different Menus to create interactive program
     * I used for loops, while loops, if else blocks and switch-case to make switches between menus
     */
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        input.useDelimiter("\n");
        
        UserDatabase userdatabase=new UserDatabase();
        
        Administrator admin=new Administrator();
        
        BranchEmployee branchEmployee1=new BranchEmployee("Ali", "Gulmez", "111111", "aligulmez@abc.com");
        branchEmployee1.subscribe(userdatabase);
        BranchEmployee branchEmployee2=new BranchEmployee("Elif", "Kaya", "111111", "elifkaya@abc.com");
        branchEmployee2.subscribe(userdatabase);
        BranchEmployee branchEmployee3=new BranchEmployee("Burcu", "Uzay", "111111", "burcuuzay@abc.com");
        branchEmployee3.subscribe(userdatabase);
        BranchEmployee branchEmployee4=new BranchEmployee("Mehmet", "Saray", "111111", "aligulmez@abc.com");
        branchEmployee4.subscribe(userdatabase);
        BranchEmployee branchEmployee5=new BranchEmployee("Ayfer", "Korkmaz", "111111", "ayferkorkmaz@abc.com");
        branchEmployee5.subscribe(userdatabase);
        
        Customer customer1=new Customer("Tamer","Karacan","123456","tamerkaracan@gmail.com");
        customer1.subscribe(userdatabase);
        Customer customer2=new Customer("Nuri","Tosun","123456","nuritosun@gmail.com");
        customer2.subscribe(userdatabase);
        Customer customer3=new Customer("Figen","Sivri","123456","figensivri@gmail.com");
        customer3.subscribe(userdatabase);
        Customer customer4=new Customer("Nihat","Bulca","123456","nihatbulca@gmail.com");
        customer4.subscribe(userdatabase);
        Customer customer5=new Customer("Ceren","Asya","123456","cerenasya@gmail.com");
        customer5.subscribe(userdatabase);
        
        
        int[] furnitureQuantityArray1={100,100,100,100,100};
        int[] furnitureQuantityArray2={75,75,75,75,75};
        int[] furnitureQuantityArray3={50,50,50,50,50};
        int[] furnitureQuantityArray4={100,80,60,40,20};
        int[] furnitureQuantityArray5={80,60,40,20,0};
        
        double bookcase1Price=120.5;
        double bookcase2Price=70.2;
        double bookcase3Price=40.4;
        double bookcase4Price=65.7;
        double bookcase5Price=45.25;
        
        Furniture bookcaseModel1=new Furniture("Bookcase", "Model1",bookcase1Price,furnitureQuantityArray1);
        Furniture bookcaseModel2=new Furniture("Bookcase", "Model2",bookcase2Price,furnitureQuantityArray2);
        Furniture bookcaseModel3=new Furniture("Bookcase", "Model3",bookcase3Price,furnitureQuantityArray3);
        Furniture bookcaseModel4=new Furniture("Bookcase", "Model4",bookcase4Price,furnitureQuantityArray4);
        Furniture bookcaseModel5=new Furniture("Bookcase", "Model5",bookcase5Price,furnitureQuantityArray5);
        
        
        
        double officedesk1Price=50.5;
        double officedesk2Price=40.2;
        double officedesk3Price=36.4;
        double officedesk4Price=71.7;
        double officedesk5Price=63.25;
        
        Furniture officedeskModel1=new Furniture("OfficeDesk", "Model1",officedesk1Price,furnitureQuantityArray1);
        Furniture officedeskModel2=new Furniture("OfficeDesk", "Model2",officedesk2Price,furnitureQuantityArray2);
        Furniture officedeskModel3=new Furniture("OfficeDesk", "Model3",officedesk3Price,furnitureQuantityArray3);
        Furniture officedeskModel4=new Furniture("OfficeDesk", "Model4",officedesk4Price,furnitureQuantityArray4);
        Furniture officedeskModel5=new Furniture("OfficeDesk", "Model5",officedesk5Price,furnitureQuantityArray5);
        
        
        
        
        double sofa1Price=54.5;
        double sofa2Price=48.2;
        double sofa3Price=60.4;
        double sofa4Price=110.7;
        double sofa5Price=85.25;
        
        Furniture sofaModel1=new Furniture("Sofa", "Model1",sofa1Price,furnitureQuantityArray1);
        Furniture sofaModel2=new Furniture("Sofa", "Model2",sofa2Price,furnitureQuantityArray2);
        Furniture sofaModel3=new Furniture("Sofa", "Model3",sofa3Price,furnitureQuantityArray3);
        Furniture sofaModel4=new Furniture("Sofa", "Model4",sofa4Price,furnitureQuantityArray4);
        Furniture sofaModel5=new Furniture("Sofa", "Model5",sofa5Price,furnitureQuantityArray5);
        
        
        
        
        double studenchair1Price=40.5;
        double studenchair2Price=58.2;
        double studenchair3Price=135.4;
        double studenchair4Price=105.7;
        double studenchair5Price=88.25;
        
        Furniture studenchairModel1=new Furniture("StudentChair", "Model1",studenchair1Price,furnitureQuantityArray1);
        Furniture studenchairModel2=new Furniture("StudentChair", "Model2",studenchair2Price,furnitureQuantityArray2);
        Furniture studenchairModel3=new Furniture("StudentChair", "Model3",studenchair3Price,furnitureQuantityArray3);
        Furniture studenchairModel4=new Furniture("StudentChair", "Model4",studenchair4Price,furnitureQuantityArray4);
        Furniture studenchairModel5=new Furniture("StudentChair", "Model5",studenchair5Price,furnitureQuantityArray5);
        
        
        double wardrobe1Price=95.5;
        double wardrobe2Price=73.2;
        double wardrobe3Price=45.4;
        double wardrobe4Price=68.7;
        double wardrobe5Price=57.25;
        
        Furniture wardrobeModel1=new Furniture("Wardrobe", "Model1",wardrobe1Price,furnitureQuantityArray1);
        Furniture wardrobeModel2=new Furniture("Wardrobe", "Model2",wardrobe2Price,furnitureQuantityArray2);
        Furniture wardrobeModel3=new Furniture("Wardrobe", "Model3",wardrobe3Price,furnitureQuantityArray3);
        Furniture wardrobeModel4=new Furniture("Wardrobe", "Model4",wardrobe4Price,furnitureQuantityArray4);
        Furniture wardrobeModel5=new Furniture("Wardrobe", "Model5",wardrobe5Price,furnitureQuantityArray5);
        
        
        
        
        String branchName1="Branch1";
        Branch branch1=new Branch(branchName1);
        branch1.addFurniture(bookcaseModel1);
        branch1.addFurniture(bookcaseModel2);
        branch1.addFurniture(officedeskModel1);
        branch1.addFurniture(officedeskModel2);
        branch1.addFurniture(sofaModel1);
        branch1.addFurniture(sofaModel2);
        branch1.addFurniture(studenchairModel1);
        branch1.addFurniture(studenchairModel2);
        branch1.addFurniture(wardrobeModel1);
        branch1.addFurniture(wardrobeModel2);
        admin.addBranch(branch1);
        
        
        
        String branchName2="Branch2";
        Branch branch2=new Branch(branchName2);
        branch2.addFurniture(bookcaseModel2);
        branch2.addFurniture(bookcaseModel3);
        branch2.addFurniture(officedeskModel2);
        branch2.addFurniture(officedeskModel3);
        branch2.addFurniture(sofaModel2);
        branch2.addFurniture(sofaModel3);
        branch2.addFurniture(studenchairModel2);
        branch2.addFurniture(studenchairModel3);
        branch2.addFurniture(wardrobeModel2);
        branch2.addFurniture(wardrobeModel3);
        admin.addBranch(branch2);
        
        String branchName3="Branch3";
        Branch branch3=new Branch(branchName3);
        branch3.addFurniture(bookcaseModel3);
        branch3.addFurniture(bookcaseModel4);
        branch3.addFurniture(officedeskModel3);
        branch3.addFurniture(officedeskModel4);
        branch3.addFurniture(sofaModel3);
        branch3.addFurniture(sofaModel4);
        branch3.addFurniture(studenchairModel3);
        branch3.addFurniture(studenchairModel4);
        branch3.addFurniture(wardrobeModel3);
        branch3.addFurniture(wardrobeModel4);
        admin.addBranch(branch3);
        
        String branchName4="Branch4";
        Branch branch4=new Branch(branchName4);
        branch4.addFurniture(bookcaseModel4);
        branch4.addFurniture(bookcaseModel5);
        branch4.addFurniture(officedeskModel4);
        branch4.addFurniture(officedeskModel5);
        branch4.addFurniture(sofaModel4);
        branch4.addFurniture(sofaModel5);
        branch4.addFurniture(studenchairModel4);
        branch4.addFurniture(studenchairModel5);
        branch4.addFurniture(wardrobeModel4);
        branch4.addFurniture(wardrobeModel5);
        admin.addBranch(branch4);
        
        String branchName5="Branch5";
        Branch branch5=new Branch(branchName5);
        admin.addBranch(branch5);
        
        
        int loopController=0;
        while(loopController!=-1)
        {
            System.out.println("****************************************************************************");
            System.out.println("*************************************************************");
            System.out.println("*********************************************");
            System.out.println("Welcome to the ABC Furniture Store");
            System.out.println("Press 1 to Login as Administrator");
            System.out.println("Press 2 to Login as Branch Employee");
            System.out.println("Press 3 to Subscribe as Employee");
            System.out.println("Press 4 to Login as Customer");
            System.out.println("Press 5 to Subscribe as Customer");
            System.out.println("Press 6 to Exit");
            char button=input.next().charAt(0);
            switch(button){
            case '1':
                
                String adminId,adminPassword;
                System.out.print("Enter the Admin ID:");
                adminId=input.next();
                System.out.print("Enter the Admin password:");
                adminPassword=input.next();                    
                boolean checkAdmin=admin.login(adminId, adminPassword);
                if(checkAdmin)
                {
                    while(true)
                    {
                        System.out.println("***************************************");
                        System.out.println("Admin Menu");
                        System.out.println("Press 1 for Branch Transactions");
                        System.out.println("Press 2 for User Transactions");
                        System.out.println("Press 3 to return Main Menu");
                        char adminTransaction=input.next().charAt(0);
                        
                        if(adminTransaction=='1')
                        {   
                            System.out.println("***************************************");
                            System.out.println("Press 1 to see Branch List");
                            System.out.println("Press 2 to see a Branch's Stocklist");
                            System.out.println("Press 3 to Search for Product");
                            System.out.println("Press 4 to add a new Branch");
                            System.out.println("Press 5 to remove a Branch");
                            char branchTransaction=input.next().charAt(0);
                            
                            switch (branchTransaction)
                            {
                                case '1':
                                    admin.showAllBranch();
                                    break;
                                case '2':
                                    admin.showAllBranch();
                                    System.out.println("Enter the index of Branch that you want to see its stocklist"); 
                                    int branchIndex=input.nextInt();
                                    admin.queryStock(branchIndex);
                                    break;
                                case '3':
                                    System.out.println("Enter the name of product:");
                                    String productName=input.next();
                                    System.out.println("Enter the model of product:");
                                    String productModel=input.next();
                                    admin.searchProduct(productName, productModel);
                                    break;
                                case '4':
                                    admin.showAllBranch();
                                    System.out.println("Enter the name of the Branch that you want to add");
                                    String newBranchName;
                                    newBranchName=input.next();
                                    admin.addBranch(new Branch(newBranchName));
                                    break;
                                case '5':
                                    admin.showAllBranch();
                                    System.out.println("Enter the name of Branch that you want to remove");
                                    String branchRemoveName=input.next();
                                    System.out.println(branchRemoveName);
                                    admin.removeBranch(branchRemoveName);
                                    break;
                                default:
                                    System.out.println("Please enter a valid number between 1-5");
                            }
                            
                        }
                        else if(adminTransaction=='2')
                        {
                            System.out.println("***************************************");
                            System.out.println("Press 1 to add a new Customer");
                            System.out.println("Press 2 to remove a Customer");
                            System.out.println("Press 3 to query a Customer");
                            System.out.println("Press 4 to see all Customers");
                            System.out.println("Press 5 to add a new Branch Employee");
                            System.out.println("Press 6 to remove a Branch Employee");
                            System.out.println("Press 7 to query a Branch Employee");
                            System.out.println("Press 8 to see all Branch Employees");
                            char userTransaction=input.next().charAt(0);
                            switch(userTransaction)
                            {
                                case '1':
                                    System.out.println("Enter customer's name:");
                                    String customersName=input.next();
                                    System.out.println("Enter customer's surname:");
                                    String customersSurname=input.next();
                                    System.out.println("Enter customer's password:");
                                    String customersPassword=input.next();
                                    System.out.println("Enter customer's mail:");
                                    String customersMail=input.next();
                                    admin.addCustomer(userdatabase, new Customer(customersName,customersSurname,customersPassword,customersMail));
                                    break;
                                case '2':
                                    System.out.println("Enter customer's mail to remove from database");
                                    String customersRemoveMail=input.next();
                                    admin.removeCustomer(userdatabase, customersRemoveMail);
                                    break;
                                case '3':
                                    System.out.println("Enter customer's mail to see his/her information");
                                    String customersInfoMail=input.next();
                                    admin.queryCustomer(userdatabase, customersInfoMail);
                                    break;
                                case '4':
                                    userdatabase.showAllCustomer();
                                    break;
                                case '5':
                                    System.out.println("Enter Branch Employee's name:");
                                    String employeesName=input.next();
                                    System.out.println("Enter Branch Employee's surname:");
                                    String employeesSurname=input.next();
                                    System.out.println("Enter Branch Employee's password:");
                                    String employeesPassword=input.next();
                                    System.out.println("Enter Branch Employee's mail:");
                                    String employeesMail=input.next();
                                    admin.addBranchEmployee(userdatabase, new BranchEmployee(employeesName,employeesSurname,employeesPassword,employeesMail));
                                    break;
                                case '6':
                                    System.out.println("Enter Branch Employee's mail to remove from database");
                                    String employeesRemoveMail=input.next();
                                    admin.removeBranchEmployee(userdatabase, employeesRemoveMail);
                                    break;
                                case '7':
                                    System.out.println("Enter Branch Employee's mail to see his/her information");
                                    String employeesInfoMail=input.next();
                                    admin.queryEmployee(userdatabase, employeesInfoMail);
                                    break;
                                case '8':
                                    userdatabase.showAllEmployee();
                                    break;
                                default:
                                    System.out.println("Please enter a valid number between 1-8");
                            }
                            
                        }
                        else if(adminTransaction=='3')
                        {
                            System.out.println("Returning to Main Menu...");
                            break;
                        }
                        else
                        {
                            System.out.println("Please enter a valid number between 1-3");
                        }
                        
                        }
                    }
                    else
                    {
                        System.out.println("Wrong Id or Password. Returning to main menu...");
                        break;
                    }
                
                break;
            case '2':
                System.out.println("Enter your Employee Id:"); //Press 2 to Login as Branch Employee
                String employeeId=input.next();
                System.out.println("Enter your Employee password");
                String employeePassword=input.next();
                boolean employeeCheck=userdatabase.loginEmployee(employeeId, employeePassword);
                if(employeeCheck)
                {
                    int realEmployeeId=Integer.valueOf(employeeId);
                    int realEmployeeIndex=realEmployeeId-1000; // Subtracting 1000 because Employee Ids begin with 1000
                    int innerLoopController=0;
                    while(innerLoopController!=1)
                    {
                        System.out.println("***************************************");
                        System.out.println("Employee Menu");
                        System.out.println("Press 1 for Branch Transactions");
                        System.out.println("Press 2 for User Transactions");
                        System.out.println("Press 3 to return Main Menu");
                        char employeeTransaction=input.next().charAt(0);
                        switch(employeeTransaction)
                        {
                            case'1':
                                System.out.println("***************************************");
                                System.out.println("Press 1 to see Branch list");
                                System.out.println("Press 2 to see the Stocklist of a Branch");
                                System.out.println("Press 3 to add a new product to a Branch");
                                System.out.println("Press 4 to remove a product from a Branch");
                                System.out.println("Press 5 to query the stock number of a product");
                                System.out.println("Press 6 to increase the stock number of a product");
                                System.out.println("Press 7 to decrease the stock number of a product");
                                char employeeBranchTransaction=input.next().charAt(0);
                                
                                if(employeeBranchTransaction=='1')
                                {
                                    admin.showAllBranch();
                                }
                                else if(employeeBranchTransaction=='2')
                                {
                                    admin.showAllBranch();
                                    System.out.println("Please enter the index of the Branch that you want to see its Stocklist");
                                    int branchIndex=input.nextInt();
                                    admin.getBranchArray()[branchIndex].showAllStock();
                                }
                                else if(employeeBranchTransaction=='3')
                                {
                                    System.out.println("Enter the name of product without space");
                                    String productName=input.next();
                                    System.out.println("Enter the model of product without space");
                                    String productModel=input.next();
                                    System.out.println("Enter the price of product");
                                    double productPrice=input.nextDouble();
                                    System.out.println("Enter the number of Red product");
                                    int redProductNumber=input.nextInt();
                                    System.out.println("Enter the number of Blue product");
                                    int blueProductNumber=input.nextInt();
                                    System.out.println("Enter the number of Black product");
                                    int blackProductNumber=input.nextInt();
                                    System.out.println("Enter the number of Grey product");
                                    int greyProductNumber=input.nextInt();
                                    System.out.println("Enter the number of White product");
                                    int whiteProductNumber=input.nextInt();
                                    int[] productQuantityArray=new int[]{redProductNumber,blueProductNumber,blackProductNumber,greyProductNumber,whiteProductNumber};
                                    Furniture newFurniture=new Furniture(productName, productModel, productPrice,productQuantityArray);
                                    System.out.println("Product Created");
                                    System.out.println("Enter the index of the Branch that you want to add new product");
                                    admin.showAllBranch();
                                    int branchIndex=input.nextInt();
                                    admin.getBranchArray()[branchIndex].addFurniture(newFurniture);
                                    admin.getBranchArray()[branchIndex].showAllStock();
                                }
                                else if(employeeBranchTransaction=='4')
                                {
                                    System.out.println("Enter the name of product you want to remove");
                                    String productNameRemove=input.next();
                                    System.out.println("Enter the model of product you want to remove");
                                    String productModelRemove=input.next();
                                    System.out.println("Please enter the index of Branch that you want to remove product from it");
                                    admin.showAllBranch();
                                    int branchIndexRemove=input.nextInt();
                                    admin.getBranchArray()[branchIndexRemove].removeFurniture(productNameRemove, productModelRemove);
                                }
                                else if(employeeBranchTransaction=='5')
                                {
                                    System.out.println("Enter the name of product you want to query");
                                    String productNameQuery=input.next();
                                    System.out.println("Enter the model of product you want to query");
                                    String productModelQuery=input.next();
                                    admin.searchProduct(productNameQuery, productModelQuery);
                                }
                                else if(employeeBranchTransaction=='6')
                                {
                                    System.out.println("Enter the index of Branch that you want to make transaction");
                                    admin.showAllBranch();
                                    int branchIncreaseIndex=input.nextInt();
                                    admin.getBranchArray()[branchIncreaseIndex].showAllStock();
                                    System.out.println("Enter the index of Product that you want to increase");
                                    int productIncreaseIndex=input.nextInt();
                                    System.out.println("Enter the index of product color you want to increase(Red=0,Blue=1,Black=2,Grey=3,White=4");
                                    int productIncreaseColorIndex=input.nextInt();
                                    System.out.println("Enter the amount that you want to increase");
                                    int productIncreaseAmount=input.nextInt();
                                    admin.getBranchArray()[branchIncreaseIndex].increaseQuantity(productIncreaseIndex, productIncreaseColorIndex, productIncreaseAmount);
                                    System.out.println("Stock number increased");
                                    admin.getBranchArray()[branchIncreaseIndex].showAllStock(); 
                                }
                                else if(employeeBranchTransaction=='7')
                                {
                                    System.out.println("Enter the index of Branch that you want to make transaction");
                                    admin.showAllBranch();
                                    int branchDecreaseIndex=input.nextInt();
                                    admin.getBranchArray()[branchDecreaseIndex].showAllStock();
                                    System.out.println("Enter the index of Product that you want to decrease");
                                    int productDecreaseIndex=input.nextInt();
                                    System.out.println("Enter the index of product color you want to decrease(Red=0,Blue=1,Black=2,Grey=3,White=4");
                                    int productDecreaseColorIndex=input.nextInt();
                                    System.out.println("Enter the amount that you want to decrease");
                                    int productDecreaseAmount=input.nextInt();
                                    admin.getBranchArray()[branchDecreaseIndex].decreaseQuantity(productDecreaseIndex, productDecreaseColorIndex, productDecreaseAmount);
                                    System.out.println("Stock number decreased");
                                    admin.getBranchArray()[branchDecreaseIndex].showAllStock();
                                }
                                else
                                {
                                System.out.println("Please enter a valid number between 1-3");
                                }
                                break;
                            case '2':
                                System.out.println("Press 1 to Subscribe New Customer to the Database");
                                System.out.println("Press 2 to Remove Customer from the Database");
                                System.out.println("Press 3 Purchase a Product to Customer");
                                System.out.println("Press 4 See a Customer's Orders");
                                System.out.println("Press 5 to Update an Order's Situation");
                                char branchUserTransaction=input.next().charAt(0);
                                
                                if(branchUserTransaction=='1')
                                {
                                    System.out.println("Enter the Name of Customer");
                                    String customerName=input.next();
                                    System.out.println("Enter the Surname of Customer");
                                    String customerSurname=input.next();
                                    System.out.println("Enter the Password of Customer");
                                    String customerPassword=input.next();
                                    System.out.println("Enter the Mail of Customer");
                                    String customerMail=input.next();
                                    Customer newcustomer=new Customer(customerName,customerSurname,customerPassword,customerMail);
                                    userdatabase.getBranchEmployeeArray()[realEmployeeIndex].subscribeCustomer(newcustomer, userdatabase);
                                }
                                else if(branchUserTransaction=='2')
                                {
                                    System.out.println("Enter the mail of customer you want to remove");
                                    String customerMailRemove=input.next();
                                    userdatabase.getBranchEmployeeArray()[realEmployeeIndex].removeCustomer(customerMailRemove, userdatabase);
                                }
                                else if(branchUserTransaction=='3')
                                {
                                    System.out.println("Enter the index of Branch that you want to buy product");
                                    admin.showAllBranch();
                                    int purchaseBranchIndex=input.nextInt();
                                    admin.getBranchArray()[purchaseBranchIndex].showAllStock();
                                    System.out.println("Enter the product index that you want to buy");
                                    int purchaseProductIndex=input.nextInt();
                                    System.out.println("Enter the index of color that you like(Red=0,Blue=1,Black=2,Grey=3,White=4)");
                                    int purchaseColorIndex=input.nextInt();
                                    System.out.println("How many products you want to buy?");
                                    int purchaseAmount=input.nextInt();
                                    System.out.println("Enter the Customer's mail");
                                    String customersMail=input.next();
                                    System.out.println("Enter the Customer's phone number");
                                    String customersPhoneNumber=input.next();
                                    System.out.println("Enter the Customer's adress");
                                    String customersAdress=input.next();
                                    
                                    int customerIndex=userdatabase.getCustomerIndex(customersMail);
                                    
                                    userdatabase.getBranchEmployeeArray()[realEmployeeIndex].purchaseProduct(admin.getBranchArray()[purchaseBranchIndex],
                                            userdatabase.getCustomerArray()[customerIndex],customersPhoneNumber,customersAdress,purchaseProductIndex,purchaseAmount,purchaseColorIndex); 
                                }
                                else if(branchUserTransaction=='4')
                                {
                                    System.out.println("Enter the mail of customer that ordered the product");
                                    String customersMail=input.next();
                                    int customerIndex=userdatabase.getCustomerIndex(customersMail);
                                    userdatabase.getCustomerArray()[customerIndex].checkOrders();
                                    
                                }
                                else if(branchUserTransaction=='5')
                                {
                                    System.out.println("Enter the mail of customer that ordered the product");
                                    String customersMail=input.next();
                                    int customerIndex=userdatabase.getCustomerIndex(customersMail);
                                    userdatabase.getCustomerArray()[customerIndex].checkOrders();
                                    System.out.println("Enter the index of order you want to update");
                                    int orderIndex=input.nextInt();
                                    System.out.println("Enter the new situation of the order");
                                    String newSituation=input.next();
                                    System.out.println(customerIndex);
                                    userdatabase.getBranchEmployeeArray()[realEmployeeIndex].updateOrderSituation(userdatabase.getCustomerArray()[customerIndex], orderIndex, newSituation);
                                }
                                else
                                {
                                    System.out.println("Please enter a valid number between 1-5");
                                }
      
                                break;
                                
                            case'3':
                                innerLoopController++;
                                break;
                            default:
                                System.out.println("Please enter a valid number between 1-3");
                        }
                                
                                
                             
                        }
                    }
                break;
            
            case'3':
                System.out.println("Enter your name:");
                String employeeName=input.next();
                System.out.println("Enter your surname:");
                String employeeSurname=input.next();
                System.out.println("Enter your password:");
                String employeePasswordd=input.next();
                System.out.println("Enter your mail:");
                String employeeMail=input.next();
                BranchEmployee employee=new BranchEmployee(employeeName, employeeSurname, employeePasswordd, employeeMail);
                employee.subscribe(userdatabase);
                break;
            
            case'4':
                System.out.println("Enter Your Customer ID:");
                String customerId=input.next();
                System.out.println("Enter Your Password:");
                String customerPassword=input.next();
                int customerIndex=Integer.valueOf(customerId)-1000;
                boolean checkCustomer=userdatabase.loginCustomer(customerId, customerPassword);
                if(checkCustomer)
                {
                    int innerLoopController2=0;
                    while(innerLoopController2!=1)
                    {
                        System.out.println("***************************************");
                        System.out.println("Customer Menu");
                        System.out.println("Press 1 to see available products in a Branch");
                        System.out.println("Press 2 to search for a product");
                        System.out.println("Press 3 to purchase a product");
                        System.out.println("Press 4 to return main menu");
                        char customerTransaction=input.next().charAt(0);
                        switch(customerTransaction)
                        {
                            case'1':
                                admin.showAllBranch();
                                System.out.println("Enter the index of Branch you want to look for");
                                int branchIndex=input.nextInt();
                                admin.getBranchArray()[branchIndex].showAllStock();
                                break;
                            case'2':
                                System.out.println("Enter the name of product you want to search for");
                                String productSearchName=input.next();
                                System.out.println("Enter the model of product you want to search for");
                                String productSearchModel=input.next();
                                admin.searchProduct(productSearchName,productSearchModel);
                                break;
                            case'3':
                                admin.showAllBranch();
                                System.out.println("Enter the index of Branch that contains your product");
                                int branchPurchaseIndex=input.nextInt();
                                admin.getBranchArray()[branchPurchaseIndex].showAllStock();
                                System.out.println("Enter the index of Product you want to purchase");
                                int productPurchaseIndex=input.nextInt();
                                System.out.println("Enter the index of product color you like(Red=0,Blue=1,Black=2,Grey=3,White=4)");
                                int colorPurchaseIndex=input.nextInt();
                                System.out.println("How many product you want to purchase?");
                                int amountPurchase=input.nextInt();
                                System.out.println("Please enter your phone number");
                                String customerPhonenumber=input.next();
                                System.out.println("Please enter your adress");
                                String customerAdress=input.next();
                                admin.getBranchArray()[branchPurchaseIndex].sell(userdatabase.getCustomerArray()[customerIndex], customerPhonenumber, customerAdress, productPurchaseIndex, amountPurchase, colorPurchaseIndex);
                                break;
                            case'4':
                                System.out.println("Returning to Main Menu...");
                                innerLoopController2++;
                                break;
                            default:
                                System.out.println("Enter a valid number between 1-4");
                        }
                    }
                    
                }
                else
                {
                    System.out.println("Wrong Id or Password. Returning to Main Menu...");
                }
  
                break;
            case'5':
                System.out.println("Enter your name:");
                String customerName=input.next();
                System.out.println("Enter your surname:");
                String customerSurname=input.next();
                System.out.println("Enter your password:");
                String customerPasswordd=input.next();
                System.out.println("Enter your mail:");
                String customerMail=input.next();
                Customer customer=new Customer(customerName,customerSurname,customerPasswordd,customerMail);
                customer.subscribe(userdatabase);
                break;
            case'6':
                System.out.println("Ending program...");
                loopController--;
                break;
                        
            default:
                System.out.println("Please enter a valid number between 1-6");
                break;
            }
      
                  
        }
        }
        
   
        
    }
    

