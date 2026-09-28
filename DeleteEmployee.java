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
            ps.setDouble(1, 75000);
            ps.setInt(1 , 2);


            int rows = ps.executeUpdate();

            System.out.println(rows + " employee updated.");

            ps.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}