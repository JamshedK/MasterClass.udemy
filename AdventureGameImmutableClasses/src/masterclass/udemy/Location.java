package masterclass.udemy;

import java.util.HashMap;
import java.util.Map;

public class Location {
    // private final provide immutability, once set, can't be changed
    private final int locationId;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(int locationId, String description, Map<String, Integer> exits) {
        this.locationId = locationId;
        this.description = description;
        // create a shallow copy to provide immutability
        if(exits != null) {
            this.exits = new HashMap<>(exits);
        }
        else{
            this.exits = new HashMap<>();
        }
        this.exits.put("Q", 0);
    }

    public int getLocationId() {
        return locationId;
    }

    public String getDescription() {
        return description;
    }

    public HashMap<String, Integer> getExits() {
        return new HashMap<>(exits);
    }
}
