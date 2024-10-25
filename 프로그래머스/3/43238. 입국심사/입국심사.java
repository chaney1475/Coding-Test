import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        long s = 1L;
        long e = 1L;
        
        long maxTime = 0L;
        
        int len = times.length;
        
        for (int i = 0; i < len; i++){
            maxTime = Math.max(maxTime, (long) times[i]);
        }
        
        e = n * maxTime;
        
        long ans = 0L;
        
        while( s <= e ){
            long m = (s + e) / 2;
            
            //나와야하는 수보다 크거나 같은 경우 답임
            if (getCnt(m, times) >= n){
                //가능한 경우 시간을 줄이자
                ans = m;
                e = m - 1;
                
            }else{
                s = m + 1;
            }
        }
        
        return ans;
    }
    
    long getCnt(long m, int[] times){
        // 각 times에서 해당 초수로 가능한 사람수 구하기!
        
        long sum = 0L;
        for (int i = 0; i < times.length; i++){
            sum += m / times[i];
        }
        
        return sum;
        
    }
}