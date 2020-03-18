package masterclass.udemy;

 class Car{

     private String name;
    private boolean engine;
    private int cylinders;
    private int wheels;
    private int doors;

     public Car(String name, int cylinders, int doors) {
         this.name = name;
         this.cylinders = cylinders;
         this.doors = doors;
         this.engine = true;
         this.wheels = 4;
     }

     public void startEngine(){
         System.out.println("Car.startEngine() called. Engine is started");
     }

     public void accelerate(){
         System.out.println("Car.accelerate() called. Car is accelerating");
     }

     public void brake(){
         System.out.println("Car.break() called. The car is stopped");
     }

     public String getName() {
         return name;
     }

     public boolean isEngine() {
         return engine;
     }

     public int getCylinders() {
         return cylinders;
     }

     public int getWheels() {
         return wheels;
     }

     public int getDoors() {
         return doors;
     }
 }

 class Lamborghini extends Car{
     public Lamborghini(int cylinders, int doors) {
         super("Lamborghini", cylinders, doors);
     }

     @Override
     public void accelerate() {
         System.out.println("Lamborghini.accelerate() is called");
     }
 }

 class HyundaiElantra extends Car{
     public HyundaiElantra( int cylinders, int doors) {
         super("Hyundai Elantra", cylinders, doors);
     }

     @Override
     public void brake() {
         System.out.println("HyundaiElantra.brake() is called. The car has stopped");
     }
 }

 class Camry extends Car{
     public Camry(int cylinders, int doors) {
         super("Camry", cylinders, doors);
     }

     @Override
     public void startEngine() {
         System.out.println("Camry.startEngine() is called. The engine is turned on");
     }
 }
public class Main {

    public static void main(String[] args) {
        for(int i = 0; i < 5; i++){
            Car car = randomCar();
            System.out.println("The car name is: " + car.getName());
            car.startEngine();
            car.accelerate();
            car.brake();
            System.out.println("The car has " + car.getDoors() + " doors");
            System.out.println();
        }
    }
    public static Car randomCar(){
        int random = (int) (Math.random() * 3) + 1;
        System.out.println("Random number is: " + random);
        switch (random){
            case 1:
                return new Lamborghini(16, 3);
            case 2:
                return new HyundaiElantra(6, 5);
            case 3:
                return new Camry(8,5);
        }
        return null;
    }

}
