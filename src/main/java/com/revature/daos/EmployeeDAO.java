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
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;

public class EmployeeDAO implements EmployeeDAOInterface {

    public Employee getEmployeeById (int id) {

        try (Connection conn = ConnectionUtil.getConnection()) {
            //A String that represents our SQL statement
            String sql = "SELECT * FROM employee WHERE employee_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            //rs.next() check for data in the ResultSet.
            if(rs.next()) {

                Employee employee = new Employee(
                        rs.getInt("employee_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("employee_location")
                );

                return employee; //return the Employee object to the user!

            }

        } catch(SQLException e){
            System.out.println("error getting Employee");
            e.printStackTrace(); //show error message
        }

        return null; // return if something goes wrong

    }

    @Override
    public boolean updateEmployee(Employee employee) {


        try (Connection conn = ConnectionUtil.getConnection()) {

            //Create the SQL String (to be filled with the values from the method parameters)
            String sql = "UPDATE employee SET first_name = ?, last_name = ?, employee_location = ?  where employee_id = ?";

            //Instantiate a PreparedStatement to fill in the variable wildcard values
            PreparedStatement ps = conn.prepareStatement(sql);

            //set parameters for prepared statements
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setString(3, employee.getEmployee_location());
            ps.setInt(4, employee.getEmployee_id());

            //execute the update! (We're not getting any data returned, so no need for a ResultSet object)
            ps.executeUpdate();
            //NOTE: executeUpdate() instead of executeQuery(). query is for SELECTS only

            //if we get this far in the try block, we can assume nothing went wrong. return true!
            return true;

        } catch (SQLException e) {
            System.out.println("Update failed!!");
            e.printStackTrace(); //this is what gives us an error message in the console
        }

        return false; //if update fails, we get returned false

    }
    public boolean deleteEmployee(int employeeid) {
        // Establish a database connection
        try (Connection conn = ConnectionUtil.getConnection()) {

        // Prepare a delete query
        String sql = "DELETE FROM employee WHERE employee_id = ?";

            // Create a prepared statement
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, employeeid);

            // Execute the delete
             ps.executeUpdate();

             return true; // The customer was successfully deleted

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false; // The customer delete failed
    }
    @Override
    public ArrayList<Employee> getAllEmployee() {

        //Instantiate a Connection object so that we can talk to the DB
        try(Connection conn = ConnectionUtil.getConnection()){

            //A String that represents our SQL statement
            String sql = "SELECT * FROM employee";


            PreparedStatement ps = conn.prepareStatement(sql);

            //Now, execute the query, and save the results in a ResultSet
            ResultSet rs = ps.executeQuery();

            //Instantiate an empty ArrayList that will hold our incoming Employee data
            ArrayList<Employee> employeeList = new ArrayList<>();

            while(rs.next()){

                //For every Employee record returned from the DB, make a new Employee object
                Employee employee = new Employee(
                        rs.getInt("employee_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("employee_location")
                );

                //for every new Employee, add it to the ArrayList
                employeeList.add(employee);

                //by the time this while loop breaks (when rs.next() == false), our ArrayList will be full

            }

            return employeeList; //after all that nonsense above, we return our fully populated ArrayList

        } catch(SQLException e){
            System.out.println("Failed to get all employees");
            e.printStackTrace(); //detailed info in our console about what went wrong
        }

        return null;
    }
    @Override
    public Employee insertEmployee(Employee employee) {

        //Establish DB connection
        try(Connection conn = ConnectionUtil.getConnection()){

            //insert statement
            String sql = "INSERT INTO employee (employee_id, first_name, last_name, employee_location) VALUES (?, ?, ?, ?)";

            //Instantiate a PreparedStatement to hold our SQL String and fill its variables
            PreparedStatement ps = conn.prepareStatement(sql);

            // use PreparedStatement to fill in the wildcards one by one
            ps.setInt(1, employee.getEmployee_id());
            ps.setString(2, employee.getFirstName());
            ps.setString(3, employee.getLastName());
            ps.setString(4, employee.getEmployee_location());

            // execute the update
            ps.executeUpdate();

            return employee;

        } catch(SQLException e){
            System.out.println("Insert employee failed!");
            e.printStackTrace(); //Show what exactly went wrong
        }
        return null;
    }
}