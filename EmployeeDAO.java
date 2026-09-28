
package com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    // INSERT EMPLOYEE
    public static void insertEmployee(
            String employeeName,
            String email,
            double salary,
            String department,
            String joiningDate) {

        String sql = """
                INSERT INTO employees
                (employee_name, email, salary, department, joining_date)
                VALUES (?, ?, ?, ?, ?)
                """;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, employeeName);
            ps.setString(2, email);
            ps.setDouble(3, salary);
            ps.setString(4, department);
            ps.setString(5, joiningDate);

            int rows = ps.executeUpdate();

            System.out.println(rows + " employee inserted.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // UPDATE EMPLOYEE SALARY
    public static void updateSalary(double salary, int employeeId) {

        String sql = """
                UPDATE employees
                SET salary = ?
                WHERE employee_id = ?
                """;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setDouble(1, salary);
            ps.setInt(2, employeeId);

            int rows = ps.executeUpdate();

            System.out.println(rows + " employee updated.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // DELETE EMPLOYEE
    public static void deleteEmployee(int employeeId) {

        String sql = """
                DELETE FROM employees
                WHERE employee_id = ?
                """;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, employeeId);

            int rows = ps.executeUpdate();

            System.out.println(rows + " employee deleted.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // SELECT ALL EMPLOYEES
    public static List<String> getAllEmployees() {

        String sql = """
                SELECT employee_id,
                       employee_name,
                       email,
                       salary,
                       department,
                       joining_date
                FROM employees
                """;

        List<String> employees = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                int employeeId = rs.getInt("employee_id");
                String employeeName = rs.getString("employee_name");
                String email = rs.getString("email");
                double salary = rs.getDouble("salary");
                String department = rs.getString("department");
                String joiningDate = rs.getString("joining_date");

                String employee = employeeId + " | "
                        + employeeName + " | "
                        + email + " | "
                        + salary + " | "
                        + department + " | "
                        + joiningDate;

                employees.add(employee);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return employees;
    }


    // MAIN METHOD
    public static void main(String[] args) {

        // INSERT
        insertEmployee(
                "Ravi",
                "ravi@gmail.com",
                45000,
                "IT",
                "2026-09-28"
        );


        // UPDATE
        updateSalary(50000, 1);


        // DELETE
        deleteEmployee(2);


        // SELECT
        List<String> employees = getAllEmployees();

        System.out.println("\nEmployee List:");

        for (String employee : employees) {
            System.out.println(employee);
        }
    }
}