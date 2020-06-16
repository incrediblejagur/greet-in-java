import net.greet.Greet;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClearNamesTest extends DbConnection {
    /// Testing 'greeted' command

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
    public void shouldClearName2(){
        Greet greet = new Greet();
        greet.GreetUser("daniel","english");
        assertEquals("Andre:3",greet.getNameCount("andre"));
        greet.deleteName("andre");
        greet.deleteName("daniel");
        assertEquals( "Name not found.", greet.getNameCount("Andre"),"Should return not found, as andre was deleted.");
        assertEquals( "Name not found.", greet.getNameCount("daniel"),"Should return not found, as daniel was deleted.");
    }

    @Test
    public void shouldClearAllNames(){
        Greet greet = new Greet();
        assertEquals(  "All names deleted.", greet.deleteAllNames(),"Should clear all names from db.");
        assertEquals(  0, greet.totalUniqueUsersGreeted(),"Should return 0 as all names were deleted.");

    }

    @Test
    public void shouldClearAllNames1(){
        Greet greet = new Greet();
        greet.GreetUser("daniel","english");
        greet.GreetUser("peter","english");
        greet.GreetUser("john","english");
        assertEquals(  "All names deleted.", greet.deleteAllNames(),"Should clear all names from db.");
        assertEquals(  0, greet.totalUniqueUsersGreeted(),"Should return 0 as all names were deleted.");

    }
}
