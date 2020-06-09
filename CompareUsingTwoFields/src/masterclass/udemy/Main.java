package masterclass.udemy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        School isak = new School("ISAK");

        isak.addStudent("Jamshed", 11);
        isak.addStudent("Christine", 10);
        isak.addStudent("Nadeem", 11);
        isak.addStudent("Brice", 12);
        isak.addStudent("Mehrimo", 11);
        isak.addStudent("Hamid", 10);

        printStudents(isak.getStudents());

        List<School.Student> copyOfStudentList = new ArrayList<>(isak.getStudents());
        Collections.sort(copyOfStudentList, School.SORT_DESCENDING);
        System.out.println("===========");
        printStudents(copyOfStudentList);

    }

    public static void printStudents(List<School.Student> list){
        for ( School.Student student : list){
            System.out.println(student.getName() + " " + student.getGrade());
        }
    }
}
