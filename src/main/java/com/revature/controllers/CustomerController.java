package com.revature.controllers;

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
import com.revature.services.CustomerService;

import io.javalin.http.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


// This controller layer has the sole responsibility of taking in HttpRequests and has the responsibilty of sending the
//    corresponding response.
public class CustomerController {

    private static final CustomerService customerService = new CustomerService();

    // logger to keep track of requests and responses
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);


    //get all customer request method
    public static void handleGetAll(Context ctx){

        // Inside here we need to make a call to our Customer Service to get us all the customers listed

        ctx.status(200);
        ctx.json(customerService.getAllCustomer());

    }

    public static void handleCreate(Context ctx){

        Customer customer = ctx.bodyAsClass(Customer.class);

        Customer returnedCustomer = customerService.createNewCustomer(customer);

        if (returnedCustomer != null) {

            ctx.status(201);
            ctx.json(returnedCustomer);
            logger.info("The following customer was created: " + returnedCustomer.toString());
        } else {
            // 400 HTTP response
            ctx.status(400);
            logger.warn("Creation failed");
        }
    }

    // Create
    public static void handleGetOne(Context ctx) {

        int id;
        try{
            id = Integer.parseInt(ctx.pathParam("id"));
        }catch (NumberFormatException e){
            // This block running means they didn't have a valid integer in their path
            ctx.status(400);

            // Let's add a logger to show the invalid id
            logger.warn("Unable to parse id = " + ctx.pathParam("customerid"));

            // Adding a return statement here because there's no point continuing with a bad int
            return;
        }

        // Let's call the role service and attempt to pull the value
        Customer customer = customerService.getCustomerById(id);

        // We need to check if the role is null or not
        if (customer != null){
            // This is good, it found the roll
            ctx.status(200);
            ctx.json(customer);
            // This is unnecessary but we'll add a log here
            logger.info("The following Customer was obtained from db: " +customer.toString());
        } else{
            ctx.status(404);
            logger.warn("No resource was found at id = " + id + " from ip: " + ctx.ip());
        }
    }

    public static void handleUpdate(Context ctx) {

        // Retrieve the updated customer details from the request body
        Customer submittedCustomer = ctx.bodyAsClass(Customer.class);
        submittedCustomer.setCustomerid(Integer.parseInt(ctx.pathParam("id")));

        // Call the CustomerService to update the customer
        boolean isUpdated = customerService.updateCustomer( submittedCustomer);

        if (isUpdated) {
            // Customer updated successfully, return a 200 OK response
            ctx.status(200);
            ctx.result("Customer updated successfully");
            logger.info( "Customer is updated.");
        } else {
            // Customer not found or update failed, return a 404 Not Found or 400 Bad Request response
            ctx.status(404);
            ctx.result("Customer not found ");
            logger.warn("Customer update failed");
        }
    }

    public static void handleDelete(Context ctx) {
        // Extract the customer ID from the request parameters or path
        int customerid = Integer.parseInt(ctx.pathParam("id"));

         // Call the CustomerService to delete the customer
       if(customerService.deleteCustomer(customerid)){
           ctx.result("customer deleted");
       }

       else {
            // Customer not found or deletion failed, return a 404 Not Found response
            ctx.status(404);
            ctx.result("Customer not found: deletion failed");
        }
    }

}