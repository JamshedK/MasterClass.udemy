package masterclass.udemy;

import java.util.jar.JarOutputStream;

public class Main {

    public static void main(String[] args) {
        System.out.println(isPrime(13));
        // challenge start from 2 and go all the way up to 8
        for(int i=2; i<9; i++){
            System.out.println("10,000 at " + i+ "% interest " + String.format("%.1f", calculateInterest(10000, i)));
        }
        // challenge start from 8 and go all the way to two
        for(int i=8; i>1; i--){
            System.out.println("10,000 at " + i+ "% interest " + String.format("%.1f", calculateInterest(10000, i)));
        }

        // challenge counting the number of prime numbers
        // exit if there are 3 prime numbers found
        int count = 0;
        for(int i = 2; i < 30; i++){
            if(isPrime(i)) {
                count++;
                System.out.println("Number " + i + " is a prime number");
                if(count ==3){
                    System.out.println("Exiting for loop");
                    break;
                }
            }
        }
    }

    public static double calculateInterest(double amount, double interest){
        return (amount *(interest/100));
    }

    public static boolean isPrime(int n){
        if(n == 1){
            return false;
        }
        // loop until the square root of the number
        // because this is the most efficient way
        for(int i =2; i<= (long) Math.sqrt(n); i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}

