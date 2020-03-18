package masterclass.udemy;

public class Furniture {
    private String furnitureName;
    private double width;
    private double length;
    private double height;

    public Furniture(String furnitureName, double width, double length, double height) {
        this.furnitureName = furnitureName;
        this.width = width;
        this.length = length;
        this.height = height;
    }

    public String getFurnitureName() {
        return furnitureName;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public double getHeight() {
        return height;
    }
}
