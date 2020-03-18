package masterclass.udemy;

public class Main {

    public static void main(String[] args) {
        BankAccount backAccount = new BankAccount();
        backAccount.setBalance(200);
        backAccount.depositMoney(100);
        backAccount.withdrawMoney(150);
        backAccount.withdrawMoney(300);

        VipCustomer jamshed = new VipCustomer();
        System.out.println(jamshed.getCreditLimit());
        System.out.println(jamshed.getEmailAddress());
    }
}
