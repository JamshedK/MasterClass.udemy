package masterclass.udemy;

public class Main {

    public static void main(String[] args) {
        Account jamshedsAccount = new Account("Jamshed");
        jamshedsAccount.deposit(1000);
        jamshedsAccount.withdraw(200);
        jamshedsAccount.deposit(-100);
        System.out.println(jamshedsAccount.getBalance());
    }
}
