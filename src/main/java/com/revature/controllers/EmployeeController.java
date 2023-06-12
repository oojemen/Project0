package com.revature.controllers;

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

import com.revature.models.Employee;
import com.revature.services.EmployeeService;
import io.javalin.http.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class EmployeeController {

 /*
    TODO Create handlers for the following:
    Create
    Read (All)
    Read (One)
    Update
    Delete
     */

    private static final EmployeeService employeeService = new EmployeeService();

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    //method to handle get request on javelin app
    public static void handleGetAll(Context ctx){
        // Array list to get employee data/new employee object
        ArrayList<Employee> employee = employeeService.getAllEmployee();

        // Now we can leverage our JSON mapper, GSON, to convert our Java Object to a JSON
        ctx.status(200);
        ctx.json(employee);
    }

    //method to handle create on javelin app
    public static void handleCreate(Context ctx){

        Employee employee = ctx.bodyAsClass(Employee.class);

        Employee returnedEmployee = employeeService.createNewEmployee(employee);

        if (returnedEmployee != null) {
            // This means the employee was created
            ctx.status(201);
            ctx.json(returnedEmployee);
            logger.info("The following employee was created: " + returnedEmployee.toString());
        } else {
            // 400 HTTP response
            ctx.status(400);
            logger.warn("Creation failed");
        }
    }

    public static void handleUpdate(Context ctx){

        // We need to deserialize that and create a Role object
        Employee submittedEmployee = ctx.bodyAsClass(Employee.class);
        submittedEmployee.setEmployee_id(Integer.parseInt(ctx.pathParam("id")));

        // Call the roleService to actually do something with this info
        boolean updateSuccessful = employeeService.updateEmployee(submittedEmployee);

        //  if we successfully updated the DB
        if (updateSuccessful){

            ctx.status(200);

            logger.info("Employee update successful " );
        } else{
            // Was not able to update DB for some reason
            ctx.status(400);
        }
    }

    public  static void handleGetOne(Context ctx){

        int id;
        try{
            id = Integer.parseInt(ctx.pathParam("id"));
        }catch (NumberFormatException e){
            // This block running means they didn't have a valid integer in their path
            ctx.status(400);

            // Let's add a logger to show the invalid id
            logger.warn("Unable to parse id = " + ctx.pathParam("id"));

            // Adding a return statement here because there's no point continuing with a bad int
            return;
        }

        // Let's call the role service and attempt to pull the value
        Employee employee = employeeService.getEmployeeById(id);

        // We need to check if the role is null or not
        if (employee != null){
            // This is good, it found the roll
            ctx.status(200);
            ctx.json(employee);
            // This is unnecessary but we'll add a log here
            logger.info("The following employee was obtained from db: " + employee.toString());
        } else{
            ctx.status(404);
            logger.warn("No resource was found at id = " + id + " from ip: " + ctx.ip());
        }
    }

    public static void handleDelete(Context ctx){

        // Extract the customer ID from the request parameters or path
        int employeeid = Integer.parseInt(ctx.pathParam("id"));

        // Call the CustomerService to delete the customer
        boolean isDeleted = employeeService.deleteEmployee(employeeid);

        if (isDeleted) {
            // Customer deleted successfully, return a 204 No Content response
            ctx.status(204);
        } else {
            // Customer not found or deletion failed, return a 404 Not Found response
            ctx.status(404);
            ctx.result("Customer not found or deletion failed");
        }
    }

}

