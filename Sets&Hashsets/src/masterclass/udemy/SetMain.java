package masterclass.udemy;

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

    }
}
