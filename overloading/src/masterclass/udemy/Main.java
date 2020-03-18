package masterclass.udemy;

public class Main {

    public static void main(String[] args) {
        System.out.println(calcFeetAndInchesToCentimeter(156));
    }
    public static double calcFeetAndInchesToCentimeter(double feet, double inches){
        if(feet >=0 && (inches >= 0 && inches <= 12)){
            // 1 feet is 12 inches, and one inch in 2.54 cm
            return (feet*12 + inches)*2.54;
        }
            return -1;
    }
    public static double calcFeetAndInchesToCentimeter(double inches){
        if(inches >= 0){
            double feet = inches/12;
            double remainingInches = inches % 12;
            return calcFeetAndInchesToCentimeter(feet, remainingInches);
        }
        return -1;
    }
}
