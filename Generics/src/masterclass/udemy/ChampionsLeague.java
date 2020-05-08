package masterclass.udemy;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class ChampionsLeague extends League {
    private LinkedList<Team> orderedList = new LinkedList<>();

    public ChampionsLeague(String name) {
        super(name);
    }

    @Override
    public void addTeam(Team team) {
        if (team.ranking() < 4){
            System.out.println("You do not have enough points to join the league");
        }
        else{
            getTeamList().add(team);
            System.out.println("Congratulations, your team - " + team.getName() + " - joined the Champions League");
        }
    }

    public void printRanking(){
        ListIterator<Team> teamsIterator = getTeamList().listIterator();
        // fetch from the previous list and add it to the new list
        while (teamsIterator.hasNext()){
            Team fetchedTeam = teamsIterator.next();
            addInOrder(fetchedTeam);
        }
        printRanking(orderedList);
    }

    private void printRanking(LinkedList<Team> teamList){
        int i = 1;
        Iterator<Team> iterator = teamList.iterator();

        while (iterator.hasNext()){
            Team team = iterator.next();
            System.out.println(i + ". " + team.getName() + " - " + team.ranking());
        }
    }

    private void addInOrder(Team team){
        int location = -1;
        // if the list is empty, then add right away
        if (orderedList.isEmpty()){
            orderedList.add(team);
        }
        else{
            for(int i = 0; i < orderedList.size(); i++){
                if (orderedList.get(i).ranking() < team.ranking()){
                    location = i;
                    break;
                }
            }
            orderedList.add(location, team);
        }

        }

}
