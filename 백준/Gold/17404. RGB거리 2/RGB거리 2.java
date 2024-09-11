import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {

        int N = Integer.parseInt(br.readLine());
        int[][] grid = new int[N][3];
        int[][] dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = Integer.MAX_VALUE;

        for (int start = 0; start < 3; start++) {
            // 시작할 위치

            dp[0][start] = grid[0][start]; // 선택된 위치는 값 설정
            dp[0][(start + 1) % 3] = 10001; // 나머지는 최댓값
            dp[0][(start + 2) % 3] = 10001;

            for (int i = 1; i < N; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + grid[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + grid[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + grid[i][2];
            }

            for (int j = 0; j < 3; j++) {
                if (j == start) continue;
                ans = Math.min(dp[N - 1][j], ans);
            }

        }
        System.out.println(ans);

    }
}
