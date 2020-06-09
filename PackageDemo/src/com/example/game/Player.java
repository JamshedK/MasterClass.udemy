package com.example.game;

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
    public List<String> writeToFile() {
        List<String> values = new ArrayList<>();
        values.add(0, "" + this.age);
        values.add(1, name);
        values.add(2, nickName);
        return values;
    }

    @Override
    public void readFromFile(List <String> list) {
        if(!list.isEmpty()) {
            this.age = Integer.parseInt(list.get(0));
            this.name = list.get(1);
            this.nickName = list.get(2);
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "age=" + this.age +
                ", name='" + this.name + '\'' +
                ", nickName='" + this.nickName + '\'' +
                '}';
    }
}
