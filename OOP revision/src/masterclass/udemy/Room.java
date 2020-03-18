package masterclass.udemy;

public class Room {

    private int roomNumber;
    private int beds;
    private double price;
    private boolean isEmpty;

    public Room(int roomNumber, int beds, double price, boolean isEmpty) {
        this.roomNumber = roomNumber;
        this.beds = beds;
        this.price = price;
        this.isEmpty = isEmpty;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getBeds() {
        return beds;
    }

    public double getPrice() {
        return price;
    }

    public boolean isEmpty() {
        return isEmpty;
    }
}
