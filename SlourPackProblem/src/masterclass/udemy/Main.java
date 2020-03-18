package masterclass.udemy;

public class Main {

    public static void main(String[] args) {
        System.out.println(canPack(1, 19,19));
    }

    public static boolean canPack(int bigCount, int smallCount, int goal){

        int sum = bigCount * 5 + smallCount * 1;

        if(bigCount < 0 || smallCount < 0 || goal < 0){
            return false;
        }

        else if(sum < goal){
            return false;
        }

        else if(sum == goal){
            return true;
        }

        else if(bigCount == 0 && smallCount >= goal){
                    return true;
        }

        else{
            int remainingFlourAfterBigPack = goal % 5;
            System.out.println("Remaining Flour After Big Pack " + remainingFlourAfterBigPack);
             if(smallCount >= remainingFlourAfterBigPack){
                 return true;
             }
        }

           return false;
        }
}
