/*
먼저 시작하는 순서 대로, 늦게끝나는 순서대로 넣어야하기 때문에
*/
import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int ans = 0;
        
        int N = targets.length;
        
        Arrays.sort(targets, (a,b) -> {
            if (a[0] != b[0])
               return Integer.compare(a[0], b[0]);
            else
                return Integer.compare(b[1], a[1]);
        });
        
        int nS = -1;
        int nE = -1;
        
        for (int i = 0; i < N; i++){
            int[] now = targets[i];
            int start = now[0];
            int end = now[1];
            
            if (start >= nE){
                ans++;
                nS = start;
                nE = end;
            }else {
                nS = Math.max(start, nS);
                nE = Math.min(end, nE);
            }
        }
        
        return ans;
    }
}