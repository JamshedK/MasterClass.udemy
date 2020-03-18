package masterclass.udemy;

public class Main {

    public static void main(String[] args) {
        System.out.println(isPalindrome(-233));
    }

    public static boolean isPalindrome(int num) {
        int reverse = 0;
        int tempNum = num;
        while(num != 0){
            reverse = reverse * 10 + num % 10;
            System.out.println(reverse);
            num = num / 10;
        }
            return reverse == tempNum;
    }

}