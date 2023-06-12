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

import com.revature.daos.CustomerDAO;
import com.revature.daos.CustomerDAOInterface;
import com.revature.models.Customer;

import java.util.ArrayList;

public class CustomerService {
    private final CustomerDAOInterface customerDao = new CustomerDAO();
    public ArrayList<Customer> getAllCustomer(){
        return customerDao.getAllCustomer();
    }
    public Customer createNewCustomer(Customer customer){
        return customerDao.insertCustomer(customer);
    }
      public Customer getCustomerById(int id){
         return customerDao.getCustomerById(id);

      }
    public boolean updateCustomer(Customer customer) {
        return customerDao.updateCustomer(customer);
    }

    public boolean deleteCustomer(int id) {
        return customerDao.deleteCustomer(id);
    }
}
