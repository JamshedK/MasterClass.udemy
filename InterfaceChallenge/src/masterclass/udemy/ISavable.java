package masterclass.udemy;

import java.util.ArrayList;
import java.util.List;

public interface ISavable {
    List<String> returnList();
    void populateObject(List<String> list);
}
