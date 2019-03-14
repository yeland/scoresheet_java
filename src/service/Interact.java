package service;

import model.Scoresheet;
import model.Student;
import tools.FileOperation;
import tools.Input;
import tools.Print;

public class Interact {
    public void chooseTodo() {
        Print.mainScreen();
        int command = Integer.parseInt(Input.getInput());
        while (true) {
            switch (command) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    printScoresheet();
                    break;
                case 3:
                    return;
                default:
                    break;
            }
            Print.mainScreen();
            command = Integer.parseInt(Input.getInput());
        }
    }

    private void printScoresheet() {
        Print print = new Print();
        Print.inputStudentId();
        String read = Input.getInput();
        GetScoresheet getScoresheet = new GetScoresheet();
        while (!getScoresheet.checkId(read)) {
            Print.inputCorrectId();
            read = Input.getInput();
        }
        Scoresheet scoresheet = getScoresheet.getSheet(read);
        print.printScoresheet(scoresheet);
    }

    private void addStudent() {
        Print.inputStudent();
        GetStudent getStudent = new GetStudent();
        String read = Input.getInput();
        while (!getStudent.checkFormat(read)) {
            Print.inputCorrectStudent();
            read = Input.getInput();
        }
        FileOperation fileOperation = new FileOperation();
        fileOperation.writeToFile(read + "\n");
        Student student = getStudent.formatStudent(read);
        Print.addSuccess(student);
    }
}
