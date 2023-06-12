package com.revature.daos;

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

import com.revature.models.Customer;

import java.util.ArrayList;

public interface CustomerDAOInterface {

    ArrayList<Customer> getAllCustomer();

    Customer insertCustomer(Customer customer);


    Customer getCustomerById(int id);

    boolean updateCustomer(Customer customer);

    boolean deleteCustomer(int id);
}
