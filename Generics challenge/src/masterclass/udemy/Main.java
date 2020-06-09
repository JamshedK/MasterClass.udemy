package masterclass.udemy;

public class Main {

    public static void main(String[] args) {

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

        League<Team<SoccerPlayer>> league = new League<>("ChampionsLeague");

        league.addTeam(realMadrid);
        league.addTeam(barcelona);
        league.addTeam(liverpool);
        league.printRanking();

        System.out.println(liverpool.compareTo(barcelona));

    }

}
