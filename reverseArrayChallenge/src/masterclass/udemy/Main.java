package masterclass.udemy;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int [] array = {12, 13, 14, 15};
        System.out.println("The original array:");
        System.out.println(Arrays.toString(array));

        reverse(array);
        System.out.println("The reversed array:");
        System.out.println(Arrays.toString(array));

    }

    public static void reverse(int [] array){
        // loop till half of the array
        for(int i = 0; i < array.length / 2; i ++){
            int temp = array[i];
            array[i] = array[(array.length -1) - i];
            array[(array.length -1) - i] = temp;
        }
    }
}
