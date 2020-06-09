package masterclass.udemy;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public  class League<T extends Team>{
    private String name;
    private LinkedList<T> orderedList = new LinkedList<>();

    public League(String name) {
        this.name = name;
    }

    public void addTeam(T team){
        if (team.ranking() < 4){
            System.out.println("You do not have enough points to join the league");
        }
        else{
            orderedList.add(team);
            System.out.println("Congratulations, your team - " + team.getName() + " - joined the Champions League");
        }
    }

    public void printRanking(){
        Collections.sort(orderedList);
        printRanking(orderedList);
    }

    private void printRanking(LinkedList<T> teamList){
        int i = 1;
        Iterator<T> iterator = teamList.iterator();

        while (iterator.hasNext()){
            Team team = iterator.next();
            System.out.println(i + ". " + team.getName() + " - " + team.ranking());
        }
    }

}
