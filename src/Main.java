import model.Student;
import service.Interact;
import tools.FileOperation;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        /*Print.mainScreen();
        Print.inputStudent();
        String read = Input.getInput();
        GetStudent getStudent = new GetStudent();
        while (!getStudent.checkFormat(read)) {
            Print.inputCorrectStudent();
            read = Input.getInput();
        }*/
        Interact interact = new Interact();
        interact.chooseTodo();
        FileOperation fileOperation = new FileOperation();
        List<Student> students = fileOperation.readFromFile();
        System.out.println(students.get(0).getAverage());
    }
}
