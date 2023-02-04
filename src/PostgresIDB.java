import java.sql.*;
public class PostgresIDB implements IDB {
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionUrl = "jdbc:postgresql://localhost:5432/class";
        try {
            // Here we load the driver’s class file into memory at the runtime
            Class.forName("org.postgresql.Driver");

            // Establish the connection
            Connection con = DriverManager.getConnection(connectionUrl, "postgres", "1414");

            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}



