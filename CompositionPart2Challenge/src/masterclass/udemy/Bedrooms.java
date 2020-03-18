package masterclass.udemy;

public class Bedrooms {

    private int numberOfBeds;
    private Furniture furniture;

    public Bedrooms(int numberOfBeds, Furniture furniture) {
        this.numberOfBeds = numberOfBeds;
        this.furniture = furniture;
    }

    public void emptySpace(){
        System.out.println("Furniture is removed");
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

}
