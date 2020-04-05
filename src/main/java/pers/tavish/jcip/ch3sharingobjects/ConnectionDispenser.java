package pers.tavish.jcip.ch3sharingobjects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// 程序清单3-10
public class ConnectionDispenser {

    private static String DB_URL = "jdbc:mysql://localhost:3306/test?user=root&password=mysql";

    private static ThreadLocal<Connection> connectionHolder = ThreadLocal.withInitial(() -> {
        try {
            return DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            throw new RuntimeException("Unable to acquire Connection, e");
        }
    });

    public static Connection getConnection() {
        return connectionHolder.get();
    }
}
