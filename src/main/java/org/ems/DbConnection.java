package org.ems;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    public Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ems";// H2 Database URL
        String user = "admin";            // Database username
        String password = "admin";          // Database password

        return DriverManager.getConnection(url, user, password);
    }
}
