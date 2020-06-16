package net.greet;

public class Language {
    String greeting  = "";

    public Language(String language){
        String lang = language.toLowerCase();
    if(lang.equals("english")) {
        greeting = "Hello ";
    }else if(lang.equals("afrikaans")){
            greeting = "More ";
    }else if(lang.equals("xhosa")){
            greeting = "Molo ";
    }else {
            greeting = "Hello ";
    }
    }


    public String getGreeting(){
        return greeting;
    }

}
