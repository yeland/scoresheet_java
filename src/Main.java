import service.Interact;
import tools.FileOperation;

public class Main {
    public static void main(String[] args) {
        FileOperation fileOperation = new FileOperation();
        fileOperation.fileInit();
        Interact interact = new Interact();
        interact.chooseTodo();
    }
}
