package edu.mum.cs.cs425.demos.studentrecordsmgmtapp;

import edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model.Student;

import java.util.*;
import java.util.function.Predicate;

public class MyStudentRecordsMgmtApp {
    public static void main(String[] args) {
         ArrayList<Student> ArrayOfStudent =  new ArrayList<>();
         ArrayOfStudent.addAll(0, Arrays.asList(
                 new Student(110001,"Dave", new Date("11/18/1951")),
                 new Student(110002, "Anna", new Date("12/07/1990")),
                 new Student(110003,"Erica", new Date("01/31/1974")),
                 new Student(110004, "Carlos", new Date("08/22/2009")),
                 new Student(110005, "Bob", new Date("03/05/1990")))
         );
        System.out.println("================== \n");
        printListOfStudents(ArrayOfStudent);
        System.out.println("================== \n");
        getListOfPlatinumAlumniStudents(ArrayOfStudent);
        System.out.println("==================\n");
        int[] arr = {10, 14, 35, 8, 25, 49};
        printHelloWorld(arr);
        System.out.println("==================\n");
        int[] arr1 = {1, 2, 3, 4, 5};
        System.out.println(findSecondBiggest(arr1));

    }

    public static void printHelloWorld(int[] arr) {
        for (int num : arr) {
            if (num % 5 == 0 && num % 7 == 0) {
                System.out.println("HelloWorld");
            } else if (num % 5 == 0) {
                System.out.println("Hello");
            } else if (num % 7 == 0) {
                System.out.println("World");
            }
        }
    }

    public static void printListOfStudents(ArrayList<Student> items) {
        Collections.sort(items);
        items.forEach(System.out::println);
    }

    public static void getListOfPlatinumAlumniStudents(ArrayList<Student> items) {
        items.stream()
                .filter(x -> isPlatinumStudent(x))
                .sorted(Comparator.comparing(Student::getDateOfAdmission, Comparator.reverseOrder()))
                .forEach(System.out::println);
    }
    public static boolean isPlatinumStudent(Student s){
        return s.getDateOfAdmission().getYear() >= 30;
    }


    public static Integer findSecondBiggest(int[] arr) {
        if (arr.length < 2) {
            return null;  // No second largest element
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }

        if (secondLargest == Integer.MIN_VALUE) {
            return null;
        } else {
            return secondLargest;
        }
    }
}
