package greet;
import java.sql.*;

public class Greet {
     String name = "";
     String greeting = "";
    public Greet(String name, String lang){
        name = name.substring(0, 1).toUpperCase() + name.substring(1); // capitalizing of first letter
        this.name = name;
        Language language = new Language(lang);
        this.greeting = language.getGreeting() + name;
    }

    public String message(){
        return greeting;
    }

}
