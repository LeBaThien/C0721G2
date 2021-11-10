package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSQL {
    private String jdbcURL = "jdbc:mysql://localhost:3306/web_database_management?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "12345678";
    private static Connection connection;

    public ConnectionSQL() {

    }

    public Connection getConnection() {
        connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    public static void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
