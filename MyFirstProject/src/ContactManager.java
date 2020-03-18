public class ContactManager {

   private Contact myFriends [];
   private int friendCount;

   public ContactManager(){
        friendCount = 0;
        myFriends = new Contact[700];
    }

    public void addContact(Contact contact){
       myFriends[friendCount] = contact;
       friendCount++;
    }

    public Contact searchContact(String searchname){
       for(int i =0; i<myFriends.length; i++){
           if(myFriends[i].getName().equals(searchname)){
               return myFriends[i];
           }
       }
       return null;
    }
}
