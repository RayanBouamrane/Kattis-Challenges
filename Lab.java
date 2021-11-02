import java.util.*;

public class Lab {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int totalWidth = s.nextInt();
        int numPartitions = s.nextInt();

        int[] walls = new int[numPartitions + 2];

        walls[0] = 0;
        walls[walls.length - 1] = totalWidth;

        for (int i = 1; i < walls.length - 1; i++) {
            walls[i] = s.nextInt();
        }
        ArrayList<Integer> possible = new ArrayList<>();
        for (int i = 0; i < walls.length; i++) {
            for (int j = 0; j < walls.length; j++) {
                if (j != i) {
                    if (walls[j] - walls[i] > 0) possible.add(walls[j] - walls[i]);
                }
            }
        }
        HashSet<Integer> h = new HashSet<>();
        h.addAll(possible);
        possible = new ArrayList<Integer>();
        possible.addAll(h);
        Collections.sort(possible);
        System.out.print(possible.get(0)+" ");
        for (int i = 1; i < possible.size() - 1; i++) {
            System.out.print(possible.get(i)+ " ");
        }
        System.out.print(possible.get(possible.size()-1));
    }
}
