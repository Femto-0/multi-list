import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class GUI extends JFrame {

    private Listener listener; // add listener reference
    JButton viewX;
    JButton viewY;
    JButton viewZ;
    JButton add;
    JButton exit;
    JTextArea txtArea;
    JScrollPane scrollPane;


    // Add to GUI

    public GUI(DataManager dm) throws FileNotFoundException {
        JFrame frame = new JFrame("Multi-list");
        listener = new Listener(dm, this);
        frame.getContentPane().setLayout(new FlowLayout());
        // Initialize buttons
        viewX = new JButton("View X");
        viewY = new JButton("View Y");
        viewZ = new JButton("View Z");
        add = new JButton("Add Point");
        exit = new JButton("Exit");
        txtArea = new JTextArea(20, 20);
        scrollPane = new JScrollPane(txtArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Add action listeners
        viewX.addActionListener(listener);
        viewY.addActionListener(listener);
        viewZ.addActionListener(listener);
        add.addActionListener(listener);
        exit.addActionListener(listener);

        // Add buttons to JFrame
        frame.setVisible(true);
        frame.setSize(300, 500);
        frame.add(viewX);
        frame.add(viewY);
        frame.add(viewZ);
        frame.add(add);
        frame.add(exit);
        frame.getContentPane().add(scrollPane);

    }
}