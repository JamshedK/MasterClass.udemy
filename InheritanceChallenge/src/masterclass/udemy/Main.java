package masterclass.udemy;

public class Main {

    public static void main(String[] args) {
        Vehicle truck = new Vehicle("Red", 1, "truck");
        Car car = new Car("Green", 1, "Electric Car", 4, 4, "Tesla", 5);
        TeslaModelX myModelX = new TeslaModelX("White", "Electric car", 4, "Tesla Model X", 350, 100);

//        myModelX.moving(30);
//        myModelX.makeATurn();
//
//        car.moving(45);
        System.out.println(myModelX.getNumberOfSeats());

        System.out.println(car.getNumberOfSeats());

    }
}
