package masterclass.udemy;

import java.util.ArrayList;

public class Account {
    private String name;
    private int balance;
    private ArrayList<Integer> transactions;

    public Account(String name) {
        this.name = name;
        this.transactions = new ArrayList<>();
    }

    public void deposit(int amount){
        if(amount > 0){
            this.transactions.add(amount);
            balance+= amount;
            System.out.println(amount + " deposited. Balance is now " + this.balance);
        }
        else{
            System.out.println("Cannot withdraw negative amount");
        }
    }

    public int getBalance() {
        return balance;
    }

    public void withdraw(int amount){
        int withdrawAmount = - amount;
        if(withdrawAmount < 0){
            this.transactions.add(withdrawAmount);
            this.balance += withdrawAmount;
            System.out.println(amount + " withdrawn. Balance is now " + this.balance);
        }
    }
}
