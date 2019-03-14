package service;

import model.Student;
import tools.Input;
import tools.Print;

import java.util.ArrayList;
import java.util.List;

public class Interact {
    public void chooseTodo() {
        List<Student> students = new ArrayList<>();
        Print.mainScreen();
        int command = Integer.parseInt(Input.getInput());
        while (true) {
            switch (command) {
                case 1: addStudent(students);
            }
        }
    }

    private void addStudent(List<Student> students) {
        Print.inputStudent();
        GetStudent getStudent = new GetStudent();
        String read = Input.getInput();
        while (!getStudent.checkFormat(read)) {
            Print.inputCorrectStudent();
            read = Input.getInput();
        }
        Student student = getStudent.formatStudent(read);
        students.add(student);
        //写入文件
    }
}
