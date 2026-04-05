import java.util.*;
class Solution {
    public int solution(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        
        int n = nums.length; // 10
        int real = set.size(); // 3
        
        int answer = Math.min(real, n / 2);
        return answer;
    }
}