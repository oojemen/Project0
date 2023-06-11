package com.revature.controllers;

import com.revature.models.Customer;
import com.revature.services.CustomerService;

//import com.revature.models.Employee;
import io.javalin.http.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;


// The controller layer has the sole responsibility of taking in HttpRequests and has the responsibilty of sending the
//    corresponding response.
public class CustomerController {

    private static final CustomerService customerService = new CustomerService();

    // We want to add in a logger so let's follow the same process we did before
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    public static void handleGetAll(Context ctx){
        // Inside here we need to make a call to our Employee Service to get us all the employees listed
        ArrayList<Customer> customer= customerService.getAllCustomer();

        String result = "";

        for (Customer cust: customer){
            result += cust.toString() + "\n";
        }

        ctx.status(200);
        ctx.result(result);

        //Now we can leverage our JSON, GSON, to convert our Java Object to a JSON

        ctx.status(200);
        ctx.json(customer);

    }

    public static void handleCreate(Context ctx){
        ctx.result("Hello World from the employee controller");

        // To create a new employee from our Context body we need to essentially take it in as a JSON and convert it
        // To an object of the appropriate class

        Customer cust = ctx.bodyAsClass(Customer.class);

        Customer returnedCustomer = customerService.createNewCustomer(cust);

        // If the employee object we receive from the service is null, something has gone wrong
        // If it is not null, yay we did it

        if (returnedCustomer != null) {
            // This means the employee was created
            ctx.status(201);
            ctx.json(returnedCustomer);
            logger.info("The following employee was created: " + returnedCustomer.toString());
        } else {
            // What happens if it comes back null?
            ctx.status(400);
            logger.warn("Creation failed");
        }
    }

    // Create some method stubs here just for now
    public static void handleGetOne(Context ctx) {
        ctx.status(405);
    }

    public static void handleUpdate(Context ctx) {
        ctx.status(405);
    }

    public static void handleDelete(Context ctx) {
        ctx.status(405);
    }

}
