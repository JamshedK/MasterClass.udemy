package masterclass.udemy;

public class Main {

    public static void main(String[] args) {
        System.out.println(sumFirstAndLastDigit(5));
    }

    public static int sumFirstAndLastDigit(int number){
        if(number < 0){
            return -1;
        }
        int digit = 0;
        int lastDigit = number % 10;
        while (number != 0){
             digit = number % 10;
            number = number / 10;
        }
        return digit + lastDigit;
    }
    /*
        public class FirstLastDigitSum {

    public static int sumFirstAndLastDigit(int number) {
        if (number < 0) {
            return -1;
        }

        int lastDigit = number % 10;
        while (number > 9) {
            number /= 10;
        }
        return lastDigit + number;
    }
}
     */
}
