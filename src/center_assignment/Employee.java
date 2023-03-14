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
public class Employee {
    private String empID;
private String Fname ;
private String LName ;
private String product;
private String phone;
private int age;
private int center;
private Employee next; 

    public Employee(String empID, String Fname, String LName, String product,  Employee next) {
        this.empID = empID;
        this.Fname = Fname;
        this.LName = LName;
        this.product = product;
        
        this.next = next;
    }


    public Employee(String empID, String Fname, String LName, String product) {
        this.empID = empID;
        this.Fname = Fname;
        this.LName = LName;
        this.product = product;
        
    }

   

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String Fname) {
        this.Fname = Fname;
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCenter() {
        return center;
    }

    public void setCenter(int center) {
        this.center = center;
    }

    public Employee getNext() {
        return next;
    }

    public void setNext(Employee next) {
        this.next = next;
    }


}

