package com.revature;

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

import com.revature.models.Customer;
import com.revature.models.User;
import com.revature.models.Employee;

//
import java.util.Scanner;
//import java.util.Arrays;
//import java.util.Scanner;

public class MyLauncher {


    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        Scanner inputStr = new Scanner(System.in);
        displayEmployee();

        Customer[] customer= {} ; //empty array of customer objects
        Employee[] employee= {} ;
        int selection = 0;

        //the loop until user enters 6 (Exit)
        while (selection != 6) {
            displayMenu();
            selection = input.nextInt();
            if (selection == 1) {
                System.out.println( "  Load customer data ");
                System.out.println("How many customers would you like to enter? : "); //prompts for input
                int numCustomer = input.nextInt();
                customer = new Customer[numCustomer];

                for (int i = 0; i < numCustomer; i++) {
                    System.out.println("Enter the Customer's id (5 digit number): "); //prompts for input
                    int id = input.nextInt(); //collects an customer's id
                    //input.nextInt();

                    System.out.println("Enter the Customer's name: "); //prompt for input
                    String name = inputStr.nextLine(); //store customer's name

                    System.out.println("Enter the Customer's Total Sales: "); //prompt for input
                    double totalSales = input.nextDouble(); //stores customer's total sales

                    Customer newCustomer = new Customer(name, id, totalSales); //creating an customer object with id name total sales
                    customer[i] = newCustomer; //adding the created customer objects to array

                }
                System.out.println( "  Data Saved !!! ");
            }

            else if (selection == 2) {
                System.out.println("   Add New Customer ");
                System.out.println("Enter the Customer's id (5 digit number): "); //prompt for an input
                int id = input.nextInt(); //stores a customer's id
                //input.nextLine();
                System.out.println("Enter the Customer's name: "); //prompt user for input
                String name = inputStr.nextLine(); //stores an customer's name
                System.out.println("Enter the Customer's Total Sales : "); //prompt user for input
                double totalSales = input.nextDouble(); //stores an customer's sales
                Customer newCustomer = new Customer(name, id, totalSales); //creating an customer object with id name total sales

                //expand the array
                Customer[] temp = new Customer[customer.length + 1];
                for (int i = 0; i < temp.length - 1; i++) {
                    temp[i] = customer[i]; //pass each element in customer array to the temp array
                }
                temp[temp.length - 1] = newCustomer; //add the created customer object to the array
                customer = temp.clone(); //pass the temp array to the customer array
                System.out.println( "  Data Saved !!! ");
            }
            else if (selection == 3) {
                for (Customer cust : customer) {
                    //display each customer's information
                    System.out.println(cust.toString());
                }
            }
            else if (selection == 4) {
                System.out.println("Retrieve Customer's Data ");
                System.out.println("Enter the Customer's ID: "); //prompt for input
                int id = input.nextInt(); //gets an customer's id
                int i = 0;
                boolean found = false;
                //check to see if a customer with the id inputed by the user is in array
                for (i = 0; i < customer.length; i++) {
                    if (customer[i].getID() == id) {
                        found = true;
                        break;
                    }
                }
                if (found) {
                    //printing out the user with the specified id's data
                    System.out.println("Customer's Data: " + customer[i].toString());
                }
                else {
                    System.out.println("Customer not found.");
                }
            } else if (selection == 5) {

                System.out.println("   Retrieve Customer's Data Based on Range ");
                System.out.println("Enter the Minimum Sales: "); //prompt for input
                double min = input.nextDouble(); //get lowest value of the range
                System.out.println("Enter the Maximum Sales: "); //prompt for input
                double max = input.nextDouble(); //gets highest value of the range
                for (Customer cust : customer) {
                    if (cust.getTotalSales() >= min && cust.getTotalSales() <= max) {
                        //displays the customer's info if the sales is within the range
                        System.out.println(cust.toString());
                    }
                }
            } else if (selection == 6) {
                System.out.println("   End Program ");
                System.exit(0); // exit program
            }
        }
    }

    //A method that displays the options of the program the user can select
    public static void displayMenu() {
        System.out.println("    Menu:");
        System.out.println("1. Load Customer's Data");
        System.out.println("2. Add new Customer");
        System.out.println("3. Display All Customer Information");
        System.out.println("4. Retrieve Customer's Data");
        System.out.println("5. Retrieve Customer with Total Sales based on range");
        System.out.println("6. Exit");
        System.out.println( " ");
        System.out.println( " Enter your selection ");

    }
    public static void displayEmployee(){
    String name= " ";
    int id= 0;

       //User newCustomer = new User(name, id);
        User user = new User(name, id);
        System.out.println("Welcome to Customer Transaction database");

        Scanner input = new Scanner(System.in);
        Scanner inputStr = new Scanner(System.in);

        Employee[] employee= {} ;

        System.out.println("Are you an employee (Yes or No) ?");
        String isEmployee=inputStr.nextLine();

       // user.getEmployed(isEmployee);
        if (isEmployee.equalsIgnoreCase("yes")) {

            System.out.println("Welcome to your system ");
            forEmployee();

        } else {
            nonEmplooyee();

        }


    }

    public static void nonEmplooyee(){

        Scanner input = new Scanner(System.in);
        Scanner inputStr = new Scanner(System.in);
        Customer[] customer= {} ;

        System.out.println("   Welcome New Customer ");
        System.out.println("Enter your Customer's id (5 digit number): "); //prompt for an input
        int id = input.nextInt(); //stores a customer's id
        //input.nextLine();
        System.out.println("Enter the Customer's name: "); //prompt user for input
        String name = inputStr.nextLine(); //stores an customer's name
        System.out.println("Enter the Customer's Total Sales : "); //prompt user for input
        double totalSales = input.nextDouble(); //stores an customer's sales
        Customer newCustomer = new Customer(name, id, totalSales); //creating an customer object with id name total sales

        //expand the array
        Customer[] temp = new Customer[customer.length + 1];
        for (int i = 0; i < temp.length - 1; i++) {
            temp[i] = customer[i]; //pass each element in customer array to the temp array
        }
        temp[temp.length - 1] = newCustomer; //add the created customer object to the array
        customer = temp.clone(); //pass the temp array to the customer array
    }
public  static void forEmployee(){

    Scanner input = new Scanner(System.in);
    Scanner inputStr = new Scanner(System.in);
    Employee[] employee= {} ;


    System.out.println("Enter your Employee id (5 digit number): "); //prompt for an input
    int id = input.nextInt(); //stores a employee's id
    //input.nextLine();
    System.out.println("Enter Employee name: "); //prompt user for input
    String name = inputStr.nextLine(); //stores an employee's name
    System.out.println("Enter the Employee Location : "); //prompt user for input
    String location = inputStr.nextLine(); //stores an employee's sales
    Employee newEmployee = new Employee(name, id,location); //creating an employee object with id name total sales

    //expand the array
    Employee[] temp = new Employee[employee.length + 1];
    for (int i = 0; i < temp.length - 1; i++) {
        temp[i] = employee[i]; //pass each element in employee array to the temp array
    }
   temp[temp.length - 1] = newEmployee; //add the created employee object to the array
    employee = temp.clone(); //pass the temp array to the employee array
}


}