package model;

import java.util.List;

public class Student {
    private String name;
    private String id;
    private List<Course> courses;

    public Student(String name, String id, List<Course> courses) {
        this.name = name;
        this.id = id;
        this.courses = courses;
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
}
