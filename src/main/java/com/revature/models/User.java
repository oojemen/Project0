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

public class User {
    private int id;

    private String name;

    private boolean isEmployee;

    public User(String name, int id) {
        this.name = name;
        this.id = id;
        isEmployee = true;
    }
    public  int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    //Set methods
    public void setName(String name) {
        this.name = name;
    }

    public void setID(int id) {
        this.id = id;
    }

    /*
    public  boolean getEmployed(String isEmployee) {
        if (isEmployee.equalsIgnoreCase("yes")) {

            System.out.println("Welcome to your system " + getID());
            return true;
        } else {
           // displayMenu();
          //  nonEmplooyee();
            return false;

        }
    }


    public static void displayMenu() {
        System.out.println("    Menu:");
        System.out.println("1. Load Customer's Data");
        System.out.println("2. Add new Customer");
        System.out.println("3. Display All Customer Information");
        System.out.println("4. Retrieve Customer's Data");
        System.out.println("5. Retrieve Customer with Total Sales based on range");
        System.out.println("6. Exit");
        System.out.println(" ");
        System.out.println(" Enter your selection ");

    }
    */

    @Override
    public String toString() {
        return "Name =" + name + "User ID : " + id +  "Are you an employee" + isEmployee;
    }
}
