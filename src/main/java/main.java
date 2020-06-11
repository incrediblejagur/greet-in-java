import greet.Greet;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {

    runGreeting();

    }

    public static void runGreeting() {
        Scanner myObj = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = myObj.nextLine();

        System.out.print("Enter language: ");
        String language = myObj.nextLine();

        Greet greet = new Greet(name.trim(), language.trim());
        System.out.println(greet.message());

        System.out.print("Run again? y/n ");
        String answer = myObj.nextLine();
        if(answer.trim().toLowerCase().equals(("y"))){
            runGreeting();
        }
    }

}
