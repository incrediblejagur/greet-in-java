import net.greet.Greet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetNameCountTest extends DbConnection{
    /// Testing " greet 'name' " command
    @Test
    public void getNameCount0(){
        Greet greet = new Greet();
        assertEquals("Jim:1", greet.getNameCount("jim"),"Should return Jim with a count of 1.");
    }
    @Test
    public void getNameCount1(){
        Greet greet = new Greet();
        assertEquals("Jason:2", greet.getNameCount("jason"),"Should return Jason with a count of 2.");
    }
    @Test
    public void getNameCount2(){
        Greet greet = new Greet();
        assertEquals("Andre:3", greet.getNameCount("andre"),"Should return Andre with a count of 1.");
        greet.deleteName("andre");
        assertEquals("Name not found.", greet.getNameCount("andre"),"Should return 'Name not found.' As andre was deleted.");
    }

    @Test
    public void getNameCount3(){
        Greet greet = new Greet();
        assertEquals("Andre:3", greet.getNameCount("andre"),"Should return Andre with a count of 3.");
        greet.GreetUser("andre","afrikaans");
        assertEquals("Name not found.", greet.getNameCount("steve"),"Should return 'Name not found.' As steve was never added.");
        assertEquals("Andre:4", greet.getNameCount("andre"),"Should return Andre with a count of 4 as he was added again.");
    }


}
