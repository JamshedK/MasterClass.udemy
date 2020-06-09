package masterclass.udemy;

import java.util.HashMap;
import java.util.Map;

public class MapClass {
    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<>();
        // to input the keys and values to the HashMap
        languages.put("Java", "A complied high level, object orientated, platform independent");
        languages.put("Python", "Interpreted, Object orientated, high level programming language with dynamic semantics");
        languages.put("Algol", "An algorithmic languages");
        languages.put("BASIC", "Beginners' All-purpose Symbolic Instruction Code");

        // to get the value of a HashMap given the key
        System.out.println(languages.get("Java"));

        // if you put the same key, the value gets overridden
        // therefore check before overriding
        if (languages.containsKey("Java")){
            System.out.println("Java is already in the map");
        }
        else{
            System.out.println(languages.put("Java", "This is the course about java")) ;
            System.out.println("Java added successfully");
        }

        // normal replace method
        languages.replace("Java", "This is java masterclass");

        // more advances replace
        if (languages.replace("Java","This is java masterclass", "A complied high level, object orientated, platform independent" )){
            System.out.println("Changed successfully");
        }
        else{
            System.out.println("Wrong old value or key value");
        }

        // printing contents of languages
        for (String key : languages.keySet()){
            System.out.println(key + " : " + languages.get(key));
        }


    }
}
