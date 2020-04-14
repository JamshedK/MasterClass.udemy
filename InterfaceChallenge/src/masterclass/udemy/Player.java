package masterclass.udemy;

import java.util.ArrayList;
import java.util.List;

public class Player implements ISavable {
    private int age;
    private String name;
    private String nickName;

    public Player(int age, String name, String nickName) {
        this.age = age;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public List returnList() {
        return null;
    }

    @Override
    public void populateObject(List <String> list) {

    }

    @Override
    public String toString() {
        return "Player{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
