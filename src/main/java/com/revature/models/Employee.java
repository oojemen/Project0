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
import java.util.Arrays;
//import java.util.Scanner;

public class Employee extends User {

    private double totalSales;
    private String location;

    //constructor which sets the values of variables
    public  Employee(String name, int id, String location) {
        super (name, id);
        this.totalSales = totalSales;

    }

    //total sales
    public String  getLocation() {
        return location;
    }
    public void setLocation() {
        this.location= location;
    }

}
