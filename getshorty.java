import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Tuple<Double, Integer> implements Comparable<Tuple<Double, Integer>> {
    public final double x;
    public final int y;

    public Tuple(double x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public int compareTo(Tuple<Double, Integer> o) {
        return -java.lang.Double.compare(x, o.x);
    }
}

public class getshorty {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        java.text.DecimalFormat df = new java.text.DecimalFormat("0.0000");
        
        while (s.hasNextLine()) {

            int n = s.nextInt();
            int m = s.nextInt();

            if (m == 0 && n == 0) break;

            ArrayList<ArrayList<Tuple<Double, Integer>>> adj = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < m; i++) {
                int x = s.nextInt();
                int y = s.nextInt();
                double f = s.nextDouble();
                adj.get(x).add(new Tuple<>(f, y));
                adj.get(y).add(new Tuple<>(f, x));
            }
            boolean[] bools = new boolean[n];
            double[] dist = new double[n];

            PriorityQueue<Tuple<Double, Integer>> l = new PriorityQueue<>();

            l.add(new Tuple<>(1.0, 0));

            while (!l.isEmpty()) {
                int c = l.peek().y;
                assert l.peek() != null;
                double size = l.peek().x;
                l.poll();

                if (bools[c])
                    continue;
                bools[c] = true;
                dist[c] = size;
                try {
                    for (Tuple<Double, Integer> i : adj.get(c)) {
                        int next = i.y;
                        double multi = i.x;
                        l.add(new Tuple<>(size * multi, next));
                    }
                } catch (NullPointerException ignored) {
                }
            }
            System.out.println(df.format(dist[n-1]));
        }
    }
}