package com.revature.models;

/**
 * @author Osey Ojemen
 * Date: 6/4/2023
 *  PROJECT0
 *
 *  Customer Management System
 *
 *  Purpose: This Application will accept HTTP requests and store them in a connected database.
 *  It utilizes a javalin framework to handle HTTP "CRUD" requests and responses.
 *
 *
 *
 */

public class Customer {

    private int customerid;
    private String firstname;

    private String lastname;

    private int totalsales;

    private Employee employee;

    private int employeeid_fk;

    //constructor which sets the values of variables
    public  Customer(int customerid, String firstname, String lastname, int totalsales, Employee employee) {
        this.customerid = customerid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalsales = totalsales;
        this.employee =employee;


    }
    public  Customer(String firstname, String lastname, Employee employee) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.employee=employee;
    }
    public  Customer(int customerid, int totalsales, int employeeid_fk) {
        this.customerid = customerid;
        this.totalsales = totalsales;
        this.employeeid_fk = employeeid_fk;

    }
    //getters
    public  int getCustomerid() {
        return customerid;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getTotalsales() {
        return totalsales;
    }

    public void setTotalSales() {
        this.totalsales = totalsales;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getEmployeeid_fk() {
        return employeeid_fk;
    }

    public void setEmployeeid_fk(int employeeid_fk) {
        this.employeeid_fk = employeeid_fk;
    }

    //displays formatted string of an customer's data
    @Override
    public String toString(){

        return "Customer \n( customer_id="  + customerid +  ", first_name='" + firstname
                +", last_name=" + lastname +  ", Total Sales= $" + totalsales +  ", employee=" + employee
                + ", employee_id_fk=" + employeeid_fk + ")";

    }

}
