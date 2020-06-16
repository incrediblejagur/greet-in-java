import net.greet.Greet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TotalNamesAddedTest extends DbConnection{
    /// Testing 'counter' command
    @Test
    public void shouldReturnTotalNamesAdd(){
        Greet greet = new Greet();
        assertEquals(6, greet.totalUniqueUsersGreeted(),"Should return total unique names greeted.");
    }
    @Test
    public void shouldReturnTotalNamesAdd1(){
        Greet greet = new Greet();
        assertEquals(6, greet.totalUniqueUsersGreeted(),"Should return total unique names greeted.");
        greet.GreetUser("peter","afrikaans");
        assertEquals(7, greet.totalUniqueUsersGreeted(),"Should return updated total unique names greeted.");
    }
    @Test
    public void shouldReturnTotalNamesAdd2(){
        Greet greet = new Greet();
        greet.GreetUser("peter","afrikaans");
        greet.deleteName("peter");
        assertEquals(6, greet.totalUniqueUsersGreeted(),"Should return total unique names greeted after one is deleted.");
    }

}
