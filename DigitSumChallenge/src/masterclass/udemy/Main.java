package masterclass.udemy;

public class Main {

    public static void main(String[] args) {
        System.out.println(sumDigit(4));
    }

    public static int sumDigit(int num){

        int sum = 0;

        if(num < 10){
            return -1;
        }

            while (num != 0) {
                // extract the remainder of num
                // for example:
                // 125 % 10 = 5
                sum = sum + num % 10;
                // drop the least significant digit
                num = num / 10;
            }

        return sum;

    }
}
