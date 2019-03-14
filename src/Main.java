import service.Interact;
import tools.FileOperation;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileOperation fileOperation = new FileOperation();
        fileOperation.fileInit();
        Interact interact = new Interact();
        interact.chooseTodo();
    }
}
