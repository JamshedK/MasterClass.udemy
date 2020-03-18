package masterclass.udemy;

import java.awt.*;

public class Main {

    public static Points [] allPoints = new Points[10000];

    public static Hotel [] allHotels = new Hotel[100];

    public static void main(String[] args) {


        allPoints[0] = new Points("m100");
        allPoints[1] = new Points("m101",5000);
        allPoints[2] = new Points("m102",2000);

        Visits v1 = new Visits("h003", 3);
        Visits v2 = new Visits("h013", 1);
        Visits v3 = new Visits("h013", 2);
        Visits v4 = new Visits("h005", 6);

        allPoints[0].addVisit(v1);
        allPoints[0].addVisit(v2);
        allPoints[0].addVisit(v3);
        allPoints[0].addVisit(v4);
        allPoints[1].addVisit(v1);
        allPoints[1].addVisit(new Visits("h004",6));

        System.out.println(allPoints[2].getMemberId());
        System.out.println(allPoints[0].getBonusPoints());
        System.out.println(allPoints[1].getAllVisits(1).getDays());

        System.out.println("total points of the client " + allPoints[1].getMemberId() + " is " + allPoints[1].calculateTotalPoints());

        allPoints[1].setStatusNow("Gold");

        System.out.println(allPoints[1].daysMissing());

        allHotels[0] = new Hotel("h100");
        allHotels[1] = new Hotel("h101");
        allHotels[2] = new Hotel("h102");
        allHotels[3] = new Hotel("h103");

    }

    public static String hotelNameWithMaxDays(String memberId){
        // find the array of allPoints object where allPoints[i].getMemberId equals memberId
        int maxDay = 0;

        for(int i = 0; i < allPoints.length; i ++){
            if(allPoints[i].getMemberId().equals(memberId)){
                for(int j =0; i < allPoints[i].getY(); i++){
                    if()
                }
            }
        }
        // find the longest visit / loop through visits arrays
        // get the hotelCode of the longest Visit


    }
}
