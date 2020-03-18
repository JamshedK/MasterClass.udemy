package masterclass.udemy;


import java.util.ArrayList;

public class Main {

    public static Room [] rooms = new Room[100];

    public static void main(String[] args) {
        Dates arrivalDate = new Dates(10, 3, 2020);
        Dates departureDate = new Dates(29, 3, 2020);
        Room bedroom = new Room(100, 2, 1000, true);

        for(int i = 0; i < 100; i++){
            int beds = (int)(Math.random()*5)+1;
            double random = Math.random();
            boolean isEmpty = false;
            if(random < 0.6){
                isEmpty = true;
            }
            rooms[i] = new Room(i, beds, beds * 1000, isEmpty );
        }

        ArrayList <Room> findRoomsList = new ArrayList<Room>();
        findRoomsList = findRooms(2);

        Client guest1 = new Client(1, "Eduardo", arrivalDate, departureDate, findRoomsList.get(0));
        System.out.println(guest1.calculateBills());

    }

    public static ArrayList <Room> findRooms(int numberOfBeds){
        ArrayList <Room> roomList = new ArrayList<Room>();
        for(int i =0; i < 100; i++){
            if(rooms[i].getBeds() == numberOfBeds){
                roomList.add(rooms[i]);
            }
        }
        return roomList;
    }


}
