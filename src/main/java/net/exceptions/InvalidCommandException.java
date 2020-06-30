package net.exceptions;

import net.misc.color;

public class InvalidCommandException extends GreetException {

    private final String message;

    public InvalidCommandException() {
        this.message = color.ANSI_RED+"You entered an invalid command."+color.ANSI_RESET;
    }

    public String getMessage(){
        return message;
    }

}
