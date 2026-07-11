package com.aeropelican;

import com.aeropelican.database.SqlConnection;
import com.aeropelican.model.Employee;
import com.aeropelican.repository.EmployeeRepository;

import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Creating database connection..");
        SqlConnection sqlConnection = new SqlConnection();
        Connection connection = (Connection) sqlConnection.getConnection();
        EmployeeRepository repository = new EmployeeRepository(connection);
        Employee emp = new Employee(122, "Rahul", "Developer", 65000, "Hyderabad");
        repository.insertEmployee(emp);
        List<Employee> result =repository.getEmployees();
        for(Employee employee:result){
            System.out.println(employee);
        }
        Employee employee = repository.getEmployee(115);
        if (employee != null) {
            System.out.println("Employee found.. "+employee);
        } else {
            System.out.println("Employee not found.. ");
        }
     Employee employe = new Employee(115, "Ramesh", "Senior Developer", 85000, "IT");
     repository.updateEmployee(employe);
     repository.deleteEmployee(120);
    }
}