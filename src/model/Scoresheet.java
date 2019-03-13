package model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Scoresheet {
    private List<Student> students;
    private double sumAverage;
    private double sumMedian;

    public Scoresheet(List<Student> students) {
        this.students = students;
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
        List<Integer> sums = students.stream().map(Student::getSum).collect(Collectors.toList());
        this.sumAverage = sums.stream().collect(Collectors.averagingDouble(Integer::valueOf));
    }

    public double getSumMedian() {
        return this.sumMedian;
    }

    public void setSumMedian(double sumMedian) {
        List<Integer> sums = students.stream().map(Student::getSum).collect(Collectors.toList());
        Collections.sort(sums);
        int left = (int) Math.floor((sums.size()-1)/2.0);
        int right = (int) Math.ceil((sums.size()-1)/2.0);
        this.sumMedian = (sums.get(left)+sums.get(right))/2.0;
    }
}
