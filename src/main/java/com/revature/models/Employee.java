package com.revature.models;

/**
 * @author Osey Ojemen
 * Date: 6/4/2023
 *  PROJECT
 *
 *  Purpose: This program will display menu to allow the user load Customer's Data,
 *           add new customer data, display customers information, retrieve customers data,
 *           retrieve customers with total sales based on their range and on selection the
 *           program ends.
 *
 */

//import required java class
//import java.util.Arrays;
//import java.util.Scanner;
//import java.util.Scanner;

public class Employee  {

    private int employeeId;
    private String location;
    private String first_Name;

    private String last_Name;

    //constructor which sets the values of variables
    public  Employee( int employeeId, String first_Name, String last_Name,  String employee_location) {
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.employeeId = employeeId;
        this.location = location;


    }
    public  Employee( String first_Name, String last_Name,  String location) {
        this.first_Name = first_Name;
        this.last_Name = last_Name;

        this.location = location;

    }
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFirstName() {
        return first_Name;
    }

    public void setFirstName(String first_Name) {
        this.first_Name = first_Name;
    }

    public String getLastName() {
        return last_Name;
    }

    public void setLastName(String lastName) {
        this.last_Name = last_Name;
    }

    // continue here
    @Override
    public String toString(){

        return "Employee \n( employee_id="  + employeeId  +  ", first_name='" + first_Name
                +", last_name=" + last_Name +  ", Location= " + location + ")";

    }

}




