import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int ans = 0;
        
        int S = stations.length;
        int sta = 1;
        
        int W = w * 2 + 1;
        
        for (int now : stations){
            int end = now - w;
            
            if(sta < end) {
                int len = end - sta;
                int tmp = (len / W);
                if (len % W != 0) tmp++;
                ans += tmp;
            }
            sta = now + w + 1;
        }
        
        if (sta <= n){
            int len = n - sta + 1;
            int tmp = (len / W);
            if (len % W != 0) tmp++;
            ans += tmp;
        }
        
        return ans;
    }
}