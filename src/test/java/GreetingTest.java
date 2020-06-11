import greet.Greet;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class GreetingTest {

    @Test
    public void shouldGreetUserInEnglish(){
        Greet greet = new Greet("daniel", "english");
        assertEquals("Hello Daniel",greet.message(),"Should greet Daniel in english.");
        System.out.println(greet.message());
    }

    @Test
    public void shouldGreetUserInAfrikaans(){
        Greet greet = new Greet("jim", "afrikaans");
        assertEquals("More Jim",greet.message(),"Should greet Jim in afrikaans.");
        System.out.println(greet.message());
    }

    @Test
    public void shouldGreetUserInXhosa(){
        Greet greet = new Greet("belinda", "xhosa");
        assertEquals("Molo Belinda",greet.message(),"Should greet Belinda in xhosa.");
        System.out.println(greet.message());
    }

}
