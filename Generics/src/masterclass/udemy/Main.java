package masterclass.udemy;

import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
////        // always use type parameter
//        ArrayList <Integer> items = new ArrayList<>();
//        items.add(1);
//        items.add(2);
//        items.add(3);
//        items.add(4);
//        items.add(5);
//        items.forEach(x -> System.out.println(x * 2));
//        for (int i = 0; i < items.size(); i++){
//            System.out.println(items.get(i));
//        }

        FootballPlayer joe = new FootballPlayer("Joe");
        BaseballPlayer patt = new BaseballPlayer("Patt");
        SoccerPlayer messi = new SoccerPlayer("Messi");
        SoccerPlayer ronaldo = new SoccerPlayer("Christiano Ronaldo");

        Team<SoccerPlayer> barcelona = new Team("Barcelona");
        Team<SoccerPlayer> realMadrid = new Team<>("Real Madrid");
        Team<FootballPlayer> adelaideCrow = new Team<>("Adelaide Crows");
        Team<SoccerPlayer> liverpool = new Team<>("Liverpool");

        barcelona.matchResult(realMadrid, 2, 1);
        realMadrid.matchResult(barcelona, 2, 2);
        liverpool.matchResult(barcelona, 1, 3);
        realMadrid.matchResult(liverpool, 3, 1);
        liverpool.matchResult(barcelona, 4, 1);
        liverpool.matchResult(barcelona, 4, 1);
        liverpool.matchResult(realMadrid, 4, 1);

        System.out.println("Ranking");
        System.out.println(barcelona.getName() + " : " + barcelona.ranking());
        System.out.println(realMadrid.getName() + " : " + realMadrid.ranking());
        System.out.println(liverpool.getName() + " : " + liverpool.ranking());

        ChampionsLeague championsLeague = new ChampionsLeague("ChampionsLeague");

        championsLeague.addTeam(realMadrid);
        championsLeague.addTeam(barcelona);
        championsLeague.addTeam(liverpool);
        championsLeague.addTeam(adelaideCrow);
        championsLeague.printRanking();

        System.out.println(liverpool.compareTo(barcelona));

    }

}
