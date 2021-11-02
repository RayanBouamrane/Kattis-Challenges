import java.util.Scanner;

public class Backspace {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String raw = "";

        if (sc.hasNext()) {
            raw = sc.nextLine();
        }
        //create StringBuilder object with size 1
        StringBuilder builder = new StringBuilder("0");

        //we can assume the first character is not a backspace, hence we set it
        //this allows us to start loop at index 1, and eliminates IndexOutOfBoundsExceptions
        builder.setCharAt(0, raw.charAt(0));

        for (int i = 1; i < raw.length(); i++) {
            if (raw.charAt(i) != '<' ) {
                builder.append(raw.charAt(i));
            } else {
                builder.deleteCharAt(builder.length()-1);
            }
        }
        System.out.println(builder);
    }
}