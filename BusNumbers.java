import java.util.Arrays;
import java.util.Scanner;

public class BusNumbers
{

    //this method will take an array of Strings, parse them into integers
    //and sort them in ascending order
    public static int[] sorter(String[] input)
    {
        int[] sorted = new int[input.length];

        for (int i = 0; i < input.length; i++)
        { sorted[i] = Integer.parseInt(input[i]); }

        Arrays.sort(sorted);

        return sorted;
    }

    //this method takes an array of integers and returns an array where
    //all the numbers that should be hyphenated are replaced with -1
    public static int[] findAdjacent(int[] sorted)
    {
        //we know nothing will be shortened in this case
        if (sorted.length < 3)

        { return sorted; }

        int[] adj = new int[sorted.length];
        adj[0] = sorted[0];
        adj[adj.length - 1] = sorted[sorted.length - 1];
        for (int i = 0; i < sorted.length - 2; i++)
        {
            if (sorted[i + 2] - sorted[i] == 2)
            { adj[i + 1] = -1; }
            else
            { adj[i + 1] = sorted[i + 1]; }
        }
        return adj;
    }

    public static void main(String[] args)
    {
        String raw;

        //skip first line, store second line as String
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        raw = sc.nextLine();

        //split the line into an array with all the numbers in it
        String[] strings = raw.split(" ");

        int[] sorted = sorter(strings);
        sorted = findAdjacent(sorted);

        //first number always printed
        System.out.print(sorted[0]);

        //scans the new array for hyphens and formats output accordingly
        for (int i = 1; i < sorted.length - 1; i++)
        {
            if (sorted[i] == -1 && sorted[i + 1] != -1)
            { System.out.print("-"); }
            else if (sorted[i] == -1)
            { continue; }
            else if (sorted[i - 1] == -1)
            { System.out.print(sorted[i]); }
            else
            { System.out.print(" " + sorted[i]); }
        }

        //last number may or may not have a space depending on if it is preceded by a hyphen
        if (sorted.length - 1 != 0)
        {
            if (sorted[sorted.length - 2] != -1)
            { System.out.print(" " + sorted[sorted.length - 1]); }
            else
            { System.out.print(sorted[sorted.length - 1]); }
        }
    }
}