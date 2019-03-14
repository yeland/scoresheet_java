package service;

import model.Scoresheet;
import model.Student;
import tools.FileOperation;

import java.util.Arrays;
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
        return new Scoresheet(printStudents);
    }
}
