package masterclass.udemy;

public class Main {

    public static void main(String[] args) {
	    int switchValue = 4;
	    switch (switchValue){
            case 1:
                System.out.println("The value is 1");
                break;
            case 2:
                System.out.println("The value is 2");
                break;
            case 3: case 4: case 5:
                System.out.println("The value is either 3, 4 or 5");
                break;
            default:
                System.out.println("Neither 1 nor 2");
                break;
        }

        // Challenge
        // do the same thing, but using a different data type

        char newCharVariable = 'B';
	    switch (newCharVariable){
            case 'A':
                System.out.println("The char value is A");
                break;
            case 'B': case 'C': case 'D': case 'E':
                System.out.println("The char value is " + newCharVariable);
                break;
            default:
                System.out.println("Neither");
                break;
        }

        // challenge using String

        String dayOfTheWeek = "Tuesday";
	    switch (dayOfTheWeek.toLowerCase()){
            case "monday": case "tuesday": case "wednesday":
                System.out.println("It's " + dayOfTheWeek);
                break;
        }
    }
}
