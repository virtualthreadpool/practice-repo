package com.aeropelican.model;

public class Employee {
    private int empId;
    private  String empName;
    private  String designation;
    private double salary;
    private  String location;

    public Employee(int empId, String empName, String designation, double salary, String location) {
        this.empId = empId;
        this.empName = empName;
        this.designation = designation;
        this.salary = salary;
        this.location = location;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", designation='" + designation + '\'' +
                ", salary=" + salary +
                ", location='" + location + '\'' +
                '}';
    }
}
