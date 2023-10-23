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

    public GUI(DataManager dm ) throws FileNotFoundException {
JFrame frame = new JFrame();
        listener = new Listener(dm, this);
        LayoutManager flowLayout= new FlowLayout();
        setLayout(flowLayout);
        // Initialize buttons
        viewX = new JButton("View X");
        viewY = new JButton("View Y");
        viewZ = new JButton("View Z");
        add = new JButton("Add Point");
        exit = new JButton("Exit");
        txtArea= new JTextArea(20,20);
        scrollPane= new JScrollPane(txtArea);


        // Add action listeners
        viewX.addActionListener(listener);
        viewY.addActionListener(listener);
        viewZ.addActionListener(listener);
        add.addActionListener(listener);
        exit.addActionListener(listener);

        // Add buttons to JFrame
        add(viewX);
        add(viewY);
        add(viewZ);
        add(add);
        add(exit);
        add(txtArea);
        frame.add(scrollPane);

    }
}