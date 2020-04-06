package masterclass.udemy;

import java.util.ArrayList;

public class Bank {
   private String bankName;
   private ArrayList<Branch> branchList;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.branchList = new ArrayList<>();
    }

    public void addBranch(String branchName){
        if(findBranch(branchName) == null){
            branchList.add(new Branch(branchName));
        }
        else{
            System.out.println("Branch with name " + branchName + " already exists");
        }
    }

    public void printCustomerList(String branchName, boolean showTransactions){
        Branch branch = findBranch(branchName);
        if(branch != null) {
            branch.printCustomersInfo(showTransactions);
        }
        else{
            System.out.println(" Branch does not exist");
        }
    }

    public void addCustomer(String branchName, String name, double initialTransAmount){
        Branch branch = findBranch(branchName);
        if(branch != null) {
            branch.addCustomer(name, initialTransAmount);
        }
        else{
            System.out.println("Branch does not exist");
        }
    }

    public void addTransaction(String branchName, String customerName, double amount){
        Branch branch = findBranch(branchName);
        if(branch != null) {
            branch.addTransaction(customerName, amount);
        }
        else{
            System.out.println(" Branch does not exist");
        }
    }

    private Branch findBranch(String branchName){
        for(int i = 0; i < branchList.size(); i++){
            Branch foundBranch = branchList.get(i);
            if(foundBranch.getBranchName().equalsIgnoreCase(branchName)){
                return foundBranch;
            }
        }
        return null;
    }

}
