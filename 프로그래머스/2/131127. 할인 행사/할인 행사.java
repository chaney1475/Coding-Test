import java.util.*;

class Solution {
    
    Map<String, Integer> map;
    int N;
    int[] cnt;
    
    public int solution(String[] want, int[] number, String[] discount) {
        //  want에 스트링 
        int ans = 0;
        
        map = new HashMap<>();
        N = want.length;
        cnt = new int[N];
        
        for (int i = 0; i < N; i++){
            map.put(want[i], i);
            cnt[i] = number[i];
        }
        
        for (int i = 0; i < 10; i++){
            if (map.containsKey(discount[i])){
                cnt[map.get(discount[i])]--;
            }
        }
        
        //일단 10개 더함
        if (check()) ans++;
        
        for (int i = 10; i < discount.length; i++){
            if (map.containsKey(discount[i - 10])){
               cnt[map.get(discount[i - 10])]++;
            }
            if (map.containsKey(discount[i])){
                cnt[map.get(discount[i])]--;
            }
            
            if (check()) ans++;
            
        }
        
        return ans;
    }
    boolean check(){
        
        for (int i = 0; i < cnt.length; i++){
            if (cnt[i] > 0) return false;
        }
        
        return true;
    }
}