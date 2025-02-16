import java.util.*;

class Solution {
    public int solution(int num) {
        
        int ans = 0;
        
        long n = num;
        if (num == 1) return 0;
    
        while (n != 1){
            if (n % 2 == 0){
                n = n / 2;
            }else {
                n = n * 3 + 1;
            }
            ans++;
            if (ans >= 500) break;
        }
        return ans == 500 ? -1 : ans;
    }
}