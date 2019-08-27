import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

class Config {
    static Connection createConection() throws SQLException {
        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "123456");
        final String connectionString = "jdbc:mysql://localhost:3306/minions_db";
        return  DriverManager.getConnection(connectionString, props);
    }
}
