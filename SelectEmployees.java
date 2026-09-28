package com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectEmployees {

    public static void main(String[] args) {

        String sql = "SELECT * FROM employees";

        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                System.out.println(
                    resultSet.getInt("employee_id") + " | " +
                    resultSet.getString("employee_name") + " | " +
                    resultSet.getString("email") + " | " +
                    resultSet.getDouble("salary") + " | " +
                    resultSet.getString("department") + " | " +
                    resultSet.getDate("joining_date")
                );
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
