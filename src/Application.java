import javax.swing.*;
import java.io.FileNotFoundException;

public class Application {
    public static void main(String[] args) throws FileNotFoundException, FileNotFoundException {

        // Create MVC objects
        DataManager model = new DataManager();
        GUI view = new GUI(model);
        Listener controller = new Listener(model, view);

        // Launch GUI
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.pack();
    }
}
