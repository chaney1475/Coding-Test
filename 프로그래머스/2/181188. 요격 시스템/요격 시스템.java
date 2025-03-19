import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        
        Arrays.sort(targets, (a,b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            else
                return b[1] - a[1];
        });
        
        int N = targets.length;
        
        int start = -1;
        int end = -1;
        int ans = 0;
        
        for (int i = 0; i < N; i++){
            int nowS = targets[i][0];
            int nowE = targets[i][1];
            
            //end 보다 먼저 시작하는 경우
            
            if (end > nowS){
                start = Math.max(start, nowS);
                end = Math.min(end, nowE);
            }else{
                
                ans++;
                start = nowS;
                end = nowE;
            }
            
        }
        
        return ans;
    }
}