package masterclass.udemy;

import java.util.LinkedList;

public abstract class League <T extends Team<Player> >{
    private String name;
    private LinkedList<Team> teamList = new LinkedList<>();

    public League(String name) {
        this.name = name;
    }

    public abstract void addTeam(T team);

    public LinkedList<Team> getTeamList() {
        return teamList;
    }
}
