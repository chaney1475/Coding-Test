import java.util.*;
import java.io.*;

public class Main {
    static int[] mins = { 0, 0, 1, 7, 4, 2, 0, 8, 10 };
    static long[] dp = new long[101];  // 최대 성냥개비 수는 100개까지
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < 9; i++) {
            dp[i] = mins[i];
        }
        dp[6] = 6;

        for (int i = 9; i <= 100; i++) {
            dp[i] = dp[i - 2] * 10 + mins[2];
            for (int j = 3; j < 8; j++) {
                dp[i] = Math.min(dp[i], dp[i - j] * 10 + mins[j]);  // 더 작은 값으로 갱신
            }
        }

        int T = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < T; t++) {
            int matches_have = Integer.parseInt(br.readLine());

            sb.append(dp[matches_have]).append(" ");
            
            if (matches_have % 2 == 0) {
            	//짝수
                for (int i = 0; i < matches_have / 2; i++) {
                    sb.append(1);
                }
            } else {
                sb.append(7);
                for (int i = 0; i < matches_have / 2 - 1; i++) {
                    sb.append(1);
                }
            }
            sb.append('\n');
        }

        System.out.print(sb.toString());
    }
}
