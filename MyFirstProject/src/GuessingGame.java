import java.util.Scanner;

public class GuessingGame {

    public static void main (String [] args){
        int random = (int) (Math.random()*100)+1;
        System.out.println(random);
        boolean found = false;
        int i = 10;
        Scanner scanner = new Scanner(System.in);
        while (i>=0 && !found){
            System.out.println("Enter the fucking number");
            int number = scanner.nextInt();

            if(number>random){
                System.out.println("The number is smaller");
            }
            else if (number<random){
                System.out.println("The number is larger");
            }
            else{
                System.out.println("You found the fucking number");
                found = true;
            }
            i--;
        }
        if(!found){
            System.out.println("You fucking retard lost");
        }
    }
}
