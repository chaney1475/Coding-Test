import java.util.*;
/*
100 2명
210 1명
* 2 랑 같기
*/
import java.util.*;

class Solution {
    int[][] c = new int[3][2];
    public long solution(int[] weights) {
        
        long ans = 0;
        
        
        Map<Integer, Integer> map = new HashMap<>();
        
        int N = weights.length;
        
        for (int i = 0; i < N; i++){
            map.put(weights[i], map.getOrDefault(weights[i], 0) + 1);
        }
        int n = map.size();
        
        int[] list = new int[n];
        int[] cnt = new int[n];
        int idx = 0;
        
        for (Map.Entry<Integer, Integer> en: map.entrySet()){
            list[idx] = en.getKey();
            cnt[idx++] = en.getValue();
        }
        c[0] = new int[]{1,2};
        c[1] = new int[]{2,3};
        c[2] = new int[]{3,4};
        
        for (int i = 0; i < n; i++){
            // 나 자신인 경우
            ans += ((long)(cnt[i] - 1) * (long)(cnt[i])) / 2;
            
            for (int j = i + 1; j < n; j++){
                if (check(list[i], list[j])){
                    ans += (long) cnt[i] * (long) cnt[j];
                }
            }
        }
        
        return ans;
    }
    boolean check(long x, long y){    
        for (int i = 0; i < 3; i++){
            int a = c[i][0];
            int b = c[i][1];
            
            if (a * x == y * b || a * y == b * x){
                return true;
            }
        }
        return false;
    }
}