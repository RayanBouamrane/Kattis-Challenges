import java.util.Scanner;

public class vacuumba {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int testCases = s.nextInt();

        for (int i = 0; i < testCases; i++) {

            int steps = s.nextInt();
            double x = 0;
            double y = 0;
            double ang = Math.PI/2.0;
            for (int j = 0; j < steps; j++) {
                ang += Math.toRadians(s.nextDouble());
                double dis = s.nextDouble();
                x += dis * Math.cos(ang);
                y += dis * Math.sin(ang);
            }
            System.out.printf("%.6f %.6f \n" , x , y);
        }
    }
}