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

    private int employee_id;
    private String employee_location;
    private String first_name;

    private String last_name;

    //constructor which sets the values of variables
    public  Employee(int employee_id, String first_name, String last_name, String employee_location) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.employee_id = employee_id;
        this.employee_location = employee_location;


    }
    public  Employee(String first_name, String last_name, String employee_location) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.employee_location = employee_location;

    }
    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_location() {
        return employee_location;
    }

    public void setEmployee_location(String employee_location) {
        this.employee_location = employee_location;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String lastName) {
        this.last_name = last_name;
    }

    // continue here
    @Override
    public String toString(){

        return "Employee \n( employee_id="  + employee_id +  ", first_name='" + first_name
                +", last_name=" + last_name +  ", Location= " + employee_location + ")";

    }

}




