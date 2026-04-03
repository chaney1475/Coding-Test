import java.util.*;

class Solution {
    int count = 0;
    int n;
    int[] numbers;
    int target;
    
    public int solution(int[] numbers, int target) {
        n = numbers.length;
        this.numbers = numbers;
        this.target = target;
        
        count = 0;
        dfs(0, 0);
        
        return count;
    }
    
    public void dfs(int idx, int total) {
        // 현재 다음으로 더해야하는 인덱스 위치
            
        int tmp = 0;
        for (int i = idx; i < n; i++) {
            tmp += numbers[i];
        }
        
        // 다 더해도 total보다 작으면 그만
        if (total + tmp < target) return;
        // 다 빼도 total보다 크면 그만
        if (total - tmp > target) return;
        
        if (idx == n) {
            // 다음으로 갈 인덱스 없음
            if (target == total) count++;
            return;
        }
        
        dfs(idx + 1, total + numbers[idx]);
        dfs(idx + 1, total - numbers[idx]);
        
    }
}