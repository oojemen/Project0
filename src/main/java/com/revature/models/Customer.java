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
import java.util.Scanner;


public class Customer extends User {

    private double totalSales;
    //  private char password;

    //constructor which sets the values of variables
    public  Customer(String name, int id, double totalSales) {
        super (name, id);
        this.totalSales = totalSales;
    }

    //total sales
    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales() {
        this.totalSales= totalSales;
    }

    //displays formatted string of an customer's data
    public String toString(){

        return super.getID() + ": " + super.getName() + ", Total Sales $" + totalSales;
    }

}

