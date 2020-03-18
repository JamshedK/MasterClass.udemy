package masterclass.udemy;

public class Main {

    public static void main(String[] args) {
        System.out.println(areEqualByThreeDecimalPlaces(5.0448, 5.0459));
    }
    public static boolean areEqualByThreeDecimalPlaces(double firstDecimal, double secondDecimal){

        int thirdDecimalPointOfFirst = (int) (firstDecimal*1000);
        int thirdDecimalPointOfSecond = (int) (secondDecimal*1000);

            if(thirdDecimalPointOfFirst==thirdDecimalPointOfSecond){
                return true;
            }
            return false;
    }
}
