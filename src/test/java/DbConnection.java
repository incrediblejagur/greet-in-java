import net.greet.Greet;
import org.junit.jupiter.api.BeforeEach;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DbConnection {

    final String DATABASE_URL = "jdbc:h2:~/test";

    public Connection getConnection() throws Exception {
        Connection conn = DriverManager.getConnection(DATABASE_URL, "sa", "");
        return conn;
    }

    @BeforeEach
    public void cleanUpTables() {
        try {
            try(Connection conn = getConnection()) {
                Statement statement = conn.createStatement();
                statement.addBatch("TRUNCATE TABLE greet");
                statement.executeBatch();
                // populate db
                Greet greet = new Greet();
                greet.GreetUser("jim", "afrikaans");
                greet.GreetUser("dan", "afrikaans");
                greet.GreetUser("andre", "afrikaans");
                greet.GreetUser("ben", "afrikaans");
                greet.GreetUser("andre", "afrikaans");
                greet.GreetUser("jason", "afrikaans");
                greet.GreetUser("andre", "afrikaans");
                greet.GreetUser("thabang", "afrikaans");
                greet.GreetUser("jason", "afrikaans");
            }
        } catch(Exception ex) {
            System.out.println("These test will fail until the greet table is created: " + ex);
        }
    } //populate database

}
