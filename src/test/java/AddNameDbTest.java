import net.exceptions.GreetException;
import net.greet.Greet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddNameDbTest extends DbConnection {
    /// Testing 'greeted' command
    @Override @BeforeEach
    public void cleanUpTables() {
        try {
            try(Connection conn = getConnection()) {
                Statement statement = conn.createStatement();
                statement.addBatch("TRUNCATE TABLE greet");
                statement.executeBatch();
            }
        } catch(Exception ex) {
            System.out.println("These test will fail until the greet table is created: " + ex);
        }
    }

    @Test
    public void shouldAddNameToDB0() throws GreetException {
        Greet greet = new Greet();
        greet.GreetUser("jim", "afrikaans");
        ArrayList<String> names = new ArrayList<String>();
        names.add("Jim:1");
        assertEquals(names, greet.getAllNamesGreeted(),"Should return Jim with a count of 1.");
    }

    @Test
    public void shouldAddNameToDB1() throws GreetException {
        Greet greet = new Greet();
        greet.GreetUser("dan", "afrikaans");
        greet.GreetUser("dan", "english");
        ArrayList<String> names = new ArrayList<String>();
        names.add("Dan:2");
        assertEquals(names, greet.getAllNamesGreeted(),"Should return Dan with a count of 2.");
    }

    @Test
    public void shouldAddNameToDB2() throws GreetException {
        Greet greet = new Greet();
        greet.GreetUser("andre", "afrikaans");
        greet.GreetUser("andre", "xhosa");
        greet.GreetUser("dan", "english");
        ArrayList<String> names = new ArrayList<String>();
        names.add("Andre:2");
        names.add("Dan:1");
        assertEquals(names, greet.getAllNamesGreeted(),"Should return Andre with a count of 3.");
    }

    @Test
    public void shouldAddNameToDB3() throws GreetException {
        Greet greet = new Greet();
        greet.GreetUser("andre", "afrikaans");
        greet.GreetUser("jason", "english");
        greet.GreetUser("andre", "english");
        greet.GreetUser("dan", "english");
        ArrayList<String> names = new ArrayList<String>();
        names.add("Andre:2");
        names.add("Jason:1");
        names.add("Dan:1");
        assertEquals(names, greet.getAllNamesGreeted(),"Should return Andre with a count of 3.");
        assertEquals(3, greet.totalUniqueUsersGreeted(),"Should return total of 3.");
    }

}
