import java.util.*;

class Solution {
    public int solution(String s) {
        
        int answer = 0;
        
        int len = s.length();
        
        int first = -1;
        
        int same = 0;
        int diff = 0;
        
        for (int i = 0; i < len; i++) {
            int now = s.charAt(i) - 'a';
            
            if (same == 0 && diff == 0) {
                first = now;
            }
            
            if (now == first) {
                same++;
            } else {
                diff++;
            }
            
            if (same == diff) {
                answer++;
                same = 0;
                diff = 0;
            }
        }
        
        if (same + diff > 0) {
            answer ++;
        }
        
        return answer;
    }
}