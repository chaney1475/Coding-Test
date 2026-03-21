import java.util.*;

class Solution {
    public int solution(int n) {
        if (n % 2 == 1) {
            return 0;
        }
        long[] dp = new long[n + 1];
        
        dp[0] = 1;
        
        for (int i = 2; i <= n; i += 2){
            long tmp = (dp[i - 2] * 3) % 1000000007;
            
            for (int j = i - 4; j >= 0; j -=2) {
                tmp = (tmp + (dp[j] * 2) % 1000000007) % 1000000007;
            }
            dp[i] = (int)tmp;
        }
        return (int)dp[n];
    }
}