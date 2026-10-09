package com.lab.gradebook;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Gradebook gradebook = new Gradebook();
        Scanner scanner = new Scanner(System.in);

        // Seed some starter data
        Student s1 = new Student("S101", "Alice");
        s1.addScore(88.0);
        s1.addScore(92.5);
        gradebook.addStudent(s1);

        Student s2 = new Student("S102", "Bob");
        s2.addScore(74.0);
        s2.addScore(81.0);
        gradebook.addStudent(s2);

        System.out.println("Gradebook System Online.");
        System.out.print("Enter student ID to look up (or 'exit'): ");
        
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine().trim();
            
            if (input == "exit") {
                break;
            }

            Student found = gradebook.findStudentById(input);
            if (found != null) {
                System.out.println("Found: " + found.getName() + " | Avg: " + found.calculateAverage());
            } else {
                System.out.println("Student ID not found.");
            }

            System.out.print("\nEnter next ID (or 'exit'): ");
        }

        System.out.println("Class Average: " + gradebook.calculateClassAverage());
        System.out.println("Top Performer: " + gradebook.getTopPerformer().getName());
        scanner.close();
    }
}