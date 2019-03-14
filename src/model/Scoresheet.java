package model;

import java.util.List;

public class Scoresheet {
    private List<Student> students;
    private double sumAverage;
    private double sumMedian;

    public Scoresheet(List<Student> students, double sumAverage, double sumMedian) {
        this.students = students;
        this.sumAverage = sumAverage;
        this.sumMedian = sumMedian;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public double getSumAverage() {
        return this.sumAverage;
    }

    public void setSumAverage(double sumAverage) {
        this.sumAverage = sumAverage;
    }

    public double getSumMedian() {
        return this.sumMedian;
    }

    public void setSumMedian(double sumMedian) {
        this.sumMedian = sumMedian;
    }
}
