import java.util.*;

class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int N = land.length;
        int M = 4;
        
        int[][] dp = new int[N][M];
        
        for (int i = 0; i < M; i++) {
            dp[0][i] = land[0][i];
        }
        
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M; j++) { // 현재 위치
                 for (int k = 0; k < M; k++) { // 다음 위치
                     if (j == k) continue;
                     dp[i + 1][k] = Math.max(dp[i][j] + land[i + 1][k], dp[i + 1][k]);
                 }
            }
        }
        
        for (int i = 0; i < M; i++) {
            answer = Math.max(dp[N-1][i], answer);
        }
        
        return answer;
    }
}