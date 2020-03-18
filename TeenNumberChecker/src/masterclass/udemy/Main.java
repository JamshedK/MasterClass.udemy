package masterclass.udemy;

public class Main {

    public static void main(String[] args) {
        System.out.println(hasTeen(9, 23, 45));
    }
    public static boolean hasTeen(int firstNumber, int secondNumber, int thirdNumber ){
        return (isTeen(firstNumber)|| isTeen(secondNumber) || isTeen(thirdNumber));
    }
    public static boolean isTeen(int value){
        return (value>=13 && value <= 19);
    }
}
