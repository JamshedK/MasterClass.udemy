package masterclass.udemy;

import java.util.ArrayList;

public class Branch {
    private String branchName;
    private ArrayList<Customer> customersList;

    public Branch(String branchName) {
        this.branchName = branchName;
        this.customersList = new ArrayList<>();
    }

        // Add a new customer with initial transaction
        // data validation, make sure the customer does not exist already
    public void addCustomer(String customerName, double initialTransaction){
        Customer customer1 = new Customer(customerName, initialTransaction);
        if(findCustomer(customerName) != null){
            System.out.println("Customer with the given name already exists");
        }
        else{
            customersList.add(customer1);
            System.out.println("Customer " + customerName + " added successfully");
        }

    }

         // add transactions for an existing customer
        // check that the customer exists
    public void addTransaction(String customerName, double amount){
        Customer customer = findCustomer(customerName);
        if(customer != null){
            customer.addTransaction(amount);
            System.out.println("Added a new transaction with the amount of " + amount + "$");
        }
        else{
            System.out.println("Customer " + customerName + " in " + branchName + " branch does not exist");
        }
    }

    private Customer findCustomer(String name){
        for(int i = 0; i < customersList.size(); i++){
            Customer checkedCustomer = customersList.get(i);
            if(checkedCustomer.getCustomerName().equalsIgnoreCase(name)){
                return checkedCustomer;
            }
        }
        return null;
    }

        // show a list of customers and their transactions history
    public void printCustomersInfo(boolean showTransactions){
        System.out.println("Here are the details of the Customers of " + branchName + " branch");
        for(int i = 0; i < customersList.size(); i++){
            Customer customer = customersList.get(i);
            System.out.println((i + 1) + ". " + customer.getCustomerName());
            if(showTransactions) {
                customer.printTransactionHistory();
            }
        }
    }

    public String getBranchName() {
        return branchName;
    }
}
