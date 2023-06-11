package com.revature.daos;

import com.revature.models.Employee;

public interface EmployeeDAOInterface {

    //a method that SELECTS a Role by its ID
    Employee getEmployeeById(int id);

    //a method that UPDATEs a Employee's Location

   boolean updateEmployeeLocation(String first_Name, String last_Name,  String location);


}
