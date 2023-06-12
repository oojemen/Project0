package com.revature.utils;

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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//This Class is where we manage and establish our database connection
public class ConnectionUtil {

    public static Connection getConnection() throws SQLException {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); //show error message on console
            System.out.println("problem occurred locating driver");
        }

        String url = System.getenv("URL");
        String username = System.getenv("USERNAME");
        String password = System.getenv("PASSWORD");

        return DriverManager.getConnection(url, username, password);

    }

}