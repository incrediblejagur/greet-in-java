package net.commands;
import net.greet.Greet;
import net.language.Language;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Commands extends Extractor{

    public static void home() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter command or type 'help'.");
        System.out.print("> ");
        String command = myObj.nextLine();
        String commandSplit = command.split(" ")[0];
        // Available Commands
        if(command.equals("help")) help();
        if(commandSplit.equals("greet")) greetPerson(command);
        if(commandSplit.equals("greeted")) greeted(command);
        if(commandSplit.equals("clear")) clear(command);
        if(command.equals("counter")) System.out.println(new Greet().totalUniqueUsersGreeted());
        if(command.equals("exit")) return;
        home();
    }

    public static void help(){
        List<String> lang=new ArrayList<String>();
        for (Language b : Language.values()) {
            lang.add(b.name());
        }
        System.out.println(
                "=============================================================================\n"+
                        "- 'greet' followed by the name and the language the user is to be greeted in\n" +
                        "- 'greeted' should display a list of all users that has been greeted and how many time each user has been greeted\n" +
                        "- 'greeted' followed by a username returns how many times that username have been greeted\n" +
                        "- 'counter' returns a count of how many unique users has been greeted\n" +
                        "- 'clear' deletes of all users greeted and the reset the greet counter to 0\n" +
                        "- 'clear' followed by a username deletes the specified user and decrement the greet counter by 1\n" +
                        "- 'exit' exits the application\n" +
                        "- 'help' shows a user an overview of all possible commands\n"+
                        "-  supported languages are as follows: "+lang+"\n"+
                        "=============================================================================\n"
        );
    }


}
