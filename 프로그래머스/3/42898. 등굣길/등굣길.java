import java.util.*;

class Solution {
    public int solution(int M, int N, int[][] puddles) {
        int K = 1000000007;
        
        int[][] dp = new int[N][M];
        
        dp[0][0] = 1;
        
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < puddles.length; i++){
            int[] now = puddles[i];
            set.add((now[1] -1) * 1000 + (now[0] - 1));
        }
        

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (i == 0 && j == 0) continue;
                int point = i * 1000 + j;
                if (set.contains(point)) continue;
                else{
                    if(i == 0) {
                        dp[i][j] = dp[i][j-1]; 
                    }else if (j == 0){
                        dp[i][j] = dp[i-1][j]; 
                    }else{
                        dp[i][j] = ((dp[i][j-1] % K) + (dp[i-1][j] % K)) % K;
                    }
                }
            }
        }
        
        // for (int i = 0; i < N; i++){
        //     System.out.println(Arrays.toString(dp[i]));
        // }
        
        return dp[N-1][M-1];
    }
}