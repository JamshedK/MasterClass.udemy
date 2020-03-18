package masterclass.udemy;

public class Main {

    private static final String INVALID_MESSAGE = "Invalid Message!";

    public static void main(String[] args) {
        System.out.println(getDurationString(74, 9));
        System.out.println(getDurationString(3960));
    }

    public static String getDurationString(int minutes, int seconds) {
        if (minutes >= 0 && (seconds >= 0 && seconds <= 59)) {
            int hours = minutes / 60;
            int remainingMinutes = minutes % 60;
            String hoursString = String.valueOf(hours);
            String minutesString = String.valueOf(remainingMinutes);
            String secondsString = String.valueOf(seconds);
            if (hours < 10) {
                hoursString = "0" + hours;
            }
            if (remainingMinutes < 10){
                minutesString = "0" + remainingMinutes;
            }
             if(seconds < 10){
                secondsString = "0" + seconds;
            }
            return hoursString + "h " + minutesString + "m " + seconds + "s ";
        }
        return INVALID_MESSAGE;
    }

    public static String getDurationString(int seconds) {

        if(seconds > 0){
            int minutes = seconds / 60;
            int remainingSeconds = seconds % 60;
            return getDurationString(minutes, remainingSeconds);
        }
        return INVALID_MESSAGE;
    }
}