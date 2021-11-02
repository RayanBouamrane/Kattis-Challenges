import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Customer {
    Customer(int a, int w) {
        amount = a;
        waitTime = w;
    }

    public final int amount;
    public final int waitTime;

    static class sorter implements Comparator<Customer> {
        @Override
        public int compare(Customer o1, Customer o2) {
            if (o1.amount > o2.amount) return -1;
            else if (o2.amount > o1.amount) return 1;
            else return o1.waitTime - o2.waitTime;
        }
    }
}

public class bank {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int numCustomers = s.nextInt();
        int totalTime = s.nextInt();

        int[] queue = new int[totalTime];
        Customer[] customers = new Customer[numCustomers];
        for (int i = 0; i < numCustomers; i++) {
            Customer p = new Customer(s.nextInt(), s.nextInt());
            customers[i] = p;
        }

        Arrays.sort(customers, new Customer.sorter());
        for (int i = 0; i < numCustomers; i++) {
            addToLatest(customers[i], queue);
        }

        System.out.println(sumOf(queue));
    }

    public static int sumOf(int[] q) {
        int counter = 0;
        for (int a : q) counter += a;
        return counter;
    }

    public static void addToLatest(Customer c, int[] q) {
        for (int i = c.waitTime; i >= 0; i--) {
            if (q[i] == 0) {
                q[i] = c.amount;
                return;
            }
        }
    }

}