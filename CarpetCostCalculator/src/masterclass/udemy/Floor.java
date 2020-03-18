package masterclass.udemy;

public class Floor {
    private double width;
    private double height;

    public Floor(double width, double height) {
        this.width = width  >= 0 ? width : 0;
        this.height = height >= 0 ? height : 0;
    }

    public double getArea(){
        return this.width * this.height;
    }
}
