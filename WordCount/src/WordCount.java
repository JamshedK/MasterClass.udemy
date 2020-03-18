import java.util.Scanner;
import java.io.File;

public class WordCount {
    public static void main (String [] args) throws Exception{

        File file = new File("61515-0.txt");
        Scanner scanner = new Scanner(file);
        int wordCount = 0;

        while(scanner.hasNext()){
            String line = scanner.nextLine();
            wordCount+=line.split(" ").length;
        }
        System.out.println("the number of the word are " + wordCount);
    }
}
