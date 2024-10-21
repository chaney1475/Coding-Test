import java.util.*;

class Solution {

    static int cnt;

    public int solution(int storey) {
        cnt = Integer.MAX_VALUE;

        dfs(storey, 0);

        return cnt;
    }

    void dfs(int now, int d) {
        if (now == 0) {
            cnt = Math.min(cnt, d);
            return;
        }

        int last = now % 10;
        
        if (last >= 5) {
            dfs(now / 10 + 1, d + (10 - last));
        } 
    
        dfs(now / 10, d + last);
    }
}
