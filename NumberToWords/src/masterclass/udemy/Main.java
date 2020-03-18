package masterclass.udemy;

public class Main {

    public static void main(String[] args) {

             // The function of this program is to print each digit of a number using words

        System.out.println(reverse(0));
        System.out.println(getDigitCount(0));
        numberToWords(100000);

    }

    public static int reverse(int num){
        int reversedNumber = 0;
        while(num != 0){
            reversedNumber = reversedNumber * 10 + num % 10;
            num = num / 10;
        }
        return reversedNumber;
    }

    public static int getDigitCount(int num){
        if(num < 0){
            return -1;
        }
        int count = 1;
        while(num > 9){
            num /= 10;
            count ++;
        }
        return count;
    }

    public static void numberToWords(int num){

        if(num<0){
            System.out.println("Invalid Value");
        }

        if(num == 0){
            System.out.println("Zero");
        }

        /*
         Reverse the given number, because when using while the number will be printed in reverse
         order
         */

        int reversedNumber = reverse(num);
        int lastDigit = 0;

        while(reversedNumber != 0){
            // Get the last digit of the reversed number
            // which means the first digit of "num"
            lastDigit = reversedNumber % 10;
            reversedNumber /= 10;

            // Use switch to output the string value for the last digit
            switch (lastDigit){
                case 0:
                    System.out.println("Zero");
                    break;
                case 1:
                    System.out.println("One");
                    break;
                case 2:
                    System.out.println("Two");
                    break;
                case 3:
                    System.out.println("Three");
                    break;
                case 4:
                    System.out.println("Four");
                    break;
                case 5:
                    System.out.println("Five");
                    break;
                case 6:
                    System.out.println("Six");
                    break;
                case 7:
                    System.out.println("Seven");
                    break;
                case 8:
                    System.out.println("Eight");
                    break;
                case 9:
                    System.out.println("Nine");
                    break;
            }
        }
        // this loop is for printing leading zeros of reversed number
        int numberOfLeadingZeros = getDigitCount(num) - getDigitCount(reverse(num));
        for(int i = 0; i < numberOfLeadingZeros; i++){
            System.out.println("Zero");
        }
    }
}
