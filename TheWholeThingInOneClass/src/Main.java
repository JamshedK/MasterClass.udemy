import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main (String [] args) throws Exception{
        File file = new File("movies.txt");
        Scanner scanner = new Scanner(file);

         String arr[] = new String[100];
         int arraySize=0;

        while(scanner.hasNext()){
            String line = scanner.nextLine();
            arr[arraySize]=line;
            arraySize++;
        }
        String movie= arr[(int) (Math.random()*(arraySize-1))+1];
        System.out.println(movie);

        for(int i=0; i<movie.length(); i++){
                System.out.print("_" + " ");
        }
        boolean firstInput = false;
        System.out.println("Enter your character");
        Scanner scanner1 = new Scanner(System.in);
        char input = scanner1.next().charAt(0);

        char inputtedValues [] = new char[100];
        int size = 0;
        inputtedValues[size]=input;
        size++;
        firstInput=true;
        int indexOf = movie.indexOf(input);

        if(!(indexOf==-1)){
            for(int i=0; i<movie.length();i++){
                if(!(i==indexOf)){
                    System.out.print("_"+" ");
                }
                else{
                    System.out.print(movie.charAt(indexOf) + " ");
                }
            }
        }
    }
}
