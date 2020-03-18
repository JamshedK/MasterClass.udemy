package masterclass.udemy;

public class Main {

    public static void main(String[] args) {
        System.out.println(isValid(191));
        System.out.println(hasSameLastDigit(32, 42, 34));
    }
    public static boolean hasSameLastDigit(int num1, int num2, int num3){
        if(isValid(num1) && isValid(num2) && isValid(num3)){
            int rightMost1 = num1 % 10;
            int rightMost2 = num2 % 10;
            int rightMost3 = num3 % 10;
            if(rightMost1==rightMost2 || rightMost2 == rightMost3 || rightMost1 == rightMost3){
                return true;
            }
        }
        return false;
    }
    public static boolean isValid(int num){
        return (num >= 10 && num <= 1000);
    }
}
