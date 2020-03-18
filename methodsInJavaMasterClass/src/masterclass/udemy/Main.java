package masterclass.udemy;

public class Main {

    public static void main(String[] args) {

        int highScorePosition = calculateHighScorePosition(500);
        displayHighScorePosition("Jamshed", highScorePosition);

    }

    public static void displayHighScorePosition(String playerName, int position){
        System.out.println("Player " + playerName + " managed to get to position " + position + " on high score table");
    }

    public static int calculateHighScorePosition(int playerScore){
        int playerPosition = 4;
        if(playerScore >= 1000){
            playerPosition = 1;
        }
        else if(playerScore >= 500){
            playerPosition = 2;
        }
        else if (playerScore >= 100){
            playerPosition = 3;
        }
            return playerPosition;
    }

}

