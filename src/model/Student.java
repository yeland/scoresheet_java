package model;

import java.util.List;
import java.util.stream.Collectors;

public class Student {
    private String name;
    private String id;
    private List<Course> courses;
    private int sum;
    private double average;

    public Student(String name, String id, List<Course> courses) {
        this.name = name;
        this.id = id;
        this.courses = courses;
        setSum();
        setAverage();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Course> getCourses() {
        return this.courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public int getSum() {
        return this.sum;
    }

    public void setSum() {
        List<Integer> scores = courses.stream().map(Course::getScore).collect(Collectors.toList());
        this.sum = scores.stream().mapToInt(Integer::valueOf).sum();
    }

    public double getAverage() {
        return this.average;
    }

    public void setAverage() {
        this.average = this.sum/(double)courses.size();
    }
}
