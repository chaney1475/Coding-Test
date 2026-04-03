import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        long end = (long) Arrays.stream(times).max().getAsInt() * n;
        
        long start = 0;
        
        long m;
        
        while (start < end) {
            m = (end + start) / 2;
            
            long tmp = 0;
            for (int i = 0; i < times.length; i++) {
                tmp += m / times[i];
            }
            
            if (tmp >= n) {
                answer = m;
                end = m;
            } else{
                start = m + 1;
            }
            
        }
        return answer;
    }
}