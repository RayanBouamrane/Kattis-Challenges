import java.util.Scanner;

public class eightqueens {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        boolean[][] board = new boolean[8][8];
        int numQueens = 0;
        String str = null;
        for (int i = 0; i < 8; i++) {
            str = s.nextLine();
            for (int j = 0; j < 8; j++) {
                char c = str.charAt(j);
                if (c == '*') {
                    board[i][j] = true;
                    numQueens++;
                }
            }
        }

        boolean valid = (numQueens == 8);

//        if (numQueens != 8) { valid = false; }

        for (int i = 0; i < 8; i++) {
            if (!valid) {
                break;
            }
            int counter1 = 0;
            int counter2 = 0;
            for (int j = 0; j < 8; j++) {
                if (board[i][j])
                    counter1++;
                if (board[j][i])
                    counter2++;
            }
            if (counter1 > 1 || counter2 > 1) valid = false;
        }

        for (int i = 0; i < 8; i++) {
            if (!valid) {
                break;
            } else {
                if (checkDiagDown(i, 0, board))
                    valid = false;
                if (checkDiagDown(0, i, board))
                    valid = false;
                if (checkDiagUp(i, 7, board))
                    valid = false;
                if (checkDiagUp(0, i, board))
                    valid = false;
            }
        }

        if (valid) {
            System.out.println("valid");
        } else {
            System.out.println("invalid");
        }
    }

    public static boolean checkDiagDown(int i, int j, boolean[][] board) {
        int counter = 0;
        while (i < 8 && j < 8) {
            if (board[i][j])
                counter++;
            i++;
            j++;
        }
        return counter > 1;
    }

    public static boolean checkDiagUp(int i, int j, boolean[][] board) {
        int counter = 0;
        while (i < 8 && j >= 0) {
            if (board[i][j])
                counter++;
            i++;
            j--;
        }
        return counter > 1;
    }
}