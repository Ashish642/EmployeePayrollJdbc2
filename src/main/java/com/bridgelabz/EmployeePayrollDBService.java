package com.bridgelabz;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollDBService {
    /* To read employees payroll from database using JDBC */
    public List<EmployeePayrollData> readData() {
        String sql = "SELECT * FROM  employee_payroll";
        List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
        try (Connection connection = this.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString(name);
                double salary = resultSet.getDouble("salary");
                LocalDate startDate = resultSet.getDate("start_date").toLocalDate();
                employeePayrollList.add(new EmployeePayrollData(id, name, salary, startDate));

            }


        }catch (SQLException e) {
            e.printStackTrace();
        }
        return employeePayrollList;
    }
    /* Creating connection with database */
    private Connection getConnection() throws SQLException {
        String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
        String userName = "root";
        String password = "pintu@2202";
        Connection connection;
        System.out.println("Connection to databases:" + jdbcURL);
        connection = DriverManager.getConnection(jdbcURL,userName,password);
        System.out.println("Connection is successful!!!!" + connection);
        return connection;
    }
}
