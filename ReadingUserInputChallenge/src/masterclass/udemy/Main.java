package masterclass.udemy;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int count = 1;
        int sum = 0;
        Scanner scanner = new Scanner(System.in);
        while (count <= 10){
            System.out.println("Enter num #" + count + ":");
            boolean hasNextInt = scanner.hasNextInt();
            if(hasNextInt){
                int num = scanner.nextInt();
                sum += num;
                count++;
            }
            else{
                System.out.println("Invalid value");
            }
            scanner.nextLine();// handle end of line (enter key)
        }
        System.out.println("The sum of all the numbers is " + sum);
        scanner.close();
    }
}
