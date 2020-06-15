package net.greet;

public class Language {
    String greeting  = "";

    public Language(String language){
        String lang = language.toLowerCase();
    if(lang.equals("english")){
        English();
    }
        if(lang.equals("afrikaans")){
            Afrikaans();
        }
        if(lang.equals("xhosa")){
            Xhosa();
        }
    }

    public void English(){
        this.greeting = "Hello ";
    }

    public void Afrikaans(){
        this.greeting = "More ";
    }

    public void Xhosa(){
        this.greeting = "Molo ";
    }

    public String getGreeting(){
        return greeting;
    }

}
