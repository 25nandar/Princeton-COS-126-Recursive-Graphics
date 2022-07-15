import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Transform2D {
    // Copy function
    public static double[] copy(double[] array) {

        double[] c = new double[4];

        for (int i = 0; i < 4; i++) {
            c[i] = array[i];
            // return c[i];
        }
        return c;
    }

    // Scale function
    public static void scale(double[] x, double[] y, double alpha) {
        for (int i = 0; i < 4; i++) {
            x[i] = x[i] * alpha;
            y[i] = y[i] * alpha;
        }

    }

    // Translate function
    public static void translate(double[] x, double[] y, double dx, double dy) {
        for (int i = 0; i < 4; i++) {
            x[i] = x[i] + dx;
            y[i] = y[i] + dy;
        }
    }

    // Rotate function
    public static void rotate(double[] x, double[] y, double theta) {
        for (int i = 0; i < 4; i++) {
            double rx = x[i];
            double ry = y[i];
            x[i] = rx * cos(Math.toRadians(theta)) - ry * sin(Math.toRadians(theta));
            y[i] = ry * cos(Math.toRadians(theta)) + rx * sin(Math.toRadians(theta));
        }
    }

    // Main code that calls the functions
    public static void main(String[] args) {
        StdDraw.setScale(-5.0, +5.0);
        double[] x = { 0, 1, 1, 0 };
        double[] y = { 0, 0, 2, 1 };
        double alpha = 2.0;
        double dx = 2.0, dy = 1.0;
        double theta = 180.0;

        double[] cx = Transform2D.copy(x);
        double[] cy = Transform2D.copy(y);

        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.polygon(x, y);
        scale(cx, cy, alpha);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.polygon(cx, cy);

        cx = Transform2D.copy(x);
        cy = Transform2D.copy(y);

        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.polygon(x, y);
        translate(cx, cy, dx, dy);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.polygon(cx, cy);

        cx = Transform2D.copy(x);
        cy = Transform2D.copy(y);

        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.polygon(x, y);
        rotate(cx, cy, theta);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.polygon(cx, cy);
    }
}
