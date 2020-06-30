package masterclass.udemy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMain {
    public static void main(String[] args) {
        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();

        for (int i = 1; i <= 100; i++){
            squares.add(i * i);
            cubes.add(i * i * i);
        }

        // union of two sets
        Set<Integer> union = new HashSet<>(squares);
        union.addAll(cubes);
        System.out.println("Union size " + union.size());

        // intersection of two sets
        Set<Integer> intersection = new HashSet<>(squares);
        intersection.retainAll(cubes);
        for (int i : intersection){
            System.out.println(Arrays.asList());
        }

        Set<String> words = new HashSet<>();
        String sentence = "one day in the year of fox";
        String [] array = sentence.split(" ");

        words.addAll(Arrays.asList(array));

        Set<String> nature = new HashSet<>();
        String [] arrayNatureWords = {"all", "nature", "unknown", "thee", "art", "but", "is", "to"}; // we can't initialize sets like this
        nature.addAll(Arrays.asList(arrayNatureWords));// to insert elements of the array to set as a list

        Set<String> divine = new HashSet<>();
        String [] arrayDivineWords = {"eer", "human", "forgive", "divine", "to", "is"};
        divine.addAll(Arrays.asList(arrayDivineWords));

        System.out.println("nature - divine");
        Set<String> diff1 = new HashSet<>(nature);
        diff1.removeAll(divine);
        printSet(diff1);

        System.out.println("divine - nature");
        Set<String> diff2 = new HashSet<>(divine);
        diff2.removeAll(nature);
        printSet(diff2);

        Set<String> tempUnion = new HashSet<>(nature);
        tempUnion.addAll(divine);

        Set<String> tempIntersection = new HashSet<>(nature);
        tempIntersection.retainAll(divine);

        System.out.println("Symmetric difference: union - intersection");
        tempUnion.removeAll(tempIntersection);
        printSet(tempUnion);

        //containts all method
        if(divine.containsAll(tempIntersection)){
            System.out.println("tempIntersection is a subset of divine");
        }
    }

    public static void printSet(Set<String> set){
        System.out.print("\t");
        for (String s : set){
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
