import java.util.Scanner;

public class list {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int k = 0;

        while (n % 2 == 0) {
            k++;
            n /= 2;
        }

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                k++;
                n /= i;
            }
        }
        if (n > 2)
            k++;

        System.out.println(k);
    }
}

