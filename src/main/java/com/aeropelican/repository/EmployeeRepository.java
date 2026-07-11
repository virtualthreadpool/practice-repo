package com.aeropelican.repository;
import com.aeropelican.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    private Connection databaseConnection;

    public EmployeeRepository(Connection connection) {
        databaseConnection = connection;
    }

    //Method to create or insert employee record
    public void insertEmployee(Employee employee) {
        try {
            String sqlStatement = "INSERT INTO employee( employee_id,employee_name,designation, salary,location)values(?,?,?,?,?)";
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(sqlStatement);
            preparedStatement.setInt(1, employee.getEmpId());
            preparedStatement.setString(2, employee.getEmpName());
            preparedStatement.setString(3, employee.getDesignation());
            preparedStatement.setDouble(4, employee.getSalary());
            preparedStatement.setString(5, employee.getLocation());
            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println("Employee inserted successfully..");
            } else {
                System.out.println("Employee insertion failed..");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        // Method to display list of all employees..
        public List<Employee> getEmployees() {
            List<Employee> employeeList = new ArrayList<>();
            String sqlStatement = "select * from employee";
            try {
                Statement statement = databaseConnection.createStatement();
                ResultSet resultSet = statement.executeQuery(sqlStatement);
                while (resultSet.next()) {
                    Employee employee = new Employee(
                            resultSet.getInt("employee_id"),
                            resultSet.getString("employee_name"),
                            resultSet.getString("designation"),
                            resultSet.getDouble("salary"),
                            resultSet.getString("location"));
                    employeeList.add(employee);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return employeeList;
        }

        // Method to display one employee record
        public Employee getEmployee( int employeeId){
            String sqlStatement = "select * from employee where employee_id =?";
            Employee employee = null;
            try {
                PreparedStatement preparedStatement = databaseConnection.prepareStatement(sqlStatement);
                preparedStatement.setInt(1, employeeId);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    employee = new Employee(resultSet.getInt("employee_id"),
                            resultSet.getString("employee_name"),
                            resultSet.getString("designation"),
                            resultSet.getDouble("salary"),
                            resultSet.getString("location"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return employee;
        }
//Method to update employee record..
        public void updateEmployee(Employee employee){
            try {
                String sqlStatement = "UPDATE employee SET employee_name = ?,designation = ? , salary = ?,location = ? WHERE employee_Id = ?";
                PreparedStatement preparedStatement = databaseConnection.prepareStatement(sqlStatement);
                preparedStatement.setString(1, employee.getEmpName());
                preparedStatement.setString(2, employee.getDesignation());
                preparedStatement.setDouble(3, employee.getSalary());
                preparedStatement.setString(4, employee.getLocation());
                preparedStatement.setInt(5, employee.getEmpId());
                int rows = preparedStatement.executeUpdate();
                if (rows > 0) {
                    System.out.println("Employee updated successfully..");
                } else {
                    System.out.println("Employee updation failed..");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        //Method to delete an employee record
        public  void deleteEmployee(int employeeId){
            String sql = "delete from employee where employee_id= ?";
            try {
                PreparedStatement preparedStatement = databaseConnection.prepareStatement(sql);
                preparedStatement.setInt(1, employeeId);
                int rows = preparedStatement.executeUpdate();
                if (rows > 0) {
                    System.out.println("Employee deleted successfully..");
                } else {
                    System.out.println("Employee deletion failed..");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
