package com.revature;

/**
 * @author Osey Ojemen
 * Date: 6/4/2023
 *  PROJECT
 *
 *  Purpose: This program will display menu to allow the user load Customer's Data,
 *           add new customer data, display customers information, retrieve customers data,
 *           retrieve customers with total sales based on their range and on selection the
 *           program ends.
 *
 */

import com.revature.utils.ConnectionUtil;

import com.revature.utils.JavalinAppConfig;

import java.sql.Connection;
import java.sql.SQLException;

public class MyLauncher {

    public static void main(String[] args) {

        //Establish connection
        try (Connection conn = ConnectionUtil.getConnection()) {
            System.out.println("CONNECTION SUCCESSFUL :)");
        } catch (SQLException e) {
            System.out.println("Connection Failed :(");
        }

        // JavalinAppConfig object
        JavalinAppConfig app = new JavalinAppConfig();

        // start the server and allow it to listen on port 8080
        app.start(8080);
}

}