package masterclass.udemy;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter the size of your data:");
        int count = scanner.nextInt();
        scanner.nextLine();
        System.out.println("min = " + findMin(getIntegers(count)));
    }

    public static int [] getIntegers(int count){
        int [] array = new int[count];
        for(int i = 0; i < array.length; i++){
            System.out.println("Input a number: ");
            array[i] = scanner.nextInt();
            scanner.nextLine();
        }
        return array;
    }

    public static int findMin(int [] array){
        int min = array[0];
        for(int i = 0; i < array.length; i++){
            if(array[i] < min){
                min = array[i];
            }
        }
        return min;
    }
}
