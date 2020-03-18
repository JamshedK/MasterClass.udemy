package masterclass.udemy;

public class Main {

    public static void main(String[] args) {
        System.out.println(area(0.0));
        System.out.println(area(-1));
        System.out.println(area(3.4, -4));
    }
    public static double area(double radius){
        if(radius >= 0) {
            return radius * radius * Math.PI;
        }
        return -1;
    }
    public static double area (double length, double width){
        if(length < 0 || width < 0){
            return -1;
        }
        return length * width;
    }
}
