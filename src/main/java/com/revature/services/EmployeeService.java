package com.revature.services;

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

import com.revature.daos.EmployeeDAO;
import com.revature.daos.EmployeeDAOInterface;
import com.revature.models.Employee;

import java.util.ArrayList;

public class EmployeeService {

    private static final EmployeeDAOInterface employeeDao = new EmployeeDAO();
    public Employee createNewEmployee(Employee employee){
        return employeeDao.insertEmployee(employee);

    }

    public boolean updateEmployee(Employee employee) {


        return employeeDao.updateEmployee(employee);

    }

    public ArrayList<Employee> getAllEmployee(){
        // There's no "extra" business logic for this method *yet* but we may add other things later
        return employeeDao.getAllEmployee();
    }

    public Employee getEmployeeById(int id){

        return employeeDao.getEmployeeById(id);
    }

    public boolean deleteEmployee(int employeeid) {

    return employeeDao.deleteEmployee(employeeid);
    }
}