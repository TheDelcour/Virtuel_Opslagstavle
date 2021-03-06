package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/";
    static final String DB_NAME = "opslagstavle";

    // Database credentials
    static final String DB_USER = "root";

    static Connection conn = null;

    public static Connection getConnection() {
        try {
            // Load password
            String DB_PASSWORD = "PASSWORD";

            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL + DB_NAME + "?serverTimezone=UTC", DB_USER, DB_PASSWORD);
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to database", e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Error class not found", e);
        }
    }

    public static void closeConnection() throws SQLException {
        // Close connection
        if (conn != null)
            conn.close();
    }
}