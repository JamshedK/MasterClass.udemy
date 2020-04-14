package masterclass.udemy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Album {
    private String albumName;
    private LinkedList<Song> songListInAlbum;
    private static LinkedList<Song> playList = new LinkedList<>();

    public Album(String albumName) {
        this.albumName = albumName;
        this.songListInAlbum = new LinkedList<>();
    }

    public void addSong(String title, double duration){
        Song song = new Song(title, duration);
        ListIterator<Song> listIterator = songListInAlbum.listIterator();
        while (listIterator.hasNext()){
            int difference = listIterator.next().getTitle().compareToIgnoreCase(title);
            if(difference == 0){
                System.out.println("The name already exists");
                return;
            }
            else if(difference > 0){
                listIterator.previous();
                listIterator.add(song);
                return;
            }
        }
        songListInAlbum.add(song);
    }

    public void addToPlayList(String title){
        ListIterator<Song> listIterator = songListInAlbum.listIterator();
        while (listIterator.hasNext()){
            if(listIterator.next().getTitle().equalsIgnoreCase(title)){
                Song newSong = findSong(title);
                if(newSong != null) {
                    playList.add(newSong);
                }
                else{
                    System.out.println("Song " + title + " does not exist in your album");
                }
            }
        }
    }

    private Song findSong(String title){
        ListIterator<Song> listIterator = songListInAlbum.listIterator();
        while (listIterator.hasNext()){
            if(listIterator.next().getTitle().equalsIgnoreCase(title)){
                return listIterator.previous();
            }
        }
        return null;
    }

    public static void printPlayList(){
        System.out.println("Song list in play list");
        Iterator<Song> iterator = playList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().getTitle());
        }
    }

    public  static LinkedList<Song> getPlayList() {
        return playList;
    }

}

