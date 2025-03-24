import java.util.*;
class Solution {
    int distance;
    int[] rocks;
    int N, n;
    public int solution(int distance, int[] rocks, int n) {
        
        this.distance = distance;
        this. rocks = rocks;
        
        N = rocks.length;
        
        int counts = N - n + 1;
        
        Arrays.sort(rocks);
        
        long s = 1;
        long e = distance;
        
        long ans = -1;
        
        while (s <= e){
            long mid = (s + e) / 2;
            
            // 바위의 수를 보자
            long cnt = check(mid);
            
            // 바위의 수가 그게 되는 순가
            if (cnt >= counts){
                ans = mid;
                s = mid + 1;
            }else{
                e = mid - 1;
            }
        }
        
        return (int) ans;
    }
    
    int check(long mid){
        
        int cnt = 0;
        int prev = 0;
        
        int idx = 0;
        
        for (int i = 0; i < N; i++){            
            if (rocks[i] >= mid + prev){
                cnt++;
                prev = rocks[i];
            }
        }
        
        if (prev + mid <= distance){
            cnt++;
        }
        
        return cnt;
    }
}