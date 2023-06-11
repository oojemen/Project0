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

import com.revature.daos.EmployeeDAO;
import com.revature.daos.CustomerDAO;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.utils.ConnectionUtil;


//From Bryann's Driver(main)
import com.revature.utils.JavalinAppConfig;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class MyLauncher {


    public static void main(String[] args) {

  /*This is a try-with-resources block
         A resource (in this case, a DB connection) is opened within the parenthesis
         Another benefit is that the resource will close for us when the block completes
         This is helpful for code cleanup and preventing memory leaks*/
        try (Connection conn = ConnectionUtil.getConnection()) {
            System.out.println("CONNECTION SUCCESSFUL :)");
        } catch (SQLException e) {
            System.out.println("Connection Failed :(");
        }
/*
        //instantiate a EmployeeDAO object so we can use its methods
        EmployeeDAO empDAO = new EmployeeDAO();

        //getting an employee object by id
        System.out.println(empDAO.getEmployeeById(2));

        //try to update the role salary for Manager
        System.out.println(empDAO.updateEmployeeLocation("Shola", "Ojez", "Virginia"));
        System.out.println(empDAO.getEmployeeById(2)); //checking if the Manager salary was updated

        //Instantiate an CustomerDAO object so we can use its methods
        CustomerDAO custDAO = new CustomerDAO();

        //insert a new employee (we need to instantiate it first)
        Customer gold = new Customer("Gold","Adekunle", 3);

        //run the insert method
        System.out.println(custDAO.insertCustomer(gold));

        //get all employees
        ArrayList<Customer> customerList = custDAO.getAllCustomer();

        //use an enhanced for loop to print out each employee
        for(Customer c : customerList){
            System.out.println(c);
        }

 */
        // only applicable to you Project0


        // We'll create a JavalinAppConfig object, so we can create our app with the proper configuration
        JavalinAppConfig app = new JavalinAppConfig();


        // We'll start the server and allow it to listen on port 7070
        app.start(8080);


        // private static final EmployeeService= new EmployeeService();


    }
}