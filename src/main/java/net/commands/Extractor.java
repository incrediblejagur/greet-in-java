package net.commands;
import net.exceptions.*;
import net.greet.Greet;

public abstract class Extractor {

    public static void greetPerson(String command){
        Greet greet = new Greet();
        String name = "";
        String lang = "";
        try {
            int greetCommandLength = command.split(" ").length;
            if(greetCommandLength == 1) throw new NoNameException();
            name = command.split(" ")[1];
            if (greetCommandLength == 3) lang = command.split(" ")[2];
            System.out.println(greet.GreetUser(name, lang));
            if(greetCommandLength == 2) throw new NoLanguageExeption();
        }catch (GreetException es){
            System.out.println(es.getMessage());
        }
    }

    public static void greeted(String command){
        Greet greet = new Greet();
        int greetedCommand = command.split(" ").length;
        if(greetedCommand == 1) {
            System.out.println(greet.getAllNamesGreeted());
        }else{
            String name = command.split(" ")[1];
            System.out.println(greet.getNameCount(name));
        }
    }

    public static void clear(String command){
        Greet greet = new Greet();
        int clearCommand = command.split(" ").length;
        if(clearCommand == 1) {
            System.out.println(greet.deleteAllNames());
        }else{
            String name = command.split(" ")[1];
            System.out.println(greet.deleteName(name));
        }
    }

}

