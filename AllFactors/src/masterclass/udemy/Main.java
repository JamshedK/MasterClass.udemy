package masterclass.udemy;

public class Main {

    public static void main(String[] args) {
        printAllFactors(32);
    }
    public static void printAllFactors(int num){
        if(num < 0){
            System.out.println("Invalid value");
        }
        for(int i =1; i <= num; i++){
            if(num % i ==0){
                System.out.println("The factors of " + num + " are the following " + i);
            }
        }
    }
}
