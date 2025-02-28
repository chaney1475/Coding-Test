import java.util.*;

class Solution {
    public int[] solution(int N, long left, long right) {
        
        int[] answer = new int[(int)(right - left) + 1];
        
        int idx = 0;
        
        for (long i = left; i <= right; i++){
            int x = (int) (i / N) + 1;
            int y = (int) (i % N) + 1;
            
            answer[idx++] = Math.max(x,y);
        }
        
        return answer;
    }
}