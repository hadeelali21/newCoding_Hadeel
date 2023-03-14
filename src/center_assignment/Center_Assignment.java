/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package center_assignment;

/**
 *
 * @author HP
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Center_Assignment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        
        
       File inputfileI = new File ("C:\\Users\\HP\\Desktop\\B9B_2107818_Assignment1\\src\\intialInformation.txt");
       File inputfileC = new File ("C:\\Users\\HP\\Desktop\\B9B_2107818_Assignment1\\src\\Commands.txt");
       
       if (!inputfileI.exists()||!inputfileC.exists())
        {
            System.out.println(" input file does not exist ");
            System.exit(0);
        }
       File outFile =new File ("output1.txt");
    
    //make scanner for input 
        Scanner inputIntial =new Scanner(inputfileI);
        Scanner inputCommand =new Scanner(inputfileC);
        //creating object to write data on file 
       PrintWriter output =new PrintWriter(outFile);
       
       
       Center []centers=null;  
       
       output.println("                     Welcome to Shopping Center Employee Management System         ");
       output.println("            ---------------------------------------------------------------------------        ");
       String command=" ";
        do {
             command=inputCommand.next();
            if(command.equalsIgnoreCase("STARTUP")){
                //this command will use the first input file 
                centers =startUP(inputIntial);
                
            }
            else if(command.equalsIgnoreCase("DISPLAY_ALL_CENTERS")) {
                
                disAllCenters(output,centers);
            }
            
            else if(command.equalsIgnoreCase("DISPLAY_PRODUCTS_FOR_EMPLOYEE")) {
                disProductForEMP(inputCommand,output,centers);
            }
            else if(command.equalsIgnoreCase("NUM_OF_EMPLOYEES")) {
                numberOfEmployees(inputCommand,output,centers);
            }
            else if(command.equalsIgnoreCase("DISPLAY_BASED_ON_PRODUCT")) {
//                String nameOFproduct=inputCommand.next();
                disBasedOnProduct(inputCommand,output,centers);
            }
            else if(command.equalsIgnoreCase("CHANGE_TO_NULL_PRODUCT")) {
                String empID=inputCommand.next();
                change2nullProduct(inputCommand,output,centers,empID);
            }
            else if(command.equalsIgnoreCase("SWAP_BETWEEN_EMPLOYEES")) {
                swap(inputCommand,output,centers);
            }
             
        } while (!command.equalsIgnoreCase("Quit"));
        
        output.println(" ");
        output.println(" ");
        output.println(" ");
        output.println(" ");
        output.println("	============================			");
        output.println("		Best Wishes 		");
        output.println("	============================			");
        output.close();
        
}
//____________________________________________________________________________________________________________________________
    
    public static Center[] startUP(Scanner inputI) {
        int employeesNO=inputI.nextInt();
        int centerNO=inputI.nextInt();
        int productNO=inputI.nextInt();
        //we make array to store centers because we have more than one linked list 
        //array of centers (array of linked list )
        Center []centers=new Center[centerNO];
        //in each itration we creat linked list
        for (int i = 0; i <centers.length; i++) {
            String center_name=inputI.next();
            centers[i]=new Center(center_name);       
        }
        
        //array for the product
        String[] products=new String [productNO];
        for (int i = 0; i < products.length; i++) {
            products[i]=inputI.next();
        }
        
        //add employee for the centers 
        for (int  x= 0; x< centers.length; x++) {
            
            for (int y = 0; y < 5; y++) {
                String empID=inputI.next();
                String firstName=inputI.next();
                String lasttName=inputI.next();
                String nameOFproduct=products[y];
                //add them to center
                centers[x].addEmployee(empID, firstName, lasttName, nameOFproduct);
            }
        }
     //center info.
        for (int i = 0; i < centers.length; i++) {
           int center_id=inputI.nextInt();
           String center_name=inputI.next();
           centers[i].setCenterID(center_id);
        }
        return centers ;
        
    }
    
    
    //--------------------------------------------------------------------------
    public static void disAllCenters(PrintWriter print, Center[] centers) {
        print.println("                                       Information of Employees in Each Center         ");
        for (int x= 0; x < centers.length; x++) {
          print.println("                    Employees in "+centers[x].getCenterName()+" Center        ");
          print.println("  ID          Name                         Product   ");
          
          Employee heeelp=centers[x].getHead();
          while(heeelp!=null){
              String completeName=heeelp.getFname()+" "+heeelp.getLName();
              print.printf("   %-14s%-32s%s\n",heeelp.getEmpID(),completeName,heeelp.getProduct());
              heeelp=heeelp.getNext();
          }
          print.println("                    ---------------------------------------------        ");
        }
        print.flush();
    }
    //--------------------------------------------------------------------------
    public static void disProductForEMP(Scanner inputCommand, PrintWriter print, Center[] centers) {
        String empID=inputCommand.next();
        int cccc=0;
        for (int i = 0; i < centers.length; i++) {
           Employee emp= centers[i].searchEmployeeByID(empID);
           
           //if we find it we will exit from loop 
            if (emp!=null) {
                String completeName=emp.getFname()+" "+emp.getLName();
                print.println("	\"Employee: "+completeName+", "+emp.getEmpID()+", is assigned to "+emp.getProduct()+", in "+centers[i].getCenterName()+" center  \"			");
                break;
            }
            if(emp==null)
                cccc++;
       }
        
        //if the employee does not found 
        if (cccc==centers.length) {
            print.println("	No employee of this number is found			");
        }
        print.println(" ----------------------------------------------------------------------------				");
                print.flush();

    }
    //--------------------------------------------------------------------------
    public static void numberOfEmployees(Scanner inputCommand, PrintWriter print, Center[] centers) {
        String center_name=inputCommand.next();
        
        for (int x = 0; x < centers.length; x++) {
                    //check the center name 
            if (centers[x].getCenterName().equals(center_name)) {
                //نطبع عدد النود 
                
                int cccc=0;//
                Employee heeelp=centers[x].getHead();
                while (heeelp!=null){
                    cccc++;
                    heeelp=heeelp.getNext();
                }
                print.println("                   Number of employess in "+centers[x].getCenterName()+" center:"+ cccc+"				");
                break;
                
            }

        }
        print.println(" ----------------------------------------------------------------------------				");
                print.flush();

    }
    //--------------------------------------------------------------------------
    public static void disBasedOnProduct(Scanner inputCommand, PrintWriter print, Center[] centers) {
        String nameOFproduct=inputCommand.next();
        print.println("-------------------------------------------------------------------------------				");
        print.println("                              Employees for Product "+nameOFproduct+"				");
        print.println("	ID	Name 	                    Center 	");
        
        for (int x = 0; x < centers.length; x++) {
            Employee heeelp=centers[x].getHead();
            while(heeelp!=null){
                if (heeelp.getProduct().equals(nameOFproduct)) {
                    String completeName=heeelp.getFname()+" "+heeelp.getLName();
                    print.printf("   %-7s%-28s%s\n",heeelp.getEmpID(),completeName,centers[x].getCenterName());
                    //print.println("hadeel");
                }
                heeelp=heeelp.getNext();
            }
        }
        
        print.flush();        
    }
    //--------------------------------------------------------------------------
    public static void change2nullProduct(Scanner inputCommand, PrintWriter print, Center[] centers, String empID) {
        
        for (int x = 0; x < centers.length; x++) {
            Employee empObject =centers[x].searchEmployeeByID(empID);
            if (empObject!=null) {//emloyee found 
                String completeName=empObject.getFname()+" "+empObject.getLName();
                empObject.setProduct(null);
                print.println("==========================================================================				");
                print.println(" ");
                print.println("                                  Change Assigned Product to Null 				");
                print.println("	Products for  "+completeName +": "+empID+ " has been changed to null			");
                break;
            }
        }
    }
    //--------------------------------------------------------------------------
    public static void swap(Scanner inputCommand, PrintWriter print, Center[] centers) {
        String empIDx=inputCommand.next();
        String empIDy=inputCommand.next();
        //search for employee 1 
        Employee empOb1=null;
        String c1=null;//center
        //
        for (int x = 0; x < centers.length; x++) {
            if (empOb1==null) {
                empOb1=centers[x].searchEmployeeByID(empIDx);
                c1=centers[x].getCenterName();
            }
            else   {
                break;
            }
        }
        Employee empOb2=null;
        String c2=null;
        for (int x = 0; x < centers.length; x++) {
            if (empOb2==null) {
                empOb2=centers[x].searchEmployeeByID(empIDy);
                c2=centers[x].getCenterName();
            }
            else   {//
                break;
            }
        }
        Center.swapEmployees(empOb1, empOb2);
        
        print.println("===========================================================================				");
        print.println("                           Swap Centers Between Two Employees 				");
        
        String completeName1 =empOb1.getFname()+" "+empOb1.getLName();
        String completeName2 =empOb2.getFname()+" "+empOb2.getLName();

        print.println("	"+completeName2+" in "+c2 +"center is SWAPED WITH  "+completeName1+" in "+c1 +"center 			");
        print.println("===========================================================================				");
        
    }
    
}
