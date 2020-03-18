package masterclass.udemy;

public class Main {

    public static void main(String[] args) {
        int count =0;
        int sum = 0;
        for(int i=1; i<=1000; i++){
            if( (i % 3 == 0) && (i % 5 == 0)){
                sum = sum + i;
                System.out.println("the number that divides both by 3 and 5 is " + i);
                count++;
                if(count == 5){
                    System.out.println("The sum of all the numbers is " + sum);
                    break;
                }
            }
        }

    }
}
