import net.exceptions.GreetException;
import net.greet.Greet;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class GreetMsgTest extends DbConnection{

    @Test
    public void shouldGreetUserInEnglish() throws GreetException {
        Greet greet = new Greet();
        assertEquals("Hello Daniel",greet.GreetUser("daniel", "english"),"Should greet Daniel in english.");
    }

    @Test
    public void shouldGreetUserInAfrikaans() throws GreetException {
        Greet greet = new Greet();
        assertEquals("More Jim",greet.GreetUser("jim", "afrikaans"),"Should greet Jim in afrikaans.");
    }

    @Test
    public void shouldGreetUserInXhosa() throws GreetException {
        Greet greet = new Greet();
        assertEquals("Molo Belinda",greet.GreetUser("belinda", "xhosa"),"Should greet Belinda in xhosa.");
    }

    @Test
    public void shouldGreetUserInDefaultLanguage() throws GreetException {
        //if user doesn't enter language should greet user in english by default
        Greet greet = new Greet();
        assertEquals("Hello Belinda",greet.GreetUser("belinda", ""),"Should greet Belinda in english.");
    }

}
