package masterclass.udemy;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int minValue = 0;
        int maxValue = 0;
        boolean isFirstNumber = true;

        while (true){
            System.out.println("Enter number: ");
            boolean isAnInt = scanner.hasNextInt();

            if(isAnInt){
                int num = scanner.nextInt();

                if(isFirstNumber){
                    maxValue = num;
                    minValue = num;
                    isFirstNumber = false;
                }

                else if(num > maxValue){
                    maxValue = num;
                }

                else if(num < minValue){
                    minValue = num;
                }
            }

            else{
                break;
            }
            
            scanner.nextLine();
        }

        System.out.println("The minimum value is: " + minValue );
        System.out.println("The maximum value is:" + maxValue);

        scanner.close();
    }
}
