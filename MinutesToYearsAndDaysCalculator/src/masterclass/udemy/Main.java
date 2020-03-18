package masterclass.udemy;

public class Main {

    public static void main(String[] args) {
        printYearsAndDays(561600);
    }
    public static void printYearsAndDays (long minutes){
        if(minutes <0){
            System.out.println("Invalid Value");
        }
        else{
            long years = minutes / ( 365 * 24 * 60);
            long days = (minutes % ( 365 * 24 * 60))/ (24 * 60);
            System.out.println(minutes + " m = " + years + " y " + days + " d" );
        }
    }
}
