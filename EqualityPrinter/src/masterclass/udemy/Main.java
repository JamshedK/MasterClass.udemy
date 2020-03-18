package masterclass.udemy;

public class Main {

    public static void main(String[] args) {
        printEqual(1,-2,2);
    }

    public static void printEqual(int firstNumber, int secondNumber, int thirdNumber){
        if(firstNumber <0 || secondNumber < 0 || thirdNumber <0){
            System.out.println("Invalid Value");
        }
        else if (firstNumber == secondNumber && secondNumber == thirdNumber){
            System.out.println("All numbers are equal");
        }
        else if (firstNumber!=secondNumber && secondNumber != thirdNumber && firstNumber!= thirdNumber){
            System.out.println("All numbers are different");
        }
        else {
            System.out.println("Neither all are equal or different");
        }
    }
}
