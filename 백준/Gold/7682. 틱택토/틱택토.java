import java.util.*;
import java.io.*;

public class Main {
    static char[][] grid;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        grid = new char[3][3];
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();

        while (!s.equals("end")) {
            for (int i = 0; i < 9; i++) {
                grid[i / 3][i % 3] = s.charAt(i);
            }
            if (check()) {
                sb.append("valid\n");
            } else {
                sb.append("invalid\n");
            }
            s = br.readLine();
        }

        System.out.print(sb);
    }

    static boolean check() {
        
        int xcnt = 0;
        int ocnt = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == 'X') xcnt++;
                else if (grid[i][j] == 'O') ocnt++;
            }
        }

        if (xcnt < ocnt || xcnt > ocnt + 1) return false;

        int xline = cntLine('X');
        int oline = cntLine('O');

        if (xline > 0 && oline > 0) return false;

        if (xline > 0 && xcnt != ocnt + 1) return false;

        if (oline > 0 && xcnt != ocnt) return false;

        if (xline == 0 && oline == 0) {
            if (xcnt + ocnt == 9) return true;
            return false;
        }

        return true;
    }

    static int cntLine(char player) {
        int cnt = 0;

        for (int i = 0; i < 3; i++) {
            if (grid[i][0] == player && grid[i][1] == player && grid[i][2] == player) {
                cnt++;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (grid[0][i] == player && grid[1][i] == player && grid[2][i] == player) {
                cnt++;
            }
        }

        if (grid[0][0] == player && grid[1][1] == player && grid[2][2] == player) {
            cnt++;
        }
        if (grid[0][2] == player && grid[1][1] == player && grid[2][0] == player) {
            cnt++;
        }

        return cnt;
    }
}
