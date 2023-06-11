package com.revature.daos;

import java.sql.*;
import java.util.ArrayList;

import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//This Class is responsible for all things ROLE DATA. (RoleDAO == Role Data Access Object)
//This Class will access/query the roles table in the DB.
public class CustomerDAO implements CustomerDAOInterface{

   // @Override
    public ArrayList<Customer> getAllCustomer() {


        //Instantiate a Connection object so that we can talk to the DB
        try (Connection conn = ConnectionUtil.getConnection()) {

            //A String that represents our SQL statement
            String sql = "SELECT * FROM customer";

            Statement s = conn.createStatement();

            //Now, execute the query, and save the results in a ResultSet
            ResultSet rs = s.executeQuery(sql);

            ArrayList<Customer> customerList = new ArrayList<>();

            //Instantiate a EmployeeDAO so we can get a Employee object for our Customer objects
            EmployeeDAO empDAO = new EmployeeDAO();

            while(rs.next()){

                //For every Employee record returned from the DB, make a new Employee object
                Customer customer = new Customer(
                       // rs.getInt("customerId"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        empDAO.getEmployeeById(rs.getInt("employeeId_fk"))
                        //we needed to retrieve a Employee object this way, because the DB just returns the int PK
                        //"use the getRoleById method to return a role object using the role_id_fk"
                );

                //for every new Employee, add it to the ArrayList
                customerList.add(customer);

                //by the time this while loop breaks (when rs.next() == false), our ArrayList will be full

            }

            return customerList; //after all that nonsense above, we return our fully populated ArrayList

        } catch(SQLException e){
            System.out.println("Failed to get all employees");
            e.printStackTrace(); //detailed info in our console about what went wrong
        }

        return null;
    }
   // @Override
    public Customer insertCustomer(Customer customer) {

        //REMEMBER - every DAO method must start by opening DB connection
        try(Connection conn = ConnectionUtil.getConnection()){

            //we need to create the SQL String that we're sending to the database
            String sql = "INSERT INTO customer (firstName, lastName, employeeId_fk) VALUES (?, ?, ?)";

            //Instantiate a PreparedStatement to hold our SQL String and fill its variables
            PreparedStatement ps = conn.prepareStatement(sql);

            //we can now use our PreparedStatement to fill in the wildcards one by one
            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.setInt(3, customer.getEmployeeId_fk());

            //now that our SQL String is fully populated with data, we can execute the update
            ps.executeUpdate();

            //No data is returned in an INSERT, so no need to make a ResultSet
            //But we DO want to return the inputted employee back to the user as confirmation
            return customer;

            //if we wanted to, we could have made another DAO method to SELECT the employee we inserted
            //but this return above is fine (and a lot less work)

        } catch(SQLException e){
            System.out.println("Insert employee failed!");
            e.printStackTrace(); //tell the suer what exactly went wrong
        }

        return null;
    }
}

