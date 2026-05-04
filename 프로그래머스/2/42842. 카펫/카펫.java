import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        int sum = brown + yellow;
        
        for (int i = 2; i < sum; i++) {
            if (sum % i == 0) {
                // 나누어 떨어짐
                int h = i;
                int w = sum / i;
                
                int in = (h - 2) * (w - 2);
                int out = sum - in;
                
                if (out == brown && in == yellow) {
                    return new int[] {w, h};
                }
                
            }
        }
        
        return answer;
    }
}