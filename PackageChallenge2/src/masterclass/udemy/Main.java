package masterclass.udemy;

import com.example.serieschallenge.Series;

public class Main {

    public static void main(String[] args) {
        System.out.println("Sum of numbers from 0 to 10");
        for (int i = 1; i <= 10; i++){
            System.out.println(Series.nSum(i));
        }
        System.out.println("Factorial of numbers from 0 to 10");
        for (int i = 1; i <= 10; i++){
            System.out.println(Series.factorial(i));
        }
        System.out.println("Fibonacci numbers from 0 to 10");
        for (int i = 1; i <= 10; i++){
            System.out.println(Series.fibonacci(i));
        }
    }
}
