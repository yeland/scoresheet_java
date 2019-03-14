import model.Student;
import service.GetStudent;
import tools.Input;
import tools.Print;

public class Main {
    public static void main(String[] args) {
        Print.mainScreen();
        Print.inputStudent();
        String read = Input.getInput();
        GetStudent getStudent = new GetStudent();
        while (!getStudent.checkFormat(read)) {
            Print.inputCorrectStudent();
            read = Input.getInput();
        }
        Student student = getStudent.formatStudent(read);
        System.out.println(student.getAverage());
    }
}
