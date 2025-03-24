import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        
        int M = times.length;
        
        long maxN = -1;
        for (int i = 0; i < M; i++){
            maxN = Math.max(maxN, times[i]);
        }
        
        long s = 1;
        long e =  maxN * n;
        
        long ans = -1;
        
        while (s <= e){
            long mid = (s + e) / 2;
            long tmp = 0;
            
            // 몇명이나 들어올 수 있는지
            for (int i = 0; i < M; i++){
                tmp += mid / times[i];
            }
            
            if (tmp >= n){
                ans = mid;
                e = mid - 1;
            }else{
                s = mid + 1;
            }
        }
        
        return ans;
    }
}