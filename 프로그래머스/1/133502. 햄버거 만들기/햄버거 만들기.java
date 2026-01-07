import java.util.*;
// 1,  2,   3
// 빵, 야채, 고기
// 야채, 고기, 빵
class Solution {
    public int solution(int[] ingre) {
        
        int ans = 0;
        
        int[] order = new int[]{1,3,2,1}; //빵 야채 고기 빵 
        
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        ArrayDeque<Integer> tmp = new ArrayDeque<>();
        
        int n = ingre.length;
        
        for (int i = 0; i < n; i++) {
            int now = ingre[i]; // 현재 재료
            dq.add(now);
            
            if( dq.peekLast() == 1 && dq.size() >= 4){
                
                for (int j = 0; j < 4; j++) {
                    if (order[j] == dq.peekLast()) {
                        tmp.add(dq.pollLast());
                    }else{
                        break;
                    }
                }
                
                if (tmp.size() == 4){
                    ans += 1;
                    tmp.clear();
                } else {
                    while (tmp.size() > 0){
                        dq.add(tmp.pollLast());
                    }
                }
            }
            
            
        }
        
        return ans;
    }
}