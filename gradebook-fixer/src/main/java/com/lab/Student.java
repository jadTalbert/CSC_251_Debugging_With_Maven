package com.lab.gradebook;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String id;
    private String name;
    private List<Double> scores;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addScore(double score) {
        if (score >= 0.0 && score <= 100.0) {
            scores.add(score);
        }
    }

    public List<Double> getScores() {
        return scores;
    }

    public double calculateAverage() {
        if (scores == null || scores.isEmpty()) {
            return 0.0;
        }
        double sum = 0.0;
        for (double s : scores) {
            sum += s;
        }
        return sum / scores.size();
    }
}