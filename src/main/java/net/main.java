package net;

import net.greet.Greet;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        System.out.println("Greet-In-Java");
        System.out.println("=============");
        home();
    }

    public static void home(){
        Greet greet = new Greet();
        System.out.println("Enter command or type 'help'.");
        Scanner myObj = new Scanner(System.in);
        System.out.print("> ");
        String command = myObj.nextLine();
        if(command.equals("help"))help();
        if(command.equals(("greet"))) runGreeting();
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

    public static void runGreeting() {
        Scanner myObj = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = myObj.nextLine();

        System.out.print("Enter language: ");
        String language = myObj.nextLine();

        Greet greet = new Greet();
        System.out.println(greet.GreetUser(name.trim(), language.trim()));

        System.out.print("Run again? y/n ");
        String answer = myObj.nextLine();
        if(answer.trim().toLowerCase().equals(("y"))) runGreeting();
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
