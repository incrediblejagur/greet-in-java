package net.greet;
import net.exceptions.GreetException;
import net.exceptions.NoNameException;
import net.language.Language;

public class Greet extends GreetQueries{

    String greeting = "";
    public String GreetUser(String name, String lang) throws GreetException {
            name = name.substring(0, 1).toUpperCase() + name.substring(1); // standardization
            name = name.replaceAll("\\s+", "");
            if(name == "") throw new NoNameException();
                  String greetExpression = Language.getExpression(lang);
                  addNameToDB(name);
                    this.greeting = greetExpression + name;


        return greeting;
    } //greet




}
