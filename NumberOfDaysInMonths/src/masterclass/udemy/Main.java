package masterclass.udemy;

public class Main {

    public static void main(String[] args) {
        System.out.println(isLeapYear(-1600));
        System.out.println(getDaysInMonths( 2, 2020));
    }
    public static boolean isLeapYear(int year){

        if(year <= 1 || year >= 9999){
            return false;
        }
        else {
            if(year % 4 == 0){
                if(year % 100 == 0){
                    if(year % 400 == 0){
                        return true;
                    }
                    else {
                        return false;
                    }
                }
                else {
                    return true;
                }
            }
            else {
                return false;
            }
        }
    }
    public static int getDaysInMonths(int month, int year){
        int numberOfDays = -1;
        if((month < 0) || (month > 12) || (year <1) || (year > 9999) ){
            return numberOfDays;
        }
        else{
            switch (month){
                case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                    numberOfDays = 31;
                    break;
                case 4: case 6: case 9: case 11:
                    numberOfDays = 30;
                    break;
                case 2:
                    if(isLeapYear(year)){
                        numberOfDays = 29;
                        break;
                    }
                    else{
                        numberOfDays = 28;
                        break;
                    }
            }
        }
        return numberOfDays;
    }
}
