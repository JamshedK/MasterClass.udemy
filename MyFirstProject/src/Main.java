import sun.jvm.hotspot.tools.SysPropsDumper;

import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        ContactManager contact = new ContactManager();
        Contact myNewContact = new Contact("Nadeem", "2020.nadeem.akbar@uwcisak.jp","0492080001");
        Contact myNewContact2 = new Contact("Christine", "2021.christine.john@uwcisak.jp","0492080001");
        Contact myNewContact3 = new Contact("Jamshed", "2020.jamshed.karimnazarov@uwcisak.jp","0492080001");

        contact.addContact(myNewContact);
        contact.addContact(myNewContact2);
        contact.addContact(myNewContact3);

        Contact result = contact.searchContact("Jamshed");
        System.out.println(result.getEmail());

        System.out.println("Enter your name");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        System.out.println("Your name is: " + name );

        System.out.println("Enter your fucking grade");
        Scanner scanner1 = new Scanner(System.in);
        int grade = scanner1.nextInt();

        if(grade>90){
            System.out.println("Damn boy, this is nuts");
        }
        else{
            System.out.println("You looser");
        }


    }
}
