package masterclass.udemy;

import java.util.*;

public class Theatre  {
    private final String theatreName;
    public List<Seat> seats = new LinkedList<>();

    public Theatre(String theatreName, int numRows, int seatPerRow) {
        this.theatreName = theatreName;
        int lastRow = 'A' + (numRows -1);
        for(char row = 'A'; row <= lastRow; row++){
            for (int column = 1; column <= seatPerRow; column++){
                seats.add(new Seat(row + String.format("%02d",column)));
            }
        }
    }

    public void reserveSeat(String seatNumber){
        // Using the Collections method
        Seat requestedSeat = new Seat(seatNumber);
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
        if (foundSeat >= 0){
            seats.get(foundSeat).reserve();
        }
        else{
            System.out.println("Seat does not exist");
        }

//        // binary search implementation
//        int low = 0;
//        int high = seats.size() - 1;
//        while (low <= high){
//            int mid = (low + high)/2;
//            int comparison = seats.get(mid).getSeatNumber().compareToIgnoreCase(seatNumber);
//            System.out.print(".");
//            if(comparison > 0 ){
//                high = mid -1;
//            }
//            else if(comparison < 0){
//                low = mid + 1;
//            }
//            else{
//                seats.get(mid).reserve();
//                return;
//            }
//        }
//        System.out.println("Seat does not exist");

//        // linear search implementation
//        for (Seat seat: seats){
//            System.out.print(".");
//            if (seat.getSeatNumber().equalsIgnoreCase(seatNumber)){
//                seat.reserve();
//                return;
//            }
//        }
//        System.out.println("Seat does not exist");
    }

    public void cancelReservation(String seatNumber){
        for (Seat seat: seats){
            if (seat.getSeatNumber().equalsIgnoreCase(seatNumber)){
                seat.cancelReservation();
            }
        }
    }

    public void getSeats(){
        // create an object of seat for every element in seats list
        for(Seat seat : seats){
            System.out.println(seat.getSeatNumber());
        }
    }

    public class Seat implements Comparable<Seat>{
        private final String seatNumber;
        private boolean isReserved;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        public boolean reserve(){
            if (!isReserved){
                isReserved = true;
                System.out.println("You reserved seat number " + seatNumber);
                return true;
            }
            else{
                System.out.println("Seat " + seatNumber + " is already reserved");
                return false;
            }

        }

        public boolean cancelReservation(){
            if (isReserved){
                isReserved = false;
                System.out.println("Reservation for seat " + seatNumber + " is cancelled");
                return true;
            }
            else{
                System.out.println("Seat " + seatNumber + " is not reserved");
                return false;
            }
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }
    }
}
