package masterclass.udemy;

public class Main {

    public static void main(String[] args) {
        System.out.println(isEven(23));
        int start = 4;
        int end = 20;
        int count = 0;
        // challenge
        // modify the code
        while(start<=end && count<5){
            start++;
            if(!isEven(start)){
                continue;
            }
            System.out.println("The even numbers are " + start);
            count++;
        }
        System.out.println("The total number of even numbers found " + count);
    }

    // challenge isEvenNumber method
    public static boolean isEven(int number) {
        return (number % 2 == 0);
    }

}
