package masterclass.udemy;

public class Main {

    public static void main(String[] args) {
        System.out.println("Greatest common divisor of both numbers " + getGreatestCommonDivisor(45, 180));
    }
    public static int getGreatestCommonDivisor(int num1, int num2){
        if(num1 < 10 || num2 < 10){
            return -1;
        }
        double maxIteration = 0;
        int greatestCommonDivisor = 0;
        if(num1 > num2){
             maxIteration = num1;
        }
        else{
            maxIteration = num2;
        }
        int divisorNum1 = 0;
        int divisorNum2 = 0;
        for(int i = 2; i <= maxIteration; i++){

            if(num1 % i == 0){
                divisorNum1 = i;
            }
            if(num2 % i == 0){
                divisorNum2 = i;
            }
            if(divisorNum1 == divisorNum2){
                greatestCommonDivisor = divisorNum1;
            }
        }
        return greatestCommonDivisor;
    }
}
