package com.revature.daos;

import com.revature.models.Customer;

import java.util.ArrayList;

public interface CustomerDAOInterface {

    ArrayList<Customer> getAllCustomer();

    Customer insertCustomer(Customer customer);


}
