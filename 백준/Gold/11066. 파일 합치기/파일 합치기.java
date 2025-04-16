import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            int[] f = new int[k]; // 파일 크기

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < k; i++) {
                f[i] = Integer.parseInt(st.nextToken());
            }

            int[] prefixSum = new int[k + 1];
            for (int i = 0; i < k; i++) {
                prefixSum[i + 1] = prefixSum[i] + f[i];
            }

            int[][] dp = new int[k][k];

            for (int len = 2; len <= k; len++) {
                for (int i = 0; i <= k - len; i++) {
                    int j = i + len - 1;
                    dp[i][j] = Integer.MAX_VALUE;

                    for (int mid = i; mid < j; mid++) {
                        int cost = dp[i][mid] + dp[mid + 1][j] + prefixSum[j + 1] - prefixSum[i];
                        dp[i][j] = Math.min(dp[i][j], cost);
                    }
                }
            }

            System.out.println(dp[0][k - 1]);
        }
    }
}
