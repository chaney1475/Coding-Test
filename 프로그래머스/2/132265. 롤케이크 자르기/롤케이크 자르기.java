import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int N = topping.length;
        int ans = 0;
        
        Map<Integer, Integer> front = new HashMap<>();
        Map<Integer, Integer> back = new HashMap<>();
        int frontCount = 0;
        int backCount = 0;
        
        for (int i = 0; i < N; i++){
            int cnt = back.getOrDefault(topping[i], 0);
            if (cnt == 0){
                backCount++;
            }
            back.put(topping[i], cnt + 1);
        }
        
        for (int i = 0; i < N; i++){
            // i부터 뒤의 것!
            // 0부터 i-1까지, i부터 N까지 
            int now = topping[i];
            
            int fCnt = front.getOrDefault(now, 0);
            if (fCnt == 0){
                frontCount++;
            }
            front.put(now, fCnt + 1);
            
            int bCnt = back.getOrDefault(now, 0);
            if (bCnt == 1){
                backCount--;
                back.remove(now);
            }else{
                back.put(now, bCnt - 1);
            }
            
            if (frontCount == backCount) ans++;
        }
        
        return ans;
    }
}