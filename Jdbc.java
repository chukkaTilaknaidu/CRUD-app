// Import necessary classes and packages
package JavaDataBaseConnectivity.copy;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class Jdbc {

    static { // Static block for class loading
        try {
            // Load the MySQL JDBC driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getJdbcConnection() throws SQLException, IOException {
        // Establishing the database connection using HikariCP
        HikariConfig config = new HikariConfig("C:\\Users\\tilak\\eclipse-workspace\\Tilak\\src\\JavaDataBaseConnectivity\\copy\\db.properties");
        HikariDataSource dataSource = new HikariDataSource(config);
        return dataSource.getConnection();
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        // Call the getJdbcConnection method to test the database connection
        Jdbc.getJdbcConnection();
    }
}
