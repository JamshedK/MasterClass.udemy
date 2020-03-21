package masterclass.udemy;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter the size of your data");
        int count = scanner.nextInt();
        System.out.println(findMin(getIntegers(count)));
    }

    public static int [] getIntegers(int count){
        int [] array = new int[count];
        System.out.println("Input the numbers");
        for(int i = 0; i < count; i++){
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static int findMin(int [] array){
        int min = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] < array[min]){
                min = i;
            }
        }
        return array[min];
    }
}
