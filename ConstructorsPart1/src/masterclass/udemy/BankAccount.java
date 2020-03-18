package masterclass.udemy;

public class BankAccount {
    private int number;
    private double balance;
    private String customerName;
    private String email;
    private String phoneNumber;

    public int getNumber() {
        return number;
    }

    public void setNumber(int accountNumber) {
        this.number = accountNumber;
    }

    public BankAccount() {
        this(546, 12.0, "Default Name", "Default email address", "Default phone number");
    }

    public BankAccount(int number, double balance, String customerName, String email, String phoneNumber) {
        this.number = number;
        this.balance = balance;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void depositMoney(double amount){
        balance += amount;
        System.out.println( amount + " was deposited, and the current balance is " + balance);
    }

    public void withdrawMoney(double amount){
        if(balance - amount < 0){
            System.out.println("Insufficient fund");
        }
        balance -= amount;
        System.out.println("The amount withdrawn is " + amount + " , the current balance is " + balance);
    }
}
