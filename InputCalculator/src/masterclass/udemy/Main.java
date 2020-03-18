package masterclass.udemy;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        inputThenPrintSumAndAverage();
    }
    public static void inputThenPrintSumAndAverage(){
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int counter = 0;
        boolean isFirstInput = true;
        while (true){
            boolean isAnInt = scanner.hasNextInt();
            if(isAnInt){
                int num = scanner.nextInt();
                sum += num;
                counter ++;
                isFirstInput = false;
            }
            else{
                if(isFirstInput){
                    counter++;
                }
                break;
            }
            scanner.nextLine();
        }
        System.out.println(" SUM = " + sum + " AVG = " + Math.round((double)sum/counter));
        scanner.close();
    }
}
