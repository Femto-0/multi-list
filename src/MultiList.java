import java.util.ArrayList;

public class MultiList {
    // Use ArrayLists to store points
    private ArrayList<Point> listX;
    private ArrayList<Point> listY;
    private ArrayList<Point> listZ;
    public ArrayList<Point> getListX() {
        return listX;
    }

    public ArrayList<Point> getListY() {
        return listY;
    }

    public ArrayList<Point> getListZ() {
        return listZ;
    }
    public MultiList() {
        listX = new ArrayList<>();
        listY = new ArrayList<>();
        listZ = new ArrayList<>();

    }

    // Add a new point
    public void addPointX(Point p) {
        listX.add(p);
    }
    public void addPointY(Point q) {
        listY.add(q);

    }
    public void addPointZ(Point r) {
        listZ.add(r);
    }
}