package masterclass.udemy;

public class Main {

    public static void main(String[] args) {
        Point point = new Point();
        System.out.println("distance() = " + point.distance());

        Point point1 = new Point(6, 5);
        System.out.println("distance(2,2) = " + point1.distance(2,2));
        System.out.println("distance(0,0) = " + point1.distance(0,0));

        Point point2 = new Point(3,1);
        System.out.println("distance(point2) = " + point1.distance(point2));
    }
}
