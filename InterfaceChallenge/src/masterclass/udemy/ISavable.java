package masterclass.udemy;

import java.util.ArrayList;
import java.util.List;

public interface ISavable {
    List<String> writeToFile();
    void readFromFile(List<String> list);
}
