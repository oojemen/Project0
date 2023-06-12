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

import java.util.ArrayList;

import com.revature.models.Customer;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//This Class is responsible for all things ROLE DATA. (RoleDAO == Role Data Access Object)
//This Class will access/query the roles table in the DB.
public class CustomerDAO implements CustomerDAOInterface{

    @Override
    public ArrayList<Customer> getAllCustomer() {


        //Instantiate a Connection object so that we can talk to the DB
        try (Connection conn = ConnectionUtil.getConnection()) {

            //A String that represents our SQL statement
            String sql = "SELECT * FROM customer";

           PreparedStatement s = conn.prepareStatement(sql);

            //Now, execute the query, and save the results in a ResultSet
            ResultSet rs = s.executeQuery();

            ArrayList<Customer> customerList = new ArrayList<>();

            //Instantiate a EmployeeDAO so we can get a Employee object for our Customer objects
            EmployeeDAO empDAO = new EmployeeDAO();

            while(rs.next()){

                //For every Employee record returned from the DB, make a new Employee object
                Customer customer = new Customer(
                        rs.getInt("customerid"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getInt("totalsales"),
                        empDAO.getEmployeeById(rs.getInt("employeeid_fk"))
                        //we needed to retrieve a Employee object this way, because the DB just returns the int PK
                        //"use the getRoleById method to return a role object using the role_id_fk"
                );

                //for every new Employee, add it to the ArrayList
                customerList.add(customer);
                System.out.println(customer);
                //by the time this while loop breaks (when rs.next() == false), our ArrayList will be full

            }

            return customerList; //after all that nonsense above, we return our fully populated ArrayList

        } catch(SQLException e){
            System.out.println("Failed to get all customers");
            e.printStackTrace(); //detailed info in our console about what went wrong
        }

        return null;
    }
    @Override
    public Customer insertCustomer(Customer customer) {

        //Establish DB connection
        try(Connection conn = ConnectionUtil.getConnection()){

            // create the SQL String that we're sending to the database
            String sql = "INSERT INTO customer (customerid, firstname, lastname, totalsales, employeeid_fk) VALUES (?, ?, ?, ?, ?)";

            //Instantiate a PreparedStatement to hold our SQL String and fill its variables
            PreparedStatement ps = conn.prepareStatement(sql);

            //we can now use our PreparedStatement to fill in the wildcards one by one
            ps.setInt(1, customer.getCustomerid());
            ps.setString(2, customer.getFirstname());
            ps.setString(3, customer.getLastname());
            ps.setInt(4, customer.getTotalsales());
            ps.setInt(5, customer.getEmployeeid_fk());

            // execute the update
            ps.executeUpdate();

            // return the inputted customer back to the user as confirmation
            return customer;

        } catch(SQLException e){
            System.out.println("Insert employee failed!");
            e.printStackTrace(); //tell the user what exactly went wrong
        }

        return null;
    }

    @Override
    public Customer getCustomerById(int id){

        // Establish a database connection
        try(Connection conn = ConnectionUtil.getConnection()){

        // Prepare a query
        String sql = "SELECT * FROM customer WHERE customerid = ?";

            // Create a prepared statement
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            // Execute the query
            ResultSet rs = ps.executeQuery();

            EmployeeDAO empDAO = new EmployeeDAO();

            if (rs.next()) {
                // Retrieve customer data from the result set

                // Create a Customer object
                Customer customer = new Customer(
                        rs.getInt("customerid"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getInt("totalsales"),
                        empDAO.getEmployeeById(rs.getInt("employeeid_fk"))

                );

                return customer;
            }
            else{
                System.out.println("Customer ID could not be retrieved!");
            }
        } catch (SQLException e) {
            System.out.println("Retrieve customer by ID failed!");
            e.printStackTrace();
        }

        return null; // No customer found with the given ID
    }


    @Override
    public boolean updateCustomer(Customer customer) {
        // Establish a database connection
        try(Connection conn = ConnectionUtil.getConnection()){


            // Prepare an update query
        String sql = "UPDATE customer SET firstname = ?, lastname = ?, totalsales = ? WHERE customerid = ?";

            // Create a prepared statement
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, customer.getFirstname());
            ps.setString(2, customer.getLastname());
            ps.setInt(3, customer.getTotalsales());
            ps.setInt(4, customer.getCustomerid());

            // Execute the update
            ps.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println("Total sales update failed!");
            e.printStackTrace();
        }

        return false; // The total sales value update failed
    }

    public boolean deleteCustomer(int id) {
        // Establish a database connection
        try (Connection conn = ConnectionUtil.getConnection()) {

            // Prepare a delete query
            String sql = "DELETE FROM customer WHERE customerid = ?";

            // Create a prepared statement
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            // Execute the delete
            ps.executeUpdate();

            return true; // The customer was successfully deleted

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false; // The customer delete failed
    }
}

