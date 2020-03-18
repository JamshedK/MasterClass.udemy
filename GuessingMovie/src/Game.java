import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Game {
    private String moviesList[] = new String[100];
    private int moviesListSize = 0;

    public String getMovieList() {
        String movie = null;
    try {
        File file = new File("movieList.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            moviesList[moviesListSize] = line;
            moviesListSize++;
        }
         movie = moviesList[(int) (Math.random() * (moviesListSize - 1)) + 1];

    }
    catch (Exception e){
        System.out.print(e);
    }
    return movie;
    }

}
