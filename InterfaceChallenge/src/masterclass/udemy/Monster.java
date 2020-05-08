package masterclass.udemy;

import java.util.ArrayList;
import java.util.List;

public class Monster implements ISavable {
    private String title;
    private int health;
    private int hitPoints;

    public Monster(int health, String title, int hitPoints) {
        this.health = health;
        this.title = title;
        this.hitPoints = hitPoints;
    }

    @Override
    public List<String> writeToFile() {
        List<String> values = new ArrayList<>();
        values.add(0, "" + this.health);
        values.add(1, this.title);
        values.add(2, "" + hitPoints);
        return values;
    }

    @Override
    public void readFromFile(List<String> list) {
        if(!list.isEmpty()){
            this.title = list.get(0);
            this.health = Integer.parseInt(list.get(1));
            this.hitPoints = Integer.parseInt(list.get(2));
        }
    }

    @Override
    public String toString() {
        return "Monster{" +
                "life=" + health +
                ", title='" + title + '\'' +
                ", hitPoints=" + hitPoints +
                '}';
    }
}
