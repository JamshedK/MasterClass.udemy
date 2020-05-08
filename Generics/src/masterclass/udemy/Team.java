package masterclass.udemy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// restrict bound type by using extends
// the generic type is team, because we are comparing teams
public class Team <T extends Player> implements Comparable<Team<T>>{
    private String name;
    private int won = 0;
    private int lost = 0;
    private int tied = 0;
    private int played = 0;
    private ArrayList<Player> teamMembers = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public void addPlayer(T player) {
        if (teamMembers.equals(player)) {
            System.out.println("Player already exists");
        } else {
            teamMembers.add(player);
            System.out.println(player.getName() + " is added to the team");
        }
    }

    public void matchResult(Team <T> opponent, int ourScore, int theirScore){
        if(ourScore > theirScore){
            won++;
            System.out.println(this.name + " won the game");
        }
        else if(ourScore < theirScore){
            lost++;
            System.out.println(this.name + " lost the game");
        }
        else{
            tied++;
            System.out.println("Drew");
        }
        played++;
        if (opponent != null){
            opponent.matchResult(null, theirScore, ourScore);
        }
    }

    public int ranking(){
        return this.won * 3 + tied;
    }

    public String getName() {
        return name;
    }

    public int getWon() {
        return won;
    }

    public int getLost() {
        return lost;
    }

    public int getTied() {
        return tied;
    }

    public int getPlayed() {
        return played;
    }

    @Override
    public int compareTo(Team<T> team) {
        if (this.ranking() > team.ranking()){
            return 1;
        }
        else if (this.ranking() < team.ranking()){
            return -1;
        }
        else{
            return 0;
        }
    }

}
