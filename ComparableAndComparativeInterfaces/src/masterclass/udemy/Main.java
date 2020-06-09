package masterclass.udemy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Theatre theatre = new Theatre("Pushkin", 8, 12);
        theatre.reserveSeat("D12");
        theatre.cancelReservation("A01");
        theatre.reserveSeat("A01");
        theatre.reserveSeat("A201");

        List<Theatre.Seat> reverseSeat = new ArrayList<>(theatre.getSeats());
        Collections.reverse(reverseSeat);
        printList(reverseSeat);

        List<Theatre.Seat> orderedByPrice = new ArrayList<>(theatre.getSeats());
        Collections.sort(orderedByPrice, Theatre.PRICE_ORDER_DECREASING);
        printList(orderedByPrice);

    }

    public static void printList(List<? extends Theatre.Seat> list){
        for (Theatre.Seat seat: list){
            System.out.print(seat.getSeatNumber() + "-" + seat.getPrice() + "$ , ");
        }
        System.out.println();
        System.out.println("===============================");
    }

}
