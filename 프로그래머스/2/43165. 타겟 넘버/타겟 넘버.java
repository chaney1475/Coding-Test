import java.util.*;

class Solution {
    int[] nums;
    int N;
    int target;
    int ans;
    public int solution(int[] numbers, int target) {
        nums = numbers;
        this.target = target;
        N = numbers.length;
        
        ans = 0;
        dfs(0,0); // 0번의 숫자를 더할건가 뺄건가 
        
        return ans;
    }
    
    void dfs(int now, int tmp){
        
        // 두개의 가지 치기
        
        // 모두를 더해도 여전히 작다 타겟보다        
        // 모두를 빼도 여전이 크다 타켓보다 
        
        int sum = 0;
        for (int i = now; i < N; i++){
            sum += nums[i];
        }
        
        if (target > sum + tmp){
            return;
        }
        if (target < tmp - sum){
            return;
        }
        
        if (now == N ){
            if (target == tmp){
                ans++;
            }
            return;
        }
        
        dfs(now + 1, tmp - nums[now]);
        dfs(now + 1, nums[now] + tmp);
        
    }
}