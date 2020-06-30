package net;

import net.commands.Commands;
import net.misc.color;

public class main {

    public static void main(String[] args) {
        System.out.println(color.ANSI_GREEN+"Greet-In-Java"+color.ANSI_RESET);
        System.out.println("=============");
        Commands commands = new Commands();
        commands.home();
    }


}
