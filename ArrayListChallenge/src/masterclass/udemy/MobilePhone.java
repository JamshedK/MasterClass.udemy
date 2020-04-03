package masterclass.udemy;

import java.util.ArrayList;

public class MobilePhone {

    public  ArrayList <Contact> contactArrayList = new ArrayList<Contact>();

    public void print(){
        System.out.println("You have " + contactArrayList.size() + " contacts in your list");
        for(int i = 0; i < contactArrayList.size(); i++){
            System.out.println((i+1) +". " + contactArrayList.get(i).toString());
        }
    }

    public void addContact(Contact contact){
        if(getPosition(contact.getName()) >= 0) {
            System.out.println("The contact already exists");
        }
        else{
            contactArrayList.add(contact);
            System.out.println("new contact added with name " + contact.getName() + " and phone number " + contact.getPhoneNumber());
        }
    }


    public boolean updateContact(Contact oldContact, Contact newContact){
        int position = getPosition(oldContact.getName());
        System.out.println("Position of the contact is " + position);
       if(position >= 0){
           updateContact(position, newContact);
           System.out.println("Updated successfully");
           return true;
       }
       return false;
    }

    private void updateContact(int position, Contact newContact){
        contactArrayList.set(position, newContact);
    }

    private int getPosition(String name){
        for(int i = 0; i < contactArrayList.size(); i++){
            if(contactArrayList.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }

    public void removeContact(Contact contact){
        int position = getPosition(contact.getName());
        if(position >= 0){
            removeContact(position);
            System.out.println("Successfully remove " + contact.getName());
        }
    }

    private void removeContact(int position){
        contactArrayList.remove(position);
    }

    public void searchContact(Contact contact){
        int position = getPosition(contact.getName());
        if(position >= 0){
            System.out.println(contactArrayList.get(position).toString());
        }
    }

    public Contact returnContact(String name){
        int position = getPosition(name);
        if(position >= 0){
            return contactArrayList.get(position);
        }
        return null;
    }

}
