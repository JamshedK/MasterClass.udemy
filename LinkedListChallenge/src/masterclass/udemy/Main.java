package masterclass.udemy;

import java.util.*;

public class Main {
    private static ArrayList<Album> albumList = new ArrayList<>();

    public static void main(String[] args) {
      Album edSheeran = new Album("Edd Sheeran");
      Album madina = new Album("Madina Aknazarova");
      albumList.add(edSheeran);
      albumList.add(madina);

      albumList.get(0).addSong("Perfect", 2.6);
      albumList.get(0).addSong("I don't care", 3.4);
      albumList.get(0).addSong("Shape of you", 2.9);
      albumList.get(0).addSong("Amigo", 3.4);

      albumList.get(0).addToPlayList("Perfect");
      albumList.get(0).addToPlayList( "I don't care");
      albumList.get(0).addToPlayList("Shape of you");

      albumList.get(1).addSong("Biraqsem", 2.3);

      albumList.get(1).addToPlayList("Biraqsem");

      play();

    }

    private static void play(){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<Song> listIterator = Album.getPlayList().listIterator();
        if(Album.getPlayList().isEmpty()){
            System.out.println("The play list is empty");
            return;
        }
        printInstructions();
        System.out.println("Currently -->> " + listIterator.next().getTitle() + " is playing");

        while (!quit){
                int action = scanner.nextInt();
                scanner.nextLine();
                switch (action) {
                    case 0:
                        // quit
                        System.out.println("Quitting ...... ");
                        quit = true;
                        break;

                    case 1:
                        // skip forward
                        if(!goingForward){
                            if (listIterator.hasNext()){
                                listIterator.next();
                                goingForward = true;
                            }
                        }
                        if (listIterator.hasNext()) {
                            System.out.println("Currently -->> " + listIterator.next().getTitle() + " is playing");
                        } else {
                            System.out.println("This is the end of the list");
                        }
                        break;

                    case 2:
                        // skip backwards
                        if(goingForward){           // to avoid duplication when printed
                            if (listIterator.hasPrevious()){
                                listIterator.previous();
                                goingForward = false;
                            }
                        }
                        if (listIterator.hasPrevious()) {
                            System.out.println("Currently -->> " + listIterator.previous().getTitle() + " is playing");
                        } else {
                            System.out.println("This is the start of the list");
                        }
                        break;

                    case 3:
                        // Replay
                        // 1st case
                        if(goingForward){
                            if (listIterator.hasPrevious()){
                                System.out.println("Currently -->> " + listIterator.previous().getTitle() + " is playing");
                                goingForward = false;
                            }
                        }
                        // 2nd case

                         if(!goingForward){
                            if (listIterator.hasNext()){
                                System.out.println("Currently -->> " + listIterator.next().getTitle() + " is playing");
                                goingForward = true;
                            }
                        }
                        break;

                    case 4:
                        // list the songs in the playlist
                        Album.printPlayList();
                        break;

                    case 5:
                        // remove the current song from playlist
                        System.out.println( listIterator.previous().getTitle() + " removed");
                        listIterator.remove();
                        break;
                }
        }
    }

    public static void printInstructions(){
        System.out.println("Press: \n " +
                            " \t 0 - to quit \n" +
                            " \t 1 - to skip forward \n" +
                            " \t 2 - to skip backwards backward \n" +
                            " \t 3 - to replay the song \n" +
                            " \t 4 - List the songs in playlist \n" +
                            " \t 5 - to remove the current song from playlist \n ");
    }


}
