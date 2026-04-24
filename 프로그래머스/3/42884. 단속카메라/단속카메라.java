import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> a[0] - b[0]);
        
        int N = routes.length;
        
        int s = +30001;
        int e = -30001;
        
        int cnt = 0; // 일단 한 개도 없음
        
        for (int i = 0; i < N; i++) {
            
            int[] nr = routes[i];
            int newS = nr[0];
            int newE = nr[1];
                
            if (e >= newS) {
                s = Math.max(newS , s);
                e = Math.min(newE , e);
            } else {
                cnt ++;
                s = newS;
                e = newE;
            }
        }
        
        return cnt;
    }
}