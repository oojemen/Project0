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

import com.revature.models.Employee;

import java.util.ArrayList;

public interface EmployeeDAOInterface {

     ArrayList<Employee> getAllEmployee();

    //a method that SELECTS a Role by its ID
    Employee getEmployeeById(int id);

    //a method that UPDATEs a Employee's Location

   boolean updateEmployee(Employee employee);


   Employee insertEmployee(Employee emp) ;

    boolean deleteEmployee(int employeeId);


}
