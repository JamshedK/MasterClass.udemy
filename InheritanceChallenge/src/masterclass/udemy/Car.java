package masterclass.udemy;

public class Car extends Vehicle{

    private int wheels;
    private int doors;
    private String name;
    private int numberOfSeats;

    public Car(String color, int engine, String type, int wheels, int doors, String name, int numberOfSeats) {
        super(color, engine, type);
        this.wheels = wheels;
        this.doors = doors;
        this.name = name;
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfSeats(){
        return numberOfSeats;
    }
    public void increaseSpeed(){
        changGears();
        System.out.println("Vehicle.increaseSpeed() is called");
    }

    public void decreaseSpeed(){
        changGears();
        System.out.println("Vehicle.decreaseSpeed() is called");
    }
    public void changGears(){
        System.out.println("Vehicle.changeGears() called");
    }

    @Override
    public void moving(int speed) {
        changGears();
        super.moving(speed);
    }

    public void turnSteeringWheel(){
        System.out.println("Car.turnSteeringWheel() is called");
    }

    public void makeATurn(){
        turnSteeringWheel();
        System.out.println("Car.makeATurn() is called");
    }



}
