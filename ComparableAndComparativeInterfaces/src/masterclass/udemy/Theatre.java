package masterclass.udemy;

import java.util.*;

public final class Theatre  {
    private final String theatreName;
    private List<Seat> seats = new LinkedList<>();

    static final Comparator<Seat> PRICE_ORDER_INCREASING;

    static {
        PRICE_ORDER_INCREASING = new Comparator<Seat>() {
            @Override
            public int compare(Seat seat1, Seat seat2) {
                if (seat1.getPrice() < seat2.getPrice()) {
                    return -1;
                } else if (seat1.getPrice() > seat2.getPrice()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };
    }

    static final Comparator<Seat> PRICE_ORDER_DECREASING;

    static {
        PRICE_ORDER_DECREASING = new Comparator<Seat>() {
            @Override
            public int compare(Seat seat1, Seat seat2) {
                if (seat1.getPrice() < seat2.getPrice()) {
                    return 1;
                } else if (seat1.getPrice() > seat2.getPrice()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };
    }

    public Theatre(String theatreName, int numRows, int seatPerRow) {
        this.theatreName = theatreName;
        int lastRow = 'A' + (numRows -1);
        for(char row = 'A'; row <= lastRow; row++){
            for (int seat = 1; seat <= seatPerRow; seat++){
                double price = 12.00;
                if(row < 'D' && seat < 9 && seat > 4){
                    price = 14.00;
                }
                else if(row > 'F' || seat < 4 || seat > 9){
                    price = 7.00;
                }
                seats.add(new Seat((row + String.format("%02d",seat)), price));
            }
        }
    }

    public void reserveSeat(String seatNumber){
        // Using the Collections method
        Seat requestedSeat = new Seat(seatNumber, 0);
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
        if (foundSeat >= 0){
            seats.get(foundSeat).reserve();
        }
        else{
            System.out.println("Seat does not exist");
        }
    }

    public void cancelReservation(String seatNumber){
        for (Seat seat: seats){
            if (seat.getSeatNumber().equalsIgnoreCase(seatNumber)){
                seat.cancelReservation();
            }
        }
    }

    public Collection<Seat> getSeats(){
        return seats;
    }

    public class Seat implements Comparable<Seat>{
        private final String seatNumber;
        private double price;
        private boolean isReserved;

        public Seat(String seatNumber, double price) {
            this.seatNumber = seatNumber;
            this.price = price;
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

        public double getPrice() {
            return price;
        }

        public boolean isReserved() {
            return isReserved;
        }
    }
}
