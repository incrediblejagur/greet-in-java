package net.commands;
import net.exceptions.*;
import net.greet.Greet;
import net.misc.color;

public abstract class Extractor {
    public Boolean validCommand = false;
    Greet greet = new Greet();

    public void greetPerson(String command){
        String name = "";
        String lang = "";
        this.validCommand = true;
        try {
            int greetCommandLength = command.split(" ").length;
            if(greetCommandLength == 1) throw new NoNameException();
            name = command.split(" ")[1];
            if (greetCommandLength == 3) lang = command.split(" ")[2];
            System.out.println(color.ANSI_YELLOW+greet.GreetUser(name, lang)+color.ANSI_RESET);
            if(greetCommandLength == 2) throw new NoLanguageExeption();
        }catch (GreetException es){
            System.out.println(es.getMessage());
        }
    }

    public void greeted(String command){
        this.validCommand = true;
        int greetedCommand = command.split(" ").length;
        if(greetedCommand == 1) {
            System.out.println(greet.getAllNamesGreeted());
        }else{
            String name = command.split(" ")[1];
            System.out.println(greet.getNameCount(name));
        }
    }

    public void clear(String command){
        this.validCommand = true;
        int clearCommand = command.split(" ").length;
        if(clearCommand == 1) {
            System.out.println(greet.deleteAllNames());
        }else{
            String name = command.split(" ")[1];
            System.out.println(greet.deleteName(name));
        }
    }

    public void counter(){
        validCommand = true;
        System.out.println(greet.totalUniqueUsersGreeted());
    }
}

