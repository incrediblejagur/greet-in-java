package net.commands;
import net.exceptions.GreetException;
import net.exceptions.InvalidCommandException;
import net.misc.color;
import net.language.Language;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Commands extends Extractor{

    public void home() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter command or type 'help'.");
        System.out.print("> ");
        String command = myObj.nextLine();
        String commandSplit = command.split(" ")[0];
        // Available Commands
        try {
            if (command.equals("help")) help();
            if (commandSplit.equals("greet")) greetPerson(command);
            if (commandSplit.equals("greeted")) greeted(command);
            if (commandSplit.equals("clear")) clear(command);
            if (command.equals("counter")) counter();
            if (command.equals("exit")) return;
            // Checks if command was run successfully or if its invalid.
            if(super.validCommand == false) throw new InvalidCommandException();
        }catch(GreetException es){
            System.out.println(es.getMessage());
        }finally {
            super.validCommand = false;
            home();
        }

    }

    public void help(){
        super.validCommand = true;
        List<String> lang=new ArrayList<String>();
        for (Language b : Language.values()) {
            lang.add(b.name());
        }
        System.out.println(
                "=============================================================================\n"+
                        color.ANSI_GREEN+"- 'greet'"+color.ANSI_RESET +"followed by the name and the language the user is to be greeted in\n" +
                        color.ANSI_GREEN+"- 'greeted'"+color.ANSI_RESET +"should display a list of all users that has been greeted and how many time each user has been greeted\n" +
                        color.ANSI_GREEN+"- 'greeted'"+color.ANSI_RESET +"followed by a username returns how many times that username have been greeted\n" +
                        color.ANSI_GREEN+"- 'counter'"+color.ANSI_RESET +"returns a count of how many unique users has been greeted\n" +
                        color.ANSI_GREEN+"- 'clear'"+color.ANSI_RESET +"deletes of all users greeted and the reset the greet counter to 0\n" +
                        color.ANSI_GREEN+"- 'clear'"+color.ANSI_RESET +"followed by a username deletes the specified user and decrement the greet counter by 1\n" +
                        color.ANSI_GREEN+"- 'exit'"+color.ANSI_RESET +"exits the application\n" +
                        "-  supported languages are as follows: "+lang+"\n"+
                        "=============================================================================\n"
        );
    }


}
