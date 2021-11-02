import java.util.Scanner;

public class Chanukah
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            int j = sc.nextInt();
            int g = sc.nextInt();

            System.out.println(j + " "+  (g+ g*(g+1)/2));


        }

    }
}
