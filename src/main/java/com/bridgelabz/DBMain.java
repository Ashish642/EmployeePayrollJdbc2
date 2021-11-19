package com.bridgelabz;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

public class DBMain {

    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
        String userName = "ashish";
        String password = "1234";
        Connection connection;

        // checking the driver is loaded or not
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver is loaded!");

        }catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver in the Classpath!", e);

        }
        listDriver();
        // establishing connection
        try {
            System.out.println("Connection to database :" +jdbcURL);
            connection = DriverManager.getConnection(jdbcURL,userName,password);
            System.out.println("Connection is Successful!!!!" + connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Welcome to JDBC Program");
    }
    /**
     * Purpose : To check all the driver registered with jdbc driver
     */
    private static void listDriver() {
        Enumeration<Driver>driveList = DriverManager.getDrivers();
        while (driveList.hasMoreElements()) {
            Driver driverClass = driveList.nextElement();
            System.out.println(" " + driverClass.getClass().getName());
        }
    }
}
