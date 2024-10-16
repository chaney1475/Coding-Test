import java.util.*;

class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        // 한분면만 구한다음에 * 4
        // 실수인거 * 4
        long in = 0;
        long R1 = (long) r1;
        long R2 = (long) r2;
        
        for (long i = 1; i <= R2; i++){
            double tmp = Math.sqrt((R1 * R1) - (i * i));
            
            long end = (long) Math.sqrt((R2 * R2) - (i * i));
            
            long start = 0L;
            if (i < r1){
                if (tmp == (long) tmp){
                    start = (long)tmp;
                
                }else{
                    start = (long)tmp + 1;
                }
            }
            
            in += (end - start + 1);
            
        }
        return in * 4;
    }
}