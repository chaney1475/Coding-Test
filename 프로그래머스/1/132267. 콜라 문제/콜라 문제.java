// 콜라 빈병 2개 -> 콜라 새거 1개인 경우에 빈병 20개를 가져가면
// 20 / 2 = 10
// 10 / 2 = 5받음 
// (5+ 1) / 2 = 3 받음 (나머지 빈병 1개)
// 3 / 2 = 1개 받음 (나머지 빈병 1개

// 10 + 5 + 3 + 1
import java.util.*;

class Solution {
    public int solution(int a, int b, int n) {
        int ans = 0;
        int left = 0;
        
        
        while (n / a > 0 && n > 1){
            ans += (n / a) * b;
            left = n % a;
            
            // System.out.println("ans : " + ans + ", left: " + left);
            
            n = left + (n / a) * b;
            // System.out.println("n : " + n);
        }
        
        return ans;
    }
}