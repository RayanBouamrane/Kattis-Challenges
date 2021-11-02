import java.util.Scanner;

public class square {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int x1 = s.nextInt();
        int y1 = s.nextInt();
        int x2 = s.nextInt();
        int y2 = s.nextInt();
        int x3 = s.nextInt();
        int y3 = s.nextInt();

        int flag = 1;

        if (getDistance(x1, y1, x3, y3) > getDistance(x1, y1, x2, y2)) {
            flag = 2;
        }

        if (getDistance(x1, y1, x2, y2) > getDistance(x1, y1, x3, y3)) {
            flag = 3;
        }
        
        double centerX = 0;
        double centerY = 0;

        int pointX = 0;
        int pointY = 0;
        if (flag == 1) {
            centerX = (x2+x3)/2.0;
            centerY = (y2+y3)/2.0;
            pointX = (int) (centerX + centerX - x1);
            pointY = (int) (centerY + centerY - y1);
        }
        if (flag == 2) {
            centerX = (x1+x3)/2.0;
            centerY = (y1+y3)/2.0;
            pointX = (int) (centerX + centerX - x2);
            pointY = (int) (centerY + centerY - y2);
        }
        if (flag == 3) {
            centerX = (x2+x1)/2.0;
            centerY = (y2+y1)/2.0;
            pointX = (int) (centerX + centerX - x3);
            pointY = (int) (centerY + centerY - y3);
        }

        System.out.println(pointX + " " + pointY);
    }

    static double getDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1, 2));
    }
}
