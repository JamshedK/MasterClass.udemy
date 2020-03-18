package masterclass.udemy;

public class Dates {

    private int day;
    private int month;
    private int year;

    public Dates(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public static int stayDays(Dates x, Dates y){

        int [] months = {31, 28, 31, 30, 31, 30, 31, 31,30, 31, 30, 31};
        int totalDaysX = x.getDay() + x.getYear()*365;
        for(int i = 0; i < x.getMonth()-1; i++){
            totalDaysX +=months[i];
        }
        totalDaysX += checkLeapYear(x);

        // do the same with sign out date
        int totalDaysY = y.getDay() + y.getYear()*365;
        for(int i = 0; i < y.getMonth() -1; i++){
            totalDaysY += months[i];
        }
        totalDaysY += checkLeapYear(y);

        return Math.abs(totalDaysX - totalDaysY);
    }

    public static int checkLeapYear(Dates x){
        int year = x.getYear();
        if(x.getMonth() < 2){
            year--;
        }
        return (int) (year / 4 - year / 100 + year / 400);
    }
}
