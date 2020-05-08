package masterclass.udemy;

import java.util.ArrayList;

public class GearBox {
    private ArrayList <Gear> gears;
    private int maxGear;
    private int currentGear = 0;
    private boolean clutchIsIn;

    public GearBox(int maxGear) {
        this.maxGear = maxGear;
        this.gears = new ArrayList<>();
        Gear neutral = new Gear(0, 0.0);
        gears.add(neutral);
        for(int i = 0; i < maxGear; i++){
            addGears(i, i * 5.3);
        }
    }

    public void operateClutch(boolean in){
        this.clutchIsIn = in;
    }

    private void addGears(int gearNumber, double gearRatio){
        if(gearNumber > 0 && gearNumber <= maxGear){
            gears.add(new Gear(gearNumber, gearRatio));
            System.out.println("Added a new gear ");
        }

    }

    public void changeGear(int newGear){
        if(newGear > 0 && clutchIsIn && newGear < this.gears.size()){
            currentGear = newGear;
            System.out.println("Gear " + this.currentGear + " is selected. ");
        }
        else{
            System.out.println("Cannot change the gear ");
        }
    }

    public double wheelSpeed(int revs){
        if(clutchIsIn){
            System.out.println("Scream! ");
            return 0.0;
        }
        return gears.get(currentGear).driveSpeed(revs);
    }

    private class Gear{
        private int gearNumber;
        private double gearRatio;

        public Gear(int gearNumber, double gearRatio) {
            this.gearNumber = gearNumber;
            this.gearRatio = gearRatio;
        }

        public double driveSpeed(int revs){
            return revs * this.gearRatio;
        }

        public int getGearNumber() {
            return gearNumber;
        }

        public double getGearRatio() {
            return gearRatio;
        }
    }
}
