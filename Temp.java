import java.util.Scanner;

public class Temp {

    public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    sc.nextInt();
    
    int counter = 0;
    
    while (sc.hasNextInt()) {
        int a = sc.nextInt();
        if (a < 0) 
            counter++;
    }
    
    System.out.println(counter);
    }
}