package masterclass.udemy;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

       printArray(sortIntegers(getArray()));

    }

    public static int [] getArray(){
        System.out.println("Enter the length of the array");
        int arrayLength = scanner.nextInt();
        int [] array = new int[arrayLength];
        System.out.println("Enter the array elements");

        for(int i = 0; i < arrayLength; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static int [] sortIntegers (int [] array) {
        int max = 0;
        // selection sort
        for(int i = 0; i < array.length - 1; i++){
            for (int j = i + 1; j < array.length; j++) {
                if (array[max] < array[j]) {
                    max = j;
                }
            }
            int temp = array[i];
            array[i] = array[max];
            array[max] = temp;
        }
        return array;
    }

    public static void printArray(int [] array) {
        System.out.println("Here is the sorted array: ");
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }
}
