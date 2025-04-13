import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() throws SQLException {
        try {
            // Register MySQL driver (optional for newer versions of JDBC)
            Class.forName("com.mysql.cj.jdbc.Driver");  // For MySQL 8.0 and above

            // Connection string: jdbc:mysql://[host]:[port]/[database]
            String url = "jdbc:mysql://localhost:3306/currencydb";
            String username = "root";  // Replace with your DB username
            String password = "";  // Replace with your DB password

            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL Driver not found", e);
        }
    }
}
