import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Game game = new Game();
        String movieName= game.getMovieList();
        System.out.print(movieName);
    }
}
