package com.example;
import java.sql.*;

public class DatabaseUtil {
    private static Connection connection;
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/plautus_applications";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "Psalm46:5pass";

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
