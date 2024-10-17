import java.util.*;

class Solution {
    public int solution(int[][] tri) {
        int N = tri.length;

        int[][] dp = new int[N][N];
        
        dp[0][0] = tri[0][0];
        
        for (int i = 0; i < N - 1; i++){
            for (int j = 0; j <= i; j++){
                dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j] + tri[i + 1][j]);
                dp[i+1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j] + tri[i + 1][j + 1]);
            }
        }
        int answer = 0;
        for (int i = 0; i < N; i++){
            answer =  Math.max(dp[N-1][i], answer);
        }
        return answer;
    }
}