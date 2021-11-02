import java.math.BigInteger;
import java.util.Scanner;

public class bobby {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numCases = scan.nextInt();
        for (int i = 0; i < numCases; i++) {
            int r = scan.nextInt();
            int s = scan.nextInt();
            int x = scan.nextInt();
            int y = scan.nextInt();
            int w = scan.nextInt();

            double p = (double) (s - (r - 1)) / s;
            double q = 1 - p;

            double prob = 0;
            for (; x <= y; x++) {
                prob += nCr(y, x) * Math.pow(p, x) * Math.pow(q, y - x);
            }
            
            if (prob * w > 1) System.out.println("yes");
            else System.out.println("no");
        }

    }

    static int nCr(int n, int r) {
        return factorial(n).divide(factorial(r).multiply(factorial(n - r))).intValue();
    }

    static BigInteger factorial(int n) {
        BigInteger ans = new BigInteger("1");

        for (BigInteger i = BigInteger.valueOf(n); i.compareTo(BigInteger.ZERO) > 0; i = i.subtract(BigInteger.ONE)) {
            ans = ans.multiply(i);
        }
        return ans;
    }
}