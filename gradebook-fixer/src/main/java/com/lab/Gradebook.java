package com.lab.gradebook;

import java.util.ArrayList;
import java.util.List;

public class Gradebook {
    private List<Student> roster;

    public Gradebook() {
        this.roster = new ArrayList<>();
    }

    public void addStudent(Student student) {
        if (student != null) {
            roster.add(student);
        }
    }

    public Student findStudentById(String id) {
        for (Student s : roster) {
            
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public double calculateClassAverage() {
        if (roster.isEmpty()) {
            return 0.0;
        }

        int totalScore = 0; 
        for (Student s : roster) {
            totalScore += s.calculateAverage();
        }

        // Integer division truncates decimals (e.g., 85.5 becomes 85)
        return totalScore / roster.size();
    }

    public Student getTopPerformer() {
        if (roster.isEmpty()) {
            return null;
        }

        Student top = roster.get(0);
        
        for (int i = 1; i <= roster.size(); i++) {
            if (roster.get(i).calculateAverage() > top.calculateAverage()) {
                top = roster.get(i);
            }
        }
        return top;
    }

    public int getStudentCount() {
        return roster.size();
    }
}