package masterclass.udemy;

public class Main {

    public static void main(String[] args) {
        Bank alifCapital = new Bank("alif");

        alifCapital.addBranch("Khujand");
        alifCapital.addBranch("Dushanbe");
        alifCapital.addBranch("Dushanbe");

        alifCapital.addCustomer("Khujand", "Jamshed", 45);
        alifCapital.addCustomer("Khujand", "Farshed", 89);
        alifCapital.addCustomer("Khujand", "Madina", 100);
        alifCapital.addCustomer("Khujand", "jamshed", 89);

        alifCapital.addCustomer("Dushanbe", "Shamsullo", 75);
        alifCapital.addCustomer("Dushanbe", "Manzarshoh", 150);

        alifCapital.addTransaction("Khujand", "Jamshed", 100);
        alifCapital.addTransaction("dushanbe", "Shamsullo", 100);
        alifCapital.addTransaction("Khujand", "Shamsullo", 100);
        alifCapital.addTransaction("Dushanbe", "Jamshed", 89);

        alifCapital.printCustomerList("Dushanbe",  true);
        alifCapital.printCustomerList("Khujand", true);
    }
}
