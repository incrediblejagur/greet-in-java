import net.greet.Greet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddNameDbTest {
    /// Testing 'greeted' command
    final String DATABASE_URL = "jdbc:h2:~/test";
    public Connection getConnection() throws Exception {
        // TODO - add a username of "sa" and a blank password ""
        // TODO - if the db is created via default flyway config the username will be "sa" with a blank password
        // you can change this by removing the user element containing sa in the pom.xml file
        // if not be sure to delete the *.db files in your target folder before running mvn flyway:migrate the first time
        // and be sure the set the username to "sa" password blank ""
        // if your remove the user element from the pom.xml file you are use a username of "" and a password of ""
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
            }
        } catch(Exception ex) {
            System.out.println("These test will fail until the fruit table is created: " + ex);
        }
    }

    @Test
    public void shouldAddNameToDB0(){
        Greet greet = new Greet();
        greet.GreetUser("jim", "afrikaans");
        ArrayList<String> names = new ArrayList<String>();
        names.add("Jim:1");
        assertEquals(names, greet.getAllNamesGreeted(),"Should return Jim with a count of 1.");
    }

    @Test
    public void shouldAddNameToDB1(){
        Greet greet = new Greet();
        greet.GreetUser("dan", "afrikaans");
        greet.GreetUser("dan", "english");
        ArrayList<String> names = new ArrayList<String>();
        names.add("Dan:2");
        assertEquals(names, greet.getAllNamesGreeted(),"Should return Dan with a count of 2.");
    }

    @Test
    public void shouldAddNameToDB2(){
        Greet greet = new Greet();
        greet.GreetUser("andre", "afrikaans");
        greet.GreetUser("andre", "xhosa");
        greet.GreetUser("andre", "english");
        ArrayList<String> names = new ArrayList<String>();
        names.add("Andre:3");
        assertEquals(names, greet.getAllNamesGreeted(),"Should return Andre with a count of 3.");
    }

}
