package masterclass.udemy;

public class TeslaModelX extends Car {

    private double range;
    private double batteryCapacity;

    public TeslaModelX(String color, String type, int doors, String name, double range, double batteryCapacity) {
        super(color, 1, type, 4, doors, name, 7);
        this.range = range;
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public void moving(int speed) {
        super.moving(speed);
        System.out.println("TeslaModelX.moving() is called");
    }

}
