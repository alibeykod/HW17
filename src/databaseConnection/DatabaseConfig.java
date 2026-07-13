package databaseConnection;

import exceptions.DatabaseConnectionException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    private static final String url = "jdbc:postgresql://localhost:5432/event_ticket_reservation_system_introduction";
    private static final String username = "postgres";
    private static final String password = "20001379";

    public static Connection getConnection(){
        try {
           return DriverManager.getConnection(url , username , password);
        } catch (SQLException e) {
            throw new DatabaseConnectionException("fall out connection");
        }
    }

}
