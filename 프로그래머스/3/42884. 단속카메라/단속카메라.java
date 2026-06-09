import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (a,b) -> {
           if (a[0] != b[0]) {
               return a[0] - b[0];
           }
            return a[1] - b[1];
        });
        
        int s = -30001;
        int e = -30001;
        int ans = 0;
        
        int n = routes.length;
        
        for (int i = 0; i < n; i++) {
            int x = routes[i][0];
            int y = routes[i][1];
                
            if (e < x) {
                ans++;
                
                s = x;
                e = y;
            } else {     
                s = Math.max(s, x);
                e = Math.min(e, y);
            }

        }
        
        return ans;
    }
}