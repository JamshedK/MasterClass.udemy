package masterclass.udemy;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone();

    public static void main(String[] args) {
        printInstructions();
        boolean quit = false;
        while (!quit){
            System.out.println("Enter your choice");
            int input = scanner.nextInt();
            scanner.nextLine();
            switch (input){
                case 0:
                    printInstructions();
                    break;
                case 1:
                    mobilePhone.print();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    remove();
                    break;
                case 5:
                    search();
                    break;
                case 6:
                    quit = true;
                    break;
                default:
                    System.out.println("Enter the correct number");
            }
        }
    }

    private static void printInstructions(){
        System.out.println("Press");
        System.out.println("\t 0 - print instructions");
        System.out.println("\t 1 - print Contact list");
        System.out.println("\t 2 - add a new contact");
        System.out.println("\t 3 - update existing contact");
        System.out.println("\t 4 - remove contact");
        System.out.println("\t 5 - search contact");
        System.out.println("\t 6 - quit");
    }

    private static void addContact(){
        System.out.println("Enter the name");
        String name = scanner.nextLine();

        System.out.println("Enter phone number");
        String phoneNumber = scanner.nextLine();

        Contact contact = Contact.createContact(name, phoneNumber);
        mobilePhone.addContact(contact);
    }

    private static void update(){
        System.out.println("Enter the name you would like to update");
        String name = scanner.nextLine();
        Contact oldContact = mobilePhone.returnContact(name);
        if(mobilePhone.returnContact(name) == null){
            System.out.println("Contact does not exist");
            return;
        }
        System.out.println("Enter the new name");
        String newName = scanner.nextLine();

        System.out.println("Enter the new phoneNumber");
        String newPhoneNUmber = scanner.nextLine();

        Contact newContact = Contact.createContact(newName, newPhoneNUmber);
        mobilePhone.updateContact(oldContact, newContact);
    }

    private static void remove(){
        System.out.println("Remove contacts");
        System.out.println("Enter the name");
        String name = scanner.nextLine();

        Contact contact = mobilePhone.returnContact(name);
        if(contact != null){
            mobilePhone.removeContact(contact);
        }
        else{
            System.out.println("Contact does not exist");
        }
    }

    private static void search(){
        System.out.println("Search contacts");
        System.out.println("Enter the name");
        String name = scanner.nextLine();
        Contact contact = mobilePhone.returnContact(name);
        if(contact != null){
            mobilePhone.searchContact(contact);
        }
        else{
            System.out.println("Contact does not exist");
        }
    }
}
