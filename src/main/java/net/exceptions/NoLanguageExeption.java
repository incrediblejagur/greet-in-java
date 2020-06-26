package net.exceptions;

public class NoLanguageExeption extends GreetException {
    private final String message;

    public NoLanguageExeption() {
        this.message = "You didn't enter a language, so the default method is 'english'";
    }

    public String getMessage(){
        return message;
    }

}

