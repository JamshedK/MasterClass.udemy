package masterclass.udemy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Map<String, Integer> tempExits = new HashMap<>();

        locations.put(0, new Location(0, "You are sitting in front of a computer doing Java course", tempExits));

        tempExits.put("W", 2);
        tempExits.put("E", 3);
        tempExits.put("S", 4);
        tempExits.put("N", 5);
        locations.put(1, new Location(1, "You are standing at the end of the road before a small brick", tempExits));

        tempExits = new HashMap<String, Integer>();
        tempExits.put("N", 5);
        tempExits.put("S", 4);
        locations.put(2, new Location(2, "You are standing on top of a hill", tempExits));

        tempExits = new HashMap<String, Integer>();
        tempExits.put("W", 1);
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring", tempExits));

        tempExits = new HashMap<String, Integer>();
        tempExits.put("N", 1);
        tempExits.put("W", 2);
        locations.put(4, new Location(4, "You are in a valley beside a stream", tempExits));

        tempExits = new HashMap<String, Integer>();
        tempExits.put("S", 1);
        tempExits.put("W", 2);
        locations.put(5, new Location(5, "You are in a forest", tempExits));

        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("NORTH", "N");
        dictionary.put("SOUTH", "S");
        dictionary.put("WEST", "W");
        dictionary.put("EAST", "E");
        dictionary.put("QUIT", "Q");

        int location = 1;

        // Tim's solution
        while (true){
            Map<String, Integer> exits = locations.get(location).getExits();
            System.out.println(locations.get(location).getDescription());
            if (location == 0){
                break;
            }
            System.out.println("Available exits:");
            for (String exit : exits.keySet() ){
                System.out.print(exit + ", " );
            }
            System.out.println();

            String direction = scanner.nextLine().toUpperCase();
            if (direction.length() > 0){
                // split the directions key word
                String [] words = direction.split(" ");
                for (String word : words){
                    // if the direction exists in the dictionary, take the character for the direction
                    if (dictionary.containsKey(word)){
                        direction = dictionary.get(word);
                    }
                }
            }
            if (exits.containsKey(direction)){
                location = exits.get(direction);
            }
            else {
                System.out.println("Can not go to that direction");
            }
        }

        //My solution
//        while (true){
//            Map<String, Integer> exits = locations.get(location).getExits();
//            System.out.println(locations.get(location).getDescription());
//            if (location == 0){
//                quit = true;
//                break;
//            }
//            System.out.println("Available exits:");
//            for (String exit : exits.keySet() ){
//                System.out.print(exit + ", " );
//            }
//            System.out.println();
//
//            String direction = scanner.nextLine();
//            String [] directionSplitted = direction.split("");
//            boolean foundExit = false;
//
//            for (String i : directionSplitted){
//                if (exits.containsKey(i)){
//                    location = exits.get(i);
//                    foundExit = true;
//                }
//            }
//            if (!foundExit){
//                System.out.println("Can not go to that direction");
//            }
//        }
    }
}
