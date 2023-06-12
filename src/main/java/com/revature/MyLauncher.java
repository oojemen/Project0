package com.revature;

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