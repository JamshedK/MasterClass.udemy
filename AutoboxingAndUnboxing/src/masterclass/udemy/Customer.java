package masterclass.udemy;

import java.util.ArrayList;

public class Customer {
    private String customerName;
    private ArrayList<Double> transactionsList;

    public Customer(String customerName, double initialTransAmount) {
        this.customerName = customerName;
        this.transactionsList = new ArrayList<>();
        this.transactionsList.add(initialTransAmount);
    }

    public String getCustomerName() {
        return customerName;
    }
        // autoboxing
    public void addTransaction(double amount){
        transactionsList.add(amount);
    }
        //unboxing
    public void printTransactionHistory(){
        System.out.println("Transaction history");
        for(int i = 0; i < transactionsList.size(); i++){
            System.out.println("\t" + (i+1) + ". " + transactionsList.get(i) + "$");
        }
    }
}
