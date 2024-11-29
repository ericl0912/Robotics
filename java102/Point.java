package java102;
public class Point {

    
    private double x;
    private double y;

   
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    
    public double getX() {
        return x;
    }


    public double getY() {
        return y;
    }

    
    public static Point centerOfMass(Point[] points) {
        if (points == null || points.length == 0) {
            throw new IllegalArgumentException("The array of points must not be null or empty.");
        }

        double sumX = 0;
        double sumY = 0;

      
        for (Point p : points) {
            sumX += p.getX();
            sumY += p.getY();
        }

       
        double avgX = sumX / points.length;
        double avgY = sumY / points.length;

       
        return new Point(avgX, avgY);
    }

   

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

   
}
//practice 2
package java102;

public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double angle() {
        double angleInRadians = Math.atan2(y, x);
        return Math.toDegrees(angleInRadians);
    }
}
//practice 3
public ArrayList<T> diagonal();
public class Grid<T> {
    private T[][] grid;
    private static int maxSideLength = 0;

    public Grid(T[][] grid) {
        this.grid = grid;
        int rows = grid.length;
        int cols = grid[0].length;
        int sideLength = Math.max(rows, cols);
        if (sideLength > maxSideLength) {
            maxSideLength = sideLength;
        }
    }

    public static int maxSideLength() {
        return maxSideLength;
    }
}
//practice 4
package java102;
import java.util.ArrayList;
public class Grid {
    private final int sideLength;
    private final ArrayList<ArrayList<Integer>> gridData;

    
    private static int maxSideLength = 0;

    public Grid(int sideLength) {
        this.sideLength = sideLength;
        this.gridData = new ArrayList<>();

        
        for (int i = 0; i < sideLength; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < sideLength; j++) {
                row.add(0);
            }
            gridData.add(row);
        }

        
        if (sideLength > maxSideLength) {
            maxSideLength = sideLength;
        }
    }

   
    public static int maxSideLength() {
        return maxSideLength;
    }


}
//practice 5
package java102;

public class Circle implements Shape {
    public final Point center;
    public final double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    public static Circle fromPoints(Point p1, Point p2, Point p3) {
        double x1 = p1.x, y1 = p1.y;
        double x2 = p2.x, y2 = p2.y;
        double x3 = p3.x, y3 = p3.y;

        double a = x1 * (y2 - y3) - y1 * (x2 - x3) + (x2 * y3 - x3 * y2);
        if (a == 0) throw new IllegalArgumentException("Points are collinear.");

        double x12 = x1 * x1 + y1 * y1;
        double x22 = x2 * x2 + y2 * y2;
        double x32 = x3 * x3 + y3 * y3;

        double centerX = (x12 * (y2 - y3) + x22 * (y3 - y1) + x32 * (y1 - y2)) / (2 * a);
        double centerY = (x12 * (x3 - x2) + x22 * (x1 - x3) + x32 * (x2 - x1)) / (2 * a);

        Point center = new Point(centerX, centerY);
        double radius = Point.distance(center, p1);
        return new Circle(center, radius);
    }
}
//practice 6
package java102;

public class RightTriangle implements Shape {
    private final Point corner;
    private final double base;
    private final double height;

    public RightTriangle(Point corner, double base, double height) {
        this.corner = corner;
        this.base = base;
        this.height = height;
    }

    public double area() {
        return 0.5 * base * height;
    }

    public double perimeter() {
        double hypotenuse = Math.sqrt(base * base + height * height);
        return base + height + hypotenuse;
    }

    public boolean isInside(Point p) {
        double xRel = p.x - corner.x;
        double yRel = p.y - corner.y;
        return xRel >= 0 && xRel <= base && yRel >= 0 && yRel <= height && xRel + yRel <= base + height;
    }

    public RightTriangle translate(double x, double y) {
        return new RightTriangle(new Point(corner.x + x, corner.y + y), base, height);
    }

    public RightTriangle scale(double k) {
        return new RightTriangle(corner, base * k, height * k);
    }

    public static boolean similar(RightTriangle t1, RightTriangle t2) {
        double ratio1 = t1.base / t2.base;
        double ratio2 = t1.height / t2.height;
        return Math.abs(ratio1 - ratio2) < 1e-9;
    }

    @Override
    public String toString() {
        return "(corner: " + corner + ", base: " + base + ", height: " + height + ")";
    }
}
package java102;

public class Main {
    public static void returnAll(LibraryItem[] items) {
        for (LibraryItem item : items) {
            item.returnItem();
        }
    }
}

//practice 7
package java102;

public class LibraryItem {
    private boolean available;

    public LibraryItem(boolean available) {
        this.available = available;
    }

    public void returnItem() {
        this.available = true;
    }

    public boolean isAvailable() {
        return available;
    }

    @Override
    public String toString() {
        return "LibraryItem [available=" + available + "]";
    }
}
