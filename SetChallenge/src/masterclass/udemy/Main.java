package masterclass.udemy;

import java.util.*;

public class Main {

    private static Map<HeavenlyBody.Key, HeavenlyBody> solarSystem = new HashMap();
    private static Set<HeavenlyBody> planets = new HashSet<>();
    private static Set<HeavenlyBody> moons = new HashSet<>();

    public static void main(String[] args) {

        Planet temp = new Planet("Mercury", 88);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);

        temp = new Planet("Venus", 225);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);

        temp = new Planet("Earth", 365);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);

        Moon tempMoon = new Moon("Moon", 27);
        solarSystem.put(tempMoon.getKey(),tempMoon);
        temp.addSatellite(tempMoon);

        temp = new Planet("Mars", 687);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);

        tempMoon = new Moon("Deimos", 1.3);
        solarSystem.put(tempMoon.getKey(),tempMoon);
        temp.addSatellite(tempMoon); // temp is still Mars

        tempMoon = new Moon("Phobos", 0.3);
        solarSystem.put(tempMoon.getKey(),tempMoon);
        temp.addSatellite(temp); // temp is still Mars

        temp = new Planet("Jupiter", 4332);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);

        tempMoon = new Moon("Io", 1.8);
        solarSystem.put(tempMoon.getKey(),tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Europa", 3.5);
        solarSystem.put(tempMoon.getKey(),tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Ganymede", 7.1);
        solarSystem.put(tempMoon.getKey(),tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Callisto", 16.7);
        solarSystem.put(tempMoon.getKey(),tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Jupiter", 45);
        solarSystem.put(tempMoon.getKey(),tempMoon);
        temp.addSatellite(tempMoon);

        temp = new Planet("Saturn", 10759);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);

        temp = new Planet("Uranus", 30660);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);

        temp = new Planet("Neptune", 165);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);

        temp = new Planet("Pluto", 248);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);

        // Creating a union of all the moons
        for (HeavenlyBody planet : planets){
            moons.addAll(planet.getSatellites());
        }

        System.out.println("Moons of Jupiter");
        HeavenlyBody body = solarSystem.get(HeavenlyBody.makeKey("Jupiter", HeavenlyBody.BodyTypes.PLANET));
        for (HeavenlyBody moon : body.getSatellites()){
            System.out.println("\t" + moon);
        }

        System.out.println("Moons");
        for (HeavenlyBody moon : moons){
            System.out.println("\t" + moon.getKey());
        }

        System.out.println("Planets");
        for (HeavenlyBody planet : planets){
            System.out.println("\t" + planet.getKey());
        }

        System.out.println("Solar system objects");
        int i = 0;
        for (HeavenlyBody.Key objects : solarSystem.keySet()){
            i++;
            System.out.println("\t " + i + ". " + solarSystem.get(objects));
        }


    }
}
