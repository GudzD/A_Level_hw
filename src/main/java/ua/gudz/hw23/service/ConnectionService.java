package ua.gudz.hw23.service;


import lombok.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Data
public class ConnectionService {
    private final static String URL = "jdbc:postgresql://localhost:5432/MyData";
    private final static String USER = "postgres";
    private final static String PASSWORD = "gudz";
    Connection connection = null;

    public Connection getDBConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
