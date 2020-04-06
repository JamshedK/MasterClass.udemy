package masterclass.udemy;

import java.util.LinkedList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<>();

        addInOrder(placesToVisit,"Sydney" );
        addInOrder(placesToVisit,"Melbourne" );
        addInOrder(placesToVisit,"Brisbane" );
        addInOrder(placesToVisit, "Canberra");
        addInOrder(placesToVisit, "Adelaida");
        addInOrder(placesToVisit, "Darwin");

        printList(placesToVisit);

        visit(placesToVisit);

    }

    private static void printList(LinkedList<String> placesToVisit){
        Iterator<String> i = placesToVisit.iterator();
        while (i.hasNext()){
            System.out.println("The city you are visiting now is " + i.next());
        }
    }

   private static void addInOrder(LinkedList<String> linkedList, String newCity){
        ListIterator<String> stringListIterator = linkedList.listIterator();

        while (stringListIterator.hasNext()){
            int comparison = stringListIterator.next().compareToIgnoreCase(newCity);
            // if the name already exists
            if(comparison == 0){
                System.out.println("The city is already in the list ");
                return;
            }
            else if(comparison > 0){
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return;
            }
        }
        //if the city is the first one on the list or the last one
        stringListIterator.add(newCity);
        return;
   }
   private static void visit(LinkedList cities ){
       Scanner scanner = new Scanner(System.in);
       boolean quit = false;
       boolean goingForward = true;

       ListIterator<String> stringListIterator = cities.listIterator();
       if(cities.isEmpty()){
           System.out.println("The list is empty");
       }
       else{
           System.out.println("You are know visiting " + stringListIterator.next());
           printMenu();
       }

       while (!quit){
           int action = scanner.nextInt();
           scanner.nextLine();
           switch (action){
               case 0:
                   System.out.println("Vacation is over");
                   quit = true;
                   break;

               case 1:
                   if(!goingForward){
                       if (stringListIterator.hasNext()){
                           stringListIterator.next();
                       }
                       goingForward = true;
                   }
                   if(stringListIterator.hasNext()){
                       System.out.println("You are now visiting " + stringListIterator.next());
                   }
                   else{
                       System.out.println("Reaches the end of the list");
                       goingForward = false;
                   }
                   break;

               case 2:
                    if(goingForward){
                        if (stringListIterator.hasPrevious()){
                            stringListIterator.previous();
                        }
                        goingForward = false;
                    }
                   if (stringListIterator.hasPrevious()){
                       System.out.println("You are now visiting " + stringListIterator.previous());
                   }
                   else{
                       System.out.println("You are at the start of the list");
                       goingForward = true;
                   }
                   break;

               case 3:
                   printMenu();
                   break ;
           }
       }
   }

   private static void printMenu(){
       System.out.println("Here is the action menu: \n" +
                        "0 - to exit menu \n" +
                        "1 - go to the next city \n" +
                        "2 - go to previous city \n" +
                        "3 - print menu \n");

   }
}
