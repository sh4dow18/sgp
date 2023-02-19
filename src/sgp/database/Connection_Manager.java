package sgp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection_Manager {
    private Connection connection;
    
    public Connection_Manager(){
        connection = null;
    }
    
    public Connection get_connection() {
        if (connection == null) {
            try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sgp", "root", "");
            } 
            catch (SQLException e) {
                System.err.println(e);
            }
        }
        return connection;
    }
    public void close() {
        try {
            connection.close();
        } catch (SQLException exc) {
            System.err.println(exc);
        } finally {
            connection = null;
        }
    }
    public boolean is_on() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sgp", "root", "");
                close();
            }
            catch (SQLException e) {
                return false;
            }
        }
        return true;
    }
}
