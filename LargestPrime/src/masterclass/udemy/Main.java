package masterclass.udemy;

public class Main {

    public static void main(String[] args) {
        System.out.println(getLargestPrime(16));
    }
    public static int getLargestPrime(int num){
        int largestPrime = -1;
        int factor = 0;
        // loop through to find the factors of a given number
        for(int i = 2; i <= num; i++){
            if(num % i == 0){
                factor = i;
            }
            // check whether the factor is prime or not
            boolean isPrime = true;
            for(int j = 2; j <= factor / 2; j++){
                if(factor % j == 0){
                    isPrime = false;
                    break;
                }
            }
            // if the factor is prime, then compare with largest
            if(isPrime){
                largestPrime = factor;
            }
        }
        return largestPrime;
    }
}
