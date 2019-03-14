package service;

import model.Scoresheet;
import model.Student;
import tools.FileOperation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GetScoresheet {
    public boolean checkId(String idStr) {
        List<String> ids = Arrays.asList(idStr.split(", "));
        return ids.size() > 0;
    }

    public Scoresheet getSheet(String idStr) {
        List<String> ids = Arrays.asList(idStr.split(", "));
        FileOperation fileOperation = new FileOperation();
        List<Student> students = fileOperation.readFromFile();
        List<Student> printStudents = students.stream()
                .filter(student -> ids.contains(student.getId()))
                .collect(Collectors.toList());
        return new Scoresheet(printStudents, computeSumAverage(students), computeSumMedian(students));
    }

    public double computeSumAverage(List<Student> students) {
        List<Integer> sums = students.stream().map(Student::getSum).collect(Collectors.toList());
        return sums.stream().collect(Collectors.averagingDouble(Integer::valueOf));
    }

    public double computeSumMedian(List<Student> students) {
        List<Integer> sums = students.stream().map(Student::getSum).collect(Collectors.toList());
        Collections.sort(sums);
        int left = (int) Math.floor((sums.size()-1)/2.0);
        int right = (int) Math.ceil((sums.size()-1)/2.0);
        return  (sums.get(left)+sums.get(right))/2.0;
    }
}
