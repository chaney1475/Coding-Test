import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        
        int N = tangerine.length;
        Map<Integer,Integer> map = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            int cur = tangerine[i];
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
        
        int[][] nums = new int[map.size()][2];
        
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            nums[i][0] = entry.getKey();
            nums[i++][1] = entry.getValue();
        }
        
        Arrays.sort(nums, (a,b) -> b[1] - a[1]);
        
        int sum = 0; // 전체 귤 갯수
        int ans = 0;
        for (int j = 0; j < i; j++) {
            sum += nums[j][1];
            ans = j + 1;
            if (sum >= k) break;
        } 
        
        return ans;
    }
}