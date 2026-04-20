import java.util.*;

class Solution {
    int answer;
    int rpt;
    public int solution(int storey) {
        answer = Integer.MAX_VALUE;
        rpt = 0;
        
        
        dfs(storey, 0, 0);
        
        return answer;
    }
    
    public void dfs(int now, int count, int idx) {
        
        if (now == 0) {
            answer = Math.min(answer, count);
            return;
        }
        if (count > answer) return; 
        
        int pos = (int)Math.pow(10, idx);
        
        int last = (now / pos) % 10; // 현재 계산해야하는 자리의 끝.
        
        dfs(now - (last) * pos , count + last, idx + 1);
        
        dfs(now + (10 - last) * pos, count + (10 - last), idx + 1);
    }
}