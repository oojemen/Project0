package com.revature.controllers;


import com.revature.daos.EmployeeDAO;
import com.revature.models.Employee;
import com.revature.services.EmployeeService;
import io.javalin.http.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class EmployeeController {

//***********************************************//

 /*

 public class EmployeeController {

    The controller layer has the sole responsibility of taking in HttpRequests and has the responsibilty of sending the
    corresponding response.

    For our responses, best practice will be to return an appropriate message in the response body and have the proper
    status code

    Just like before we essentially want to map our CRUD methods to handlers

    TODO Create handlers for the following:
    Create
    Read (All)
    Read (One)
    Update
    Delete

    We'll be implementing the create and read all methods and adding stubs for the rest of them
     */

    private static final EmployeeService employeeService = new EmployeeService(new EmployeeDAO());

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);


    public static void handleGetAll(Context ctx){
        // Inside here we need to make a call to our Employee Service to get us all the employees listed
        ctx.status(405);

    }

    public static void handleCreate(Context ctx){

        ctx.status(405);

       // ctx.result("Hello World from the employee controller");
    }
    public static void handleUpdate(Context ctx){


        // We need to deserialize that and create a Role object
        Employee submittedEmployee = ctx.bodyAsClass(Employee.class);

        // Call the roleService to actually do something with this info
        boolean updateSuccessful = employeeService.updateLocation(submittedEmployee.getFirstName(),
                submittedEmployee.getLastName(), submittedEmployee.getLocation());

        // So updateSuccessful should let us know if we successfully updated the DB
        if (updateSuccessful){
            // This is good
            ctx.status(200);
            // Successful update should have some logging
            logger.info("Employee: " + submittedEmployee.getFirstName()  + submittedEmployee.getLastName()   + " location was updated to " +
                    submittedEmployee.getLocation());
        } else{
            // Was not able to update DB for some reason
            ctx.status(400);
        }
    }

    public static void handleGetOne(Context ctx){
        // Recall that the path for this will be http://localhost:7070/roles/{id}
        // This will match http://localhost:7070/roles/1
        // But it will also match http://localhost:7070/roles/NaN

        //int x = ctx.pathParam("id"); // We need to find a way to parse this
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
        ctx.status(405); // Method is not allowed
    }
}

