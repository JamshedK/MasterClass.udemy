package masterclass.udemy;

public class Main {

    public static void main(String[] args) {
        System.out.println(isCatPlaying1(false, 36));
    }
    public static boolean isCatPlaying1(boolean summer, int temperature){
        int tempLimit = (summer) ? 45 : 35;

        if(temperature >=25 && temperature<tempLimit){
            return true;
        }
        else{
            return false;
        }
    }
}
