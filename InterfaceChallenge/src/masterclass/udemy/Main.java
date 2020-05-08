package masterclass.udemy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

      ISavable player ;
      player = new Player(19 ,"Jamshed", "jamik");
      System.out.println(player.toString());
      saveObject(player);

      loadObject(player);
      System.out.println(player.toString());
    }

    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +
                "1 - to enter a string\n" +
                "0 - to quit");

        while (!quit) {
            System.out.println("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.println("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }

    public static void saveObject(ISavable objectToSave){
        for(int i = 0; i < objectToSave.writeToFile().size(); i++){
            System.out.println("Saving object " + objectToSave.writeToFile().get(i) + " to storage device");
        }
    }

    public static void loadObject(ISavable objectToSave){
        List<String> values = readValues();
        objectToSave.readFromFile(values);
    }
}
