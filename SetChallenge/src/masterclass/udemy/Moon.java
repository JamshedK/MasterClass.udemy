package masterclass.udemy;

import java.util.Set;

public class Moon extends HeavenlyBody {
    public Moon(String name, double orbitalPeriod ) {
        super(name, orbitalPeriod, BodyTypes.MOON);
    }

    @Override
    public void addSatellite(HeavenlyBody satellite) {
        System.out.println("Can't add moon to a moon");
    }

}
