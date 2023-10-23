import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class Listener implements ActionListener {
    private DataManager dm;
    private GUI gui;

    public Listener(DataManager dm, GUI gui) {
        this.dm = dm;
        this.gui = gui;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gui.viewX) {
            ArrayList<Point> points = dm.viewByX();
            gui.txtArea.append("---------View by X----------"+"\n"); //update UI
            for (Point p : points) {
                gui.txtArea.append(p.getX()+" "+ p.getY()+" "+ p.getZ()+"\n");
            }
        } else if (e.getSource() == gui.viewY) {
            ArrayList<Point> points = dm.viewByY();

            gui.txtArea.append("--------View by Y-----------"+"\n");
            for (Point p : points) {
                gui.txtArea.append(p.getX()+" "+ p.getY()+" "+ p.getZ()+"\n");
            }
        } else if (e.getSource() == gui.viewZ) {
            ArrayList<Point> points = dm.viewByZ();

            gui.txtArea.append("-------------View by Z--------"+"\n");
            for (Point p : points) {
                 gui.txtArea.append(p.getX()+" "+ p.getY()+" "+ p.getZ()+"\n");
            }
        } else if (e.getSource() == gui.add) {
            // Show add point dialog
            Point p = getPointFromUser();
            try {
                if (p != null) {
                    dm.addPointFromUser(p);
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } else if (e.getSource() == gui.exit) {
            System.exit(0);
        }
    }

    private Point getPointFromUser() {

        JTextField xField = new JTextField(5);
        JTextField yField = new JTextField(5);
        JTextField zField = new JTextField(5);

        JPanel panel = new JPanel();
        panel.add(new JLabel("X:"));
        panel.add(xField);
        panel.add(new JLabel("Y:"));
        panel.add(yField);
        panel.add(new JLabel("Z:"));
        panel.add(zField);

        int result = JOptionPane.showConfirmDialog(null, panel,
                "Please Enter Point", JOptionPane.OK_CANCEL_OPTION);
        int x = 0, y = 0, z = 0;

        if (result == JOptionPane.OK_OPTION) {
            if (xField != null && yField != null && zField != null) {
                x = Integer.parseInt(xField.getText());
                y = Integer.parseInt(yField.getText());
                z = Integer.parseInt(zField.getText());

            } else {
                JOptionPane.showMessageDialog(null, "One of the field is empty", "information", JOptionPane.INFORMATION_MESSAGE);
            }

        } else {
            return null;
        }
        return new Point(x, y, z);
    }
}
