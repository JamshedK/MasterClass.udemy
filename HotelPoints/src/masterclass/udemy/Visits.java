package masterclass.udemy;

public class Visits {
    private String hotelCode;
    private int days;

    public Visits(String hotelCode, int days) {
        this.hotelCode = hotelCode;
        this.days = days;
    }

    public int getDays() {
        return days;
    }

    public String getHotelCode() {
        return hotelCode;
    }
}
