package com.revature.daos;



import com.revature.models.Employee;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import java.sql.*;
//import java.util.ArrayList;

public class EmployeeDAO implements EmployeeDAOInterface {

    @Override
    public Employee getEmployeeById (int id) {

        /*We need a String that holds the SQL command we want to run on the DB.
             This String has a wildcard/parameter/variable for the role_id (the ?)
             We have to take the user-inputted role id and put it into this wildcard*/

        try (Connection conn = ConnectionUtil.getConnection()) {
            //A String that represents our SQL statement
            String sql = "SELECT * FROM employee WHERE employeeId = ?";

            //We need a PreparedStatement object to fill the wildcard in. (fill the ?)
            //PreparedStatements "prepare" a sql command before we send it to the database
            PreparedStatement ps = conn.prepareStatement(sql);

            //here, we are inserting a value for the ? wildcard
            //This is saying "The first wildcard will get filled by the id variable)
            ps.setInt(1, id);

            /*Here, we are execute the fully prepared SQL command that has been stored in the PreparedStatement.
            The results of the Query will be stored in a ResultSet object.*/
            ResultSet rs = ps.executeQuery();

            //rs.next() checks if there is any data in the ResultSet that we haven't accessed yet.
            if(rs.next()) {

                //Extract the role data from the ResultSet. We need to use the all-args constructor to store all the data
                //to get data out of a ResultSet, we use the rs.get___() methods
                Employee employee = new Employee(
                        rs.getString("first_Name"),
                        rs.getString("last_Name"),
                        rs.getString("location")
                );
                //Remember, this is just a constructor. we opened it up for the sake of cleaner code.

                return employee; //return the Role object to the user!

            }

        } catch(SQLException e){
            System.out.println("error getting Employee");
            e.printStackTrace(); //remember, printStackTrace() tells us our error message
            //VERY important for debugging, so we know what went wrong and where.
        }

        return null; //null will get returned if something goes wrong

    } //end of getRoleById() method


    @Override
    public boolean updateEmployeeLocation(String first_Name, String last_Name,  String location) {
        return false;
    }
        }