package com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteEmployee {

    public static void main(String[] args) {

        String sql = """
                DELETE FROM employees
                WHERE employee_id = ?
                """;

        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, 2);  // employee_id = 2

            int rows = ps.executeUpdate();

            System.out.println(rows + " employee deleted.");

            ps.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}