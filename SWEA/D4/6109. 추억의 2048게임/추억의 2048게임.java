import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static int[][] grid;

    public static void main(String[] args) throws IOException {

        // 2048

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            // grid 길이
            N = Integer.parseInt(st.nextToken());

            // 방향
            String dir = st.nextToken().trim();

            grid = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            switch (dir) {
                case "up":
                    up();
                    break;
                case "down":
                    down();
                    break;
                case "right":
                    right();
                    break;
                default:
                    left();
                    break;
            }

            System.out.printf("#%d\n", t);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (j == N - 1) {
                        System.out.print(grid[i][j]);
                    } else {
                        System.out.print(grid[i][j] + " ");
                    }
                }
                System.out.println();
            }
        }

    }

    static void up() {
        for (int j = 0; j < N; j ++) {
            List<Integer> col = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                if (grid[i][j] != 0) {
                    col.add(grid[i][j]);
                }
            }

            List<Integer> col2 = new ArrayList<>();

            for (int i = 0; i < col.size(); i++) {
                if (i < col.size() - 1 && col.get(i).equals(col.get(i + 1))) {
                    col2.add(col.get(i) * 2);
                    i++;
                }else {
                    col2.add(col.get(i));
                }

            }
            for (int i = 0; i < col2.size(); i++) {
                grid[i][j] = col2.get(i);
            }

            for (int i = col2.size(); i < N; i++) {
                grid[i][j] = 0;
            }

        }
    }

    static void down() {

        for (int j = 0; j < N; j ++) {
            List<Integer> col = new ArrayList<>();
            for (int i = N-1; i >= 0; i--) {
                if (grid[i][j] != 0) {
                    col.add(grid[i][j]);
                }
            }

            List<Integer> col2 = new ArrayList<>();


            for (int i = 0; i < col.size(); i++) {
                if (i < col.size() - 1 && col.get(i).equals(col.get(i + 1))) {
                    col2.add(col.get(i) * 2);
                    i++;
                }else {
                    col2.add(col.get(i));
                }

            }


            int col2_i = 0;

            for (int i = N-1; i >= N - col2.size(); i--) {
                grid[i][j] = col2.get(col2_i++);
            }

            for (int i = N - col2.size() - 1; i >= 0; i--) {
                grid[i][j] = 0;
            }

        }
    }

    static void left() {

        for (int i = 0; i < N; i ++) {
            List<Integer> col = new ArrayList<>();
            for (int j = 0; j < N; j++ ) {
                if (grid[i][j] != 0) {
                    col.add(grid[i][j]);
                }
            }

            List<Integer> col2 = new ArrayList<>();


            for (int j = 0; j < col.size(); j++) {
                if (j < col.size() - 1 && col.get(j).equals(col.get(j + 1))) {
                    col2.add(col.get(j) * 2);
                    j++;
                }else {
                    col2.add(col.get(j));
                }

            }

            for (int j =  0; j < col2.size(); j++) {
                grid[i][j] = col2.get(j);
            }

            for (int j = col2.size(); j < N; j++) {
                grid[i][j] = 0;
            }

        }
    }

    static void right() {

        for (int i = 0; i < N; i ++) {
            List<Integer> col = new ArrayList<>();
            for (int j = N -1; j >= 0; j-- ) {
                if (grid[i][j] != 0) {
                    col.add(grid[i][j]);
                }
            }

            List<Integer> col2 = new ArrayList<>();
            for (int j = 0; j < col.size(); j++) {
                if (j < col.size() - 1 && col.get(j).equals(col.get(j + 1))) {
                    col2.add(col.get(j) * 2);
                    j++;
                }else {
                    col2.add(col.get(j));
                }

            }

            int row_j = 0;
            for (int j = N-1 ; j >= N - col2.size(); j--) {
                grid[i][j] = col2.get(row_j++);
            }


            for (int j = N - col2.size() - 1; j >= 0; j--) {
                grid[i][j] = 0;
            }

        }
    }

}
