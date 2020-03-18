package masterclass.udemy;

public class Main {

    public static void main(String[] args) {
        System.out.println(getEvenDigitSum(56483));
    }
    public static int getEvenDigitSum(int number){
        int sum = 0;
        while(number !=0 ){
            int lastDigit = number % 10;
            if(lastDigit % 2 == 0){
                sum = sum + lastDigit;
            }
            number /= 10;
        }
        return sum;
    }
}
