package net.exceptions;

public class GreetException extends Exception {
    private String message = "";
    public GreetException(){
        this.message = "Something is wrong.";
    }

    @Override
    public String getMessage(){
        return message;
    }

}



