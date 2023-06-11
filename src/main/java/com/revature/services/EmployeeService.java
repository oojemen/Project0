package com.revature.services;


import com.revature.daos.EmployeeDAO;
import com.revature.daos.EmployeeDAOInterface;
import com.revature.models.Employee;

public class EmployeeService {
    private EmployeeDAOInterface employeeDao;

    public EmployeeService( EmployeeDAOInterface emoloyeeDao){

        this.employeeDao = employeeDao;
    }

    // Now we need to think about how the controller is going to call our methods

    // There are some problems if the controller layer hands us any old integer
    // We're going to add in some logic to do some validation with the information that the controller hands us
    public Employee getEmployeeById(int id){
        // The controller doesn't care WHAT integer it hands us, it's only job is to pass the info

        if (id > 0) {
            return employeeDao.getEmployeeById(id);
        }
        else{
            return null;
            // Our controller will have to have some logic to print out an appropriate statement if it receives
            // a valid Role object or a null object
        }
    }


    // To update our role salary there's a couple of things we need to do first
    // TODO We need to validate that the salary is >0
    // TODO We need to find some way to make the string we're handed TitleCase otherwise there's point searching for it
    public boolean updateLocation(String first_Name, String last_Name, String location) {

        // Before EVERYTHING let's make sure we have a valid string length
        if (first_Name == null || first_Name.trim().equals("") || last_Name == null ||last_Name.trim().equals("") ) {
            return false;
        }

        char[]locationArray = location.toLowerCase().toCharArray();

        // Now I need a string to store the result
        String formattedLocation = "";

        // We need to add the first character as a capital letter
        // We're going to use the wrapper class Character's toUpperCase method
        formattedLocation += Character.toUpperCase(locationArray[0]);

        // Now we need to loop over the rest of the characters and if the character BEFORE the current one is a space
        // we need to capitalize that character, otherwise just add

        String[] words = location.toLowerCase().split(" ");
       // String formattedLocation = "";
        for(String word : words) {
            formattedLocation += Character.toUpperCase(word.charAt(0)) + word.substring(1);
        }
        return false;

    }
}