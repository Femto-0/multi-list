import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DataManager {

    private MultiList list;


    private String filePath= "src/points.txt";

    public DataManager() throws FileNotFoundException {
        list = new MultiList();
    readFile(filePath); //read the txt file and populate the multi list in MultiList class.
    }
    public void readFile(String fileName) throws FileNotFoundException {
        // Read input file and populate list
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] arr = line.split("\\s");
            // Parse line to get x, y, z
            int x = Integer.parseInt(arr[0]);
            int y = Integer.parseInt(arr[1]);
            int z = Integer.parseInt(arr[2]);

            Point p = new Point(x, y, z);
            Point q = new Point(y, x, z);
            Point r = new Point(z, x, y);
            list.addPointX(p);
            list.addPointY(q);
            list.addPointZ(r);
        }
    }


    public void addPointFromUser(Point p) throws IOException {
        // Update data file
        BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true));
        bw.append(String.valueOf(p.getX())).append(" ").append(String.valueOf(p.getY())).append(" ").append(String.valueOf(p.getZ()));
        bw.newLine();
        bw.close();
    }

    public ArrayList<Point> viewByX() throws FileNotFoundException {
        list.getListX().clear();
        readFile(filePath);
      return list.getListX();
    }

    public ArrayList<Point> viewByY() throws FileNotFoundException {
        list.getListY().clear();
        readFile(filePath);
       return list.getListY();
    }

    public ArrayList<Point> viewByZ() throws FileNotFoundException {
        list.getListZ().clear();
        readFile(filePath);
        return list.getListZ();
    }

}
