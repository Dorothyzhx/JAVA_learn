package algorithm.section1;

import java.util.Arrays;
import java.util.Comparator;

public class Comparators {
    public static class Student{
        public String name;
        public int id;
        public int age;

        public Student(String name, int id, int age){
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }

    public static class IdAscendingComparator implements Comparator<Student> {

        @Override
        public int compare(Student s1, Student s2) {
            return s1.id - s2.id;
        }
    }

    public static class IdDescendingComparator implements Comparator<Student>{

        @Override
        public int compare(Student s1, Student s2) {
            return s2.id - s1.id;
        }
    }

    public static class AgeAscendingComparator implements Comparator<Student>{

        @Override
        public int compare(Student s1, Student s2) {
            return s1.age - s2.age;
        }
    }

    public static class AgeDescendingComparator implements Comparator<Student>{

        @Override
        public int compare(Student s1, Student s2) {
            return s2.age - s1.age;
        }
    }

    public static void printStudents(Student[] students){
        for (Student student : students)
            System.out.println("Name: " + student.name + "; Id: " + student.id + "; Age:" + student.age);
        System.out.println("===================================");
    }

    public static void main(String[] args){
        Student A = new Student("A", 12, 42);
        Student B = new Student("B", 423, 23);
        Student C = new Student("C", 5, 24);

        Student[] students = new Student[] {C, B, A};
        printStudents(students);

        Arrays.sort(students, new IdAscendingComparator());
        printStudents(students);

        Arrays.sort(students, new IdDescendingComparator());
        printStudents(students);

        Arrays.sort(students, new AgeAscendingComparator());
        printStudents(students);

        Arrays.sort(students, new AgeDescendingComparator());
        printStudents(students);
    }
}
