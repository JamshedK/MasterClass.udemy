package masterclass.udemy;

public class Main {

    public static void main(String[] args) {

        GearBox lamborghini = new GearBox(6);
        lamborghini.operateClutch(true);
        lamborghini.changeGear(1);
        lamborghini.changeGear(2);
        lamborghini.changeGear(3);

        System.out.println(lamborghini.wheelSpeed(100));
        lamborghini.operateClutch(false);
        System.out.println(lamborghini.wheelSpeed(100));

    }
}
