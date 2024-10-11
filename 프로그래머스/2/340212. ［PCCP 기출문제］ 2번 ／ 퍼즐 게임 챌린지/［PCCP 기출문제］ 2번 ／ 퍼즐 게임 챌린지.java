import java.util.*;
import java.io.*;

class Solution {
    
    // 제한 시간안에 무조건 가능하다
    // 가장 큰 능력이면 무조건 풀 수 있다는 뜻
    
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        int s = 1;
        int e = 0;
        
        for (int i = 0; i < diffs.length; i++){
            e = Math.max(e, diffs[i]);
        }
        
        while(s <= e){
            int m = (s + e) / 2;
            
            if (possible(m, diffs, times, limit)){
                answer = m;
                e = m - 1;
            }else{
                s = m + 1;
            }
            
        }
        
        return answer;
    }
    
    static boolean possible(long level, int[] diffs, int[] times, long limit){
        
        long total = 0; //전체 필요한 시간
        
        for (int i = 0; i < diffs.length; i++){
            
            long diff = diffs[i]; // 현재의 난이도
            
            long cur_time = times[i]; // 현재 걸리는 시간
            
            long prev_time = -1;
            
            if (i > 0){
                prev_time = times[i - 1];
            }
            
            long tmp = 0;
            if (diff - level > 0){
                tmp += (prev_time + cur_time) * (diff - level);
            }
            
            tmp += cur_time;
            
            total += tmp;
            
        }
        
        return (total <= limit);
        
    }
}