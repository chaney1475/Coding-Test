import java.util.*;

class Solution {
    static int N;
    static int tar;
    
    static int[] nums;
    static int ans;
    
    public int solution(int[] numbers, int target) {
        N = numbers.length;
        tar = target;
        
        nums = numbers;
        
        ans = 0;
        
        dfs(0,0);
        
        return ans;
    }
    
    static void dfs(int cnt, int tmp){
        
        int sum = 0;
        for (int i = cnt; i < N; i++){
            sum += nums[i];
        }
        
        if(tmp + sum < tar) return;
        if(tmp - sum > tar) return;
        
        if(cnt == N){
            if (tmp == tar){
                ans++;
            }
            return;
        }
        
        dfs(cnt + 1, tmp + nums[cnt]);
        dfs(cnt + 1, tmp - nums[cnt]);
        
    }
    
    
    
}