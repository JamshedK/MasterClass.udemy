package com.example.game;

import java.util.List;

public interface ISavable {
    List<String> writeToFile();
    void readFromFile(List<String> list);
}
