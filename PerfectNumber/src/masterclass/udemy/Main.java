package masterclass.udemy;

public class Main {

    public static void main(String[] args) {
        System.out.println(isPerfectNumber(23));
    }

    public static boolean isPerfectNumber(int num) {
        int sum = 0;
        if (num < 1) {
            return false;
        }
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum == num;
    }

}
