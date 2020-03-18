package udemy.masterclass;

import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {
        int highScorePosition = calculateHighScorePosition(500);
        displayHighScorePosition("Jamshed", highScorePosition);


    }
    public static void displayHighScorePosition(String playerName, int position){
        System.out.println("Player" + playerName + " managed to get to position " + position + " on high score table");
    }
    public static int calculateHighScorePosition(int playerScore){

        if(playerScore>1000){
            return 1;
        }
        else if((playerScore>500) && (playerScore<1000)){
            return 2;
        }
        else if ((playerScore>100) && (playerScore <500)){
            return 3;
        }
        else{
            return 4;
        }
    }
}
