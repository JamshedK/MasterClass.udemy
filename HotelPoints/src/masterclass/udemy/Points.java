package masterclass.udemy;

import java.security.PublicKey;

public class Points {
    private String memberId;
    private int bonusPoints;
    private int totalPoints;
    String statusNow;
    String statusNextYear;
    private Visits [] allVisits = new Visits[366]; //details of each visit during the year
    private int y;  //number of visits this year

    public Points(String memberId) {
        this.memberId = memberId;
        bonusPoints = 0;
        y = 0;
        statusNow = "Bronze";
    }

    public Points(String memberId, int bonusPoints) {
        this.memberId = memberId;
        this.bonusPoints = bonusPoints; // multiples of 1000
        y = 0;
        statusNow = "Bronze";
    }

    public Visits getAllVisits(int visitNumber) {
        return allVisits[visitNumber];
    }

    public void addVisit(Visits visit){
        allVisits[y] = visit;
        y++;
    }

    public boolean isGold(){
      return (statusNow.equals("Gold"));
    }

    public int calculateTotalPoints(){
        int totalPoints = 0;
        totalPoints += bonusPoints;
        for(int i = 0; i < y; i++){
            totalPoints += getAllVisits(i).getDays() * 1000;
        }
        return totalPoints;
    }

    public int daysMissing(){
        int pointsMissing = 0;

        if(isGold()){
            pointsMissing = 50_000 - calculateTotalPoints();
        }

        else if(statusNow.equals("Silver")){
            pointsMissing = 10_000 - calculateTotalPoints();
        }
        if(pointsMissing < 0){
            return 0;
        }
        return pointsMissing/1000;
    }

    public String getMemberId() {
        return memberId;
    }

    public int getBonusPoints() {
        return bonusPoints;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public String getStatusNow() {
        return statusNow;
    }

    public void setStatusNow(String statusNow) {
        this.statusNow = statusNow;
    }

    public String getStatusNextYear() {
        return statusNextYear;
    }

    public int getY() {
        return y;
    }
}
