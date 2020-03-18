package masterclass.udemy;

public class Client {
    private int customerID;
    private String name;
    private Dates arrive;
    private Dates leave;
    private Room bedroom;

    public Client(int customerID, String name, Dates arrive, Dates leave, Room bedroom) {
        this.customerID = customerID;
        this.name = name;
        this.arrive = arrive;
        this.leave = leave;
        this.bedroom = bedroom;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dates getArrive() {
        return arrive;
    }

    public void setArrive(Dates arrive) {
        this.arrive = arrive;
    }

    public Dates getLeave() {
        return leave;
    }

    public void setLeave(Dates leave) {
        this.leave = leave;
    }

    public Room getBedroom() {
        return bedroom;
    }

    public void setBedroom(Room bedroom) {
        this.bedroom = bedroom;
    }

    public double calculateBills(){
        int totalDays = Dates.stayDays(getArrive(), getLeave());
        return getBedroom().getPrice()* totalDays;
    }
}
