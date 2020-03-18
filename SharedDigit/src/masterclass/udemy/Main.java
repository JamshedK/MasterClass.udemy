package masterclass.udemy;

public class Main {

    public static void main(String[] args) {
        System.out.println(hasSharedDigit(23, 103));
    }

    public static boolean hasSharedDigit(int firstNumber, int secondNumber) {
        if (firstNumber < 10 || firstNumber > 99) {
            return false;
        }
        if (secondNumber < 10 || secondNumber > 99) {
            return false;
        }
        int firstDigitOfFirstNumber = firstNumber % 10;
        int secondDigitOfFirstNumber = firstNumber / 10;
        int firstDigitOfSecondNumber = secondNumber % 10;
        int secondDigitOfSecondNumber = secondNumber / 10;
        return (firstDigitOfFirstNumber == firstDigitOfSecondNumber || firstDigitOfFirstNumber == secondDigitOfSecondNumber
                || secondDigitOfFirstNumber == firstDigitOfSecondNumber || secondDigitOfFirstNumber == secondDigitOfSecondNumber);

    }
}
