package com.aarya.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ComparatorTest {
    static class Student {
        String name;
        int id;
        double gpa;

        Student(String n, int i) {
            name = n;
            id = i;
        }

        Student(String n, int i, double g) {
            id = i;
            gpa = g;
            name = n;
        }

        public String toString() {
            return String.format("[Student %d: %s]", id, name);
        }
    }

    static class StudentComparator implements Comparator<Student> {

        @Override
        public int compare(ComparatorTest.Student o1, ComparatorTest.Student o2) {
            if (o1.id > o2.id) {
                return 1;
            } else if (o1.id < o2.id) {
                return -1;
            }
            return 0;
        }

    }

    public static void test() {
        List<Student> students = new LinkedList<>();
        students.add(new Student("mark", 2));
        students.add(new Student("john", 1));
        students.add(new Student("sifat", 3));
        Collections.sort(students, new StudentComparator());
        System.out.println(Arrays.toString(students.toArray()));
    }

    public static void main(String[] args) {
        int a = 07;
        System.out.println(a);
    }
}
