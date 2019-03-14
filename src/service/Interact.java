package service;

import model.Scoresheet;
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
            }
        }
    }

    private Scoresheet printScoresheet() {
        Print.inputStudentId();
        String read = Input.getInput();
        GetScoresheet getScoresheet = new GetScoresheet();
        while (!getScoresheet.checkId(read)) {
            Print.inputCorrectId();
            read = Input.getInput();
        }
        Scoresheet scoresheet = getScoresheet.getSheet(read);
        Print.printScoresheet(scoresheet);
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
    }
}
