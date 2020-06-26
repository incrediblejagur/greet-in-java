package net.commands;
import net.exceptions.GreetException;
import net.exceptions.NoLanguageExeption;
import net.exceptions.NoNameException;
import net.greet.Greet;
import java.util.Scanner;

public class Commands {

    public static void home() {
        Greet greet = new Greet();
        System.out.println("Enter command or type 'help'.");
        Scanner myObj = new Scanner(System.in);
        System.out.print("> ");
        String command = myObj.nextLine();
        if(command.equals("help"))help();
        if(command.split(" ")[0].equals("greet")){
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
        if(command.equals("exit")) return;
        if(command.split(" ")[0].equals("greeted")){
            int greetedCommand = command.split(" ").length;
            if(greetedCommand == 1) {
                System.out.println(greet.getAllNamesGreeted());
            }else{
                String name = command.split(" ")[1];
                System.out.println(greet.getNameCount(name));
            }
        }
        if(command.split(" ")[0].equals("clear")){
            int clearCommand = command.split(" ").length;
            if(clearCommand == 1) {
                System.out.println(greet.deleteAllNames());
            }else{
                String name = command.split(" ")[1];
                System.out.println(greet.deleteName(name));
            }
        }
        if(command.equals("counter"))System.out.println(greet.totalUniqueUsersGreeted());
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
