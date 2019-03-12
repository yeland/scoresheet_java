package service;

import model.Course;
import model.Student;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GetStudent {
    public boolean checkFormat(String input) {
        String[] studentInfo = input.split(", ");
        if (studentInfo.length <= 2) {
            return false;
        }
        for (int i = 2; i < studentInfo.length; i++) {
            String[] courses = studentInfo[i].split(": ");
            if (courses.length != 2) {
                return false;
            }
        }
        return true;
    }

    public Student formatStudent(String input) {
        String[] studentInfo = input.split(", ");
        List<Course> courses = formatCourses(studentInfo);
        return new Student(studentInfo[0], studentInfo[1], courses);
    }

    private List<Course> formatCourses(String[] studentInfo) {
        List<String> studentCourses = Arrays.asList(studentInfo).subList(2, studentInfo.length);
        return studentCourses.stream().map(string -> {
            String[] attr = string.split(": ");
            return new Course(attr[0], Integer.parseInt(attr[1]));
        }).collect(Collectors.toList());
    }
}
