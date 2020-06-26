package net.language;


    public enum Language {
        English("Hello"),
        Afrikaans("More"),
        Xhosa("Molo"),
        Frensh("Bonjour"),
        Russian("Zdravstvuyte"),
        Tanzania("Hujambo"),
        German("Guten Tag"),
        Spanish("Hola");

        public String lang;
        public static String defaultLang = "Hello";
        Language(String lang) {
            this.lang = lang;
        }

        public static String getExpression(String text) {
            for (Language b : Language.values()) {
                if (b.name().equalsIgnoreCase(text)) {
                    return b.lang+" ";
                }
            }
            return defaultLang+" ";
        }

    }