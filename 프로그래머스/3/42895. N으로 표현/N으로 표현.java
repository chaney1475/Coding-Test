import java.util.*;

class Solution {
    public int solution(int N, int number) {
        //몇번쓰는지를 dp
        Set<Integer>[] dp = new Set[9];
        
        for (int i = 0; i <= 8; i++){
            dp[i] = new HashSet<>();
        }
        
        dp[1].add(N);
        int ans = -1;
        
        for (int i = 1; i <= 8; i++){ //dp[2] -> dp[1] + dp[1] 을 더하거나 뺀거나 곱한것 
            for (int j = 1; j < i; j++){
                for (Integer n1 : dp[j]){
                    for (Integer n2 : dp[i -j]){
                        dp[i].add(n1 + n2);
                        dp[i].add(n1 * n2);
                        if (n1 > n2){
                            dp[i].add(n1 - n2);
                        }
                        if (n2 != 0 && n1 % n2 == 0){
                            dp[i].add(n1 / n2);
                        }
                    }
                }
            }
            dp[i].add(makeNum(i, N));
            if (dp[i].contains(number)) {
                ans = i;
                break;
            }
        }
        
        return ans;
    }
    
    static int makeNum(int n, int N){
        int sum = 0;
        for (int i = 0; i < n; i++){
            sum *= 10;
            sum += N;
        }
        return sum;
    }
}