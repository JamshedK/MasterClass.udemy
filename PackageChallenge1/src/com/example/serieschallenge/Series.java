package com.example.serieschallenge;

public class Series {
    public static int nSum(int n){
        int sum = 0;
        for(int i = 1; i <= n; i++ ){
            sum = sum + i;
        }
        return sum;
    }

    public static int factorial(int num){
        int sum = 1;
        for(int i = 1; i <= num; i++){
            sum = sum * i;
        }
        return sum;
    }

    public static int fibonacci(int num){
        if(num == 0){
            return num;
        }
        if (num == 1){
            return num;
        }
        else{
            return num = fibonacci(num -1 ) + fibonacci(num - 2);
        }
    }
}
