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