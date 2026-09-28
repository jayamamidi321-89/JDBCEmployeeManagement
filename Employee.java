package com.jdbc;

import java.sql.Date;

public class Employee {

    private int employeeId;
    private String employeeName;
    private String email;
    private double salary;
    private String department;
    private Date joiningDate;

    public Employee() {
    }

    public Employee(String employeeName,
                    String email,
                    double salary,
                    String department,
                    Date joiningDate) {

        this.employeeName = employeeName;
        this.email = email;
        this.salary = salary;
        this.department = department;
        this.joiningDate = joiningDate;
    }

    public Employee(int employeeId,
                    String employeeName,
                    String email,
                    double salary,
                    String department,
                    Date joiningDate) {

        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.email = email;
        this.salary = salary;
        this.department = department;
        this.joiningDate = joiningDate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    @Override
    public String toString() {

        return employeeId + " | "
                + employeeName + " | "
                + email + " | "
                + salary + " | "
                + department + " | "
                + joiningDate;
    }
}