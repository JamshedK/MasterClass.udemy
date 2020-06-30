package masterclass.udemy;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class HeavenlyBody {
    private final Key key;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public enum BodyTypes{
        STAR,
        PLANET,
        MOON,
        COMET,
        ASTEROID,
    }

    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType) {
        this.key = new Key(name, bodyType);
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public void addSatellite(HeavenlyBody satellite){
        this.satellites.add(satellite);
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Key getKey() {
        return key;
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    public static Key makeKey(String name, BodyTypes bodyType){
        return new Key(name, bodyType);
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj instanceof HeavenlyBody){
            HeavenlyBody theObject = (HeavenlyBody) obj;
            return this.key.equals(theObject.getKey());
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return this.key.hashCode();
    }

    @Override
    public String toString() {
        return this.key.name + " : " + this.key.getBodyType() + " , " + this.getOrbitalPeriod();
    }

    public static class Key{
        private String name;
        private BodyTypes bodyType;

        private Key(String name, BodyTypes bodyType) {
            this.name = name;
            this.bodyType = bodyType;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getBodyType() {
            return bodyType;
        }

        @Override
        public boolean equals(Object object) {
            Key key = (Key)object;
            if (key.getName().equals(this.getName())){
                return key.getBodyType() == this.getBodyType();
            }
            return false;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + 57 + bodyType.hashCode();
        }

        @Override
        public String toString() {
            return name + " : " + bodyType;
        }
    }
}
