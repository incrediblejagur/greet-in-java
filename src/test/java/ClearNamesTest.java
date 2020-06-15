import net.greet.Greet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClearNamesTest {
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
            System.out.println("These test will fail until the fruit table is created: " + ex);
        }
    }

    @Test
    public void shouldClearName(){
        Greet greet = new Greet();
        assertEquals("Jim:1",greet.getNameCount("Jim"));
        greet.deleteName("jim");
        assertEquals( "Name not found.", greet.getNameCount("Jim"),"Should return not found, as jim was deleted.");
    }

    @Test
    public void shouldClearName1(){
        Greet greet = new Greet();
        assertEquals("Andre:3",greet.getNameCount("andre"));
        greet.deleteName("andre");
        assertEquals( "Name not found.", greet.getNameCount("Andre"),"Should return not found, as andre was deleted.");
    }

    @Test
    public void shouldClearAllNames(){
        Greet greet = new Greet();
        assertEquals(  "All names deleted.", greet.deleteAllNames(),"Should clear all names from db.");
        assertEquals(  0, greet.totalUniqueUsersGreeted(),"Should return 0 as all names were deleted.");

    }
}
