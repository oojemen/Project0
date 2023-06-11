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

    private int customerId;
    private String firstName;

    private String lastName;

    private int totalSales;

    private Employee employee;

    private int employeeId_fk;

    //constructor which sets the values of variables
    public  Customer(int customerId, String firstName,  String lastName,  int totalSales, Employee employee) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerId = customerId;
        this.totalSales = totalSales;


    }
    public  Customer(String firstName,  String lastName,  Employee employee) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employee=employee;
    }
    public  Customer(String firstName,  String lastName,  int employeeId_fk) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeId_fk = employeeId_fk;

    }
    //getters
    public  int getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getTotalSales() {
        return totalSales;
    }

    public void setTotalSales() {
        this.totalSales= totalSales;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getEmployeeId_fk() {
        return employeeId_fk;
    }

    public void setEmployeeId_fk(int employeeId_fk) {
        this.employeeId_fk = employeeId_fk;
    }

    //displays formatted string of an customer's data
    @Override
    public String toString(){

        return "Customer \n( customer_id="  +customerId  +  ", first_name='" + firstName
                +", last_name=" + lastName +  ", Total Sales= $" + totalSales +  ", employee=" + employee
                + ", employee_id_fk=" + employeeId_fk + ")";

    }

}
