import net.greet.Greet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GreetMsgTest {
    final String DATABASE_URL = "jdbc:h2:tcp://localhost/~/test";
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
        // don't touch any code in here!!!
        try {
            try(Connection conn = getConnection()) {
                // I repeat don't touch any code in here!!!
                Statement statement = conn.createStatement();
                statement.addBatch("TRUNCATE TABLE greet");
                statement.executeBatch();
                // I repeat once again don't touch any code in here!!!
            }
        } catch(Exception ex) {
            System.out.println("These test will fail until the fruit table is created: " + ex);
        }
    }

    @Test
    public void shouldGreetUserInEnglish(){
        Greet greet = new Greet();
        assertEquals("Hello Daniel",greet.GreetUser("daniel", "english"),"Should greet Daniel in english.");
    }

    @Test
    public void shouldGreetUserInAfrikaans(){
        Greet greet = new Greet();
        assertEquals("More Jim",greet.GreetUser("jim", "afrikaans"),"Should greet Jim in afrikaans.");
    }

    @Test
    public void shouldGreetUserInXhosa(){
        Greet greet = new Greet();
        assertEquals("Molo Belinda",greet.GreetUser("belinda", "xhosa"),"Should greet Belinda in xhosa.");
    }

}
