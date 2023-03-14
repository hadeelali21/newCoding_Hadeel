/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b9b_2107818_1;

/**
 *
 * @author HP
 */
public class Center {
    private Employee head;
    private String centerName;
    private int centerID;

    public Center(Employee head, String centerName, int centerID) {
        this.head = head;
        this.centerName = centerName;
        this.centerID = centerID;
    }

    public Center(String centerName) {
        this.centerName = centerName;
    }

    

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public int getCenterID() {
        return centerID;
    }

    public void setCenterID(int centerID) {
        this.centerID = centerID;
    }

    public Employee getHead() {
        return head;
    }

    public void setHead(Employee head) {
        this.head = head;
    }

    
    
    //________________________________________________________________________
    public void addEmployee(String empID, String Fname, String LName, String product){
        if (head==null) {
            head =new Employee ( empID,  Fname,  LName,  product,head);   
        }
        else {
          Employee hp=head;
          //to reach for the last index 
          while(hp.getNext()!=null){
              hp=hp.getNext();//traverse
          }
          hp.setNext(new Employee (empID,  Fname,  LName,  product,hp.getNext()));
        }
    }
    //________________________________________________________________________
    // غيرنا من انت الى سترنق لان الاصفار بتروح لوعاملناها ك انت
    public Employee searchEmployeeByID(String empID){
        Employee hp =head;
        while(hp!=null){
            //check if the id equal the other id
            if (empID.equals(hp.getEmpID())) {
                 break;
            }
            hp=hp.getNext();
        }
        return hp;
    }
    //_________________________________________________________________________
   static public  void swapEmployees(Employee x ,Employee y){
        
        String empID;
        String FirstName ;
        String LastName ;
        String product;
        //swap id 
        empID=x.getEmpID();
        x.setEmpID(y.getEmpID());
        y.setEmpID(empID);
        //swap Firstname
        FirstName=x.getFname();
        x.setFname(y.getFname());
        y.setFname(FirstName);
        //swap last name 
        LastName=x.getLName();
        x.setLName(y.getLName());
        y.setLName(LastName);
        // swap product
        product=x.getProduct();
        x.setProduct(y.getProduct());
        y.setProduct(product);
        
    }
    //__________________________________________________________________________
    public void deleteEmployeeByID(String empID){
        //check if the linked list empty or not
        if (!isEmpty()) {
            if (head.getEmpID()==empID)
                head=head.getNext();
            else {
                Employee hp=head;
                while(hp.getNext()!=null){
                    if (hp.getNext().getEmpID()==empID) {
                        hp.setNext(hp.getNext().getNext());break;
                    }
                    hp=hp.getNext();
                }
            }
        }
    }
    //________________________________________________________________________
    private boolean isEmpty() {
        if (head==null)
            return true ;
        else 
            return false ;
    }
    //_________________________________________________________________________
    
    
}
