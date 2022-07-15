import static java.lang.Math.sqrt;

public class Sierpinski {
    // Finds the height of an equilateral triangle based on its side length
    public static double height(double length) {
        double height = length * sqrt(3) / 2;
        return height;
    }

    // Draws a filled-in equilateral triangle based on it bottom vertex coordinates and its side length
    public static void filledTriangle(double x, double y, double length) {
        double[] tx = { x, x + (length / 2), x - (length / 2) };
        double[] ty = { y, y + height(length), y + height(length) };
        StdDraw.filledPolygon(tx, ty);
    }

    // Loops through itself to make a pattern of triangles
    public static void sierpinski(int n, double x, double y, double length) {
        if (n == 0) return;
        filledTriangle(x, y, length);
        sierpinski(n - 1, x, y + height(length), length / 2);
        sierpinski(n - 1, x - length / 2, y, length / 2);
        sierpinski(n - 1, x + length / 2, y, length / 2);
    }

    // Main code that calls the first function
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double[] x = { 0, 1, 0.5 };
        double[] y = { 0, 0, sqrt(3) / 2 };
        StdDraw.polygon(x, y);
        sierpinski(n, 0.5, 0, 0.5);
    }
}
