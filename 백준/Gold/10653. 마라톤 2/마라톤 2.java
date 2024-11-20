import java.io.*;
import java.util.*;

public class Main {
    static int[][] A;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        A = new int[N + 1][2];
        dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            A[i][0] = Integer.parseInt(st.nextToken());
            A[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[1][0] = 0; 

        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= K; j++) {
                if (dp[i][j] == Integer.MAX_VALUE) continue;
                for (int next = i + 1; next <= N; next++) {
                    int skipCount = next - i - 1;
                    if (j + skipCount > K) break;
                    int distance = manhattanDistance(i, next);
                    dp[next][j + skipCount] = Math.min(dp[next][j + skipCount], dp[i][j] + distance);
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int j = 0; j <= K; j++) {
            result = Math.min(result, dp[N][j]);
        }

        System.out.println(result);
    }

    // 거리
    private static int manhattanDistance(int i, int j) {
        return Math.abs(A[i][0] - A[j][0]) + Math.abs(A[i][1] - A[j][1]);
    }
}
