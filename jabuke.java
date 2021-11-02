import java.util.Scanner;

public class jabuke {

    static class Coordinate {
        public int x;
        public int y;
    }

    static Coordinate a = new Coordinate();
    static Coordinate b = new Coordinate();
    static Coordinate c = new Coordinate();
    static double det;

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        a.x = s.nextInt();
        a.y = s.nextInt();
        b.x = s.nextInt();
        b.y = s.nextInt();
        c.x = s.nextInt();
        c.y = s.nextInt();

        det = (b.y - c.y) * (a.x - c.x) - (c.x - b.x) * (c.y - a.y);

        int numPoints = s.nextInt();

        double area = Math.abs(a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y)) / 2.0;
        System.out.printf("%.1f", area);
        System.out.println();

        int numTress = 0;
        for (int i = 0; i < numPoints; i++) {
            Coordinate p = new Coordinate();
            p.x = s.nextInt();
            p.y = s.nextInt();
            if (isInTriangle(p)) numTress++;
        }
        System.out.println(numTress);
    }

    public static boolean isInTriangle(Coordinate p) {

        double v1 = (b.y - c.y) * (p.x - c.x) + (c.x - b.x) * (p.y - c.y);
        if (v1 < Math.min(det, 0) || v1 > Math.max(det, 0))
            return false;
        double v2 = (c.y - a.y) * (p.x - c.x) + (a.x - c.x) * (p.y - c.y);
        if (v2 < Math.min(det, 0) || v2 > Math.max(det, 0))
            return false;
        double v3 = det - v1 - v2;
        return !(v3 < Math.min(det, 0)) && !(v3 > Math.max(det, 0));

    }

}
