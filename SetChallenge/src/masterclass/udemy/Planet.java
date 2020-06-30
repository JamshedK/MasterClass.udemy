package masterclass.udemy;

import java.util.Set;

public class Planet extends HeavenlyBody {

    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyTypes.PLANET);
    }

    public void addSatellite(HeavenlyBody satellite) {
        if (satellite instanceof Moon){
            super.addSatellite(satellite);
        }
        else{
            System.out.println("The satellite must be a moon");
        }
    }

    @Override
    public Set<HeavenlyBody> getSatellites() {
        return super.getSatellites();
    }
}
