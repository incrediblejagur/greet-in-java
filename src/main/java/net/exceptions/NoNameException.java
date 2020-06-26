package net.exceptions;

public class NoNameException extends GreetException {
    private final String message;

    public NoNameException() {
        this.message = "Enter name after 'greet'";
    }

    public String getMessage(){
        return message;
    }

}

