package masterclass.udemy;

import java.util.ArrayList;
import java.util.Comparator;

public class School {
    private String schoolName;
    private ArrayList<Student> students = new ArrayList<>();

    public static final Comparator<Student> SORT_DESCENDING;

    static {
        SORT_DESCENDING = new Comparator<Student>() {
            @Override
            public int compare(Student student1, Student student2) {
                // if the name of student 1 is larger and his/her grade is larger -> return -1
                if (student1.getName().compareToIgnoreCase(student2.getName()) > 0) {
                    if (student1.getGrade() > student2.getGrade()) {
                        return -1;
                        // if his name is larger, but grade is smaller -> return 1
                    } else {
                        return 1;
                    }
                    // is the name of student 1 compared to students 2 is smaller and his grade is also smaller -> return 1
                } else if (student1.getName().compareToIgnoreCase(student2.getName()) < 0) {
                    if (student1.getGrade() < student2.getGrade()) {
                        return 1;
                        // is his name is smaller, but his grade is larger -> return - 1
                    } else {
                        return -1;
                    }
                    // if the names are equal, -> return 0
                } else {
                    return 0;
                }
            }
        };
    }

    public School(String schoolName) {
        this.schoolName = schoolName;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addStudent(String name, int grade){
        Student newStudent = new Student(name, grade);
        students.add(newStudent);
    }


    public class Student{
        private String name;
        private int grade;

        public Student(String name, int grade) {
            this.name = name;
            this.grade = grade;
        }

        public String getName() {
            return name;
        }

        public int getGrade() {
            return grade;
        }
    }
}
