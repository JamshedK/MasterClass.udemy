package masterclass.udemy;

public class House {

    private Bedrooms bedrooms;
    private Doors doors;
    private String ownersName;
    private String address;
    private int numberOfRooms;

    public House(Bedrooms bedrooms, String ownersName, String address, int numberOfRooms) {
        this.bedrooms = bedrooms;
        this.ownersName = ownersName;
        this.address = address;
        this.numberOfRooms = numberOfRooms;
    }

    public void enter(){
        doors.openDoor();
        System.out.println("Door is opened, now enter the house");
    }
    public Bedrooms getBedrooms() {
        return bedrooms;
    }

    public String getOwnersName() {
        return ownersName;
    }

    public String getAddress() {
        return address;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }
}
