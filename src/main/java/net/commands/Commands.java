package net.commands;
import net.greet.Greet;
import java.util.Scanner;

public class Commands extends Extractor{

    public static void home() {
        System.out.println("Enter command or type 'help'.");
        Scanner myObj = new Scanner(System.in);
        System.out.print("> ");
        String command = myObj.nextLine();
        if(command.equals("help"))help();
        if(command.split(" ")[0].equals("greet")) greetPerson(command);
        if(command.split(" ")[0].equals("greeted")) greeted(command);
        if(command.split(" ")[0].equals("clear")) clear(command);
        if(command.equals("counter")){
            Greet greet = new Greet();
            System.out.println(greet.totalUniqueUsersGreeted());
        }
        if(command.equals("exit")) return;
        home();
    }

    public static void help(){
        System.out.println(
                "=============================================================================\n"+
                        "- 'greet' followed by the name and the language the user is to be greeted in\n" +
                        "- 'greeted' should display a list of all users that has been greeted and how many time each user has been greeted\n" +
                        "- 'greeted' followed by a username returns how many times that username have been greeted\n" +
                        "- 'counter' returns a count of how many unique users has been greeted\n" +
                        "- 'clear' deletes of all users greeted and the reset the greet counter to 0\n" +
                        "- 'clear' followed by a username delete the greet counter for the specified user and decrement the greet counter by 1\n" +
                        "- 'exit' exits the application\n" +
                        "- 'help' shows a user an overview of all possible commands\n"+
                        "- supported languages are as follows: english, xhosa, afrikaans.\n"+
                        "=============================================================================\n"
        );
    }


}
