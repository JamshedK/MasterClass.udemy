package masterclass.udemy;

public class Vehicle {

    private String color;
    private int engine;
    private String type;

    public Vehicle(String color, int engine, String type) {
        this.color = color;
        this.engine = engine;
        this.type = type;
    }

    public void turnOnTheEngine(){
        System.out.println("Vehicle.turnOnEngine() is called");
    }
    public void moving(int speed){
        turnOnTheEngine();
        System.out.println(" Vehicle.moving() is called with the speed of: " + speed);
    }

}
