package masterclass.udemy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Theatre theatre = new Theatre("Pushkin", 8, 12);
//        theatre.getSeats();
//        theatre.reserveSeat("D12");
//        theatre.cancelReservation("A01");
//        theatre.reserveSeat("A01");
//        theatre.reserveSeat("A201");

        List<Theatre.Seat> seatCopy = new ArrayList<>(theatre.seats);
        printList(seatCopy);

        seatCopy.get(0).reserve();
        printList(seatCopy);
        Collections.shuffle(seatCopy);
        theatre.reserveSeat("A02");
        printList(seatCopy);
        sortList(seatCopy);
        System.out.println("the value is " + seatCopy.get(seatCopy.size() - 1).getSeatNumber());
        printList(seatCopy);

//        Theatre.Seat minSeat = Collections.min(seatCopy);
//        System.out.println(minSeat.getSeatNumber());
//        Theatre.Seat maxSeat = Collections.max(seatCopy);
//        System.out.println(maxSeat.getSeatNumber());
//
//        System.out.println("===============================");
//
//        Collections.reverse(seatCopy);
//        seatCopy.remove(0);
//        printList(seatCopy);
//        printList(theatre.seats);

    }

    public static void printList(List<Theatre.Seat> list){
        for (Theatre.Seat seat: list){
            System.out.print(seat.getSeatNumber() + " ");
        }
        System.out.println();
        System.out.println("===============================");
    }

    public static void sortList(List<? extends Theatre.Seat> list){
        for(int i = 0; i < list.size(); i ++){
            // j < list.size() - i - 1, because of (j + 1)
            for (int j = 0; j < list.size() - i - 1; j++ ){
                if (list.get(j).getSeatNumber().compareTo(list.get(j + 1).getSeatNumber()) > 0){
                    Collections.swap(list, j, j+1);
                }
            }
        }
    }
}
