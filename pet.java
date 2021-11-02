import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class pet {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        int [] store = new int[5];

//        for (int i = 0; i < 5; i++) {
//
//            store[i] = 0;
//         }


        for (int i = 0; i < 5; i++) {

            store[i] += sc.nextInt();
            store[i] += sc.nextInt();
            store[i] += sc.nextInt();
            store[i] += sc.nextInt();
        }

        int maxAt = 0;

        for (int i = 0; i < store.length; i++) {
            maxAt = store[i] > store[maxAt] ? i : maxAt;
        }


        System.out.println(maxAt+1 + " " + store[maxAt]);
    }
}