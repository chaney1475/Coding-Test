import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        
        int[] dp = new int[y+1];
        // 커지는거 밖에 없으므로 가능
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        Queue<Integer> q = new PriorityQueue<>((a,b) -> a - b);
        dp[x] = 0;
        q.add(x);
        
        while(!q.isEmpty()) {
            int now = q.poll();
            if (now * 2 <= y && dp[now* 2] > dp[now] + 1){
                dp[now * 2] = dp[now] + 1;
                q.add(now * 2);
            } 
            if (now * 3 <= y && dp[now * 3] > dp[now] + 1){
                dp[now * 3] = dp[now] + 1;
                q.add(now * 3);
            }
            if (now + n <= y && dp[now + n] > dp[now] + 1){
                dp[now + n] = dp[now] + 1;
                q.add(now + n);
            }
            
        }
        
        int answer = dp[y] == Integer.MAX_VALUE ? -1 : dp[y];
        return answer;
    }
}