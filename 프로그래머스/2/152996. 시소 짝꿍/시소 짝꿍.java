import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        int n = weights.length;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(weights[i], map.getOrDefault(weights[i],0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            
            int num = entry.getKey();
            int a = entry.getValue();
            
            answer += (long)a * (long)(a - 1) / 2;
            
            if (num % 2 == 0) {
                int pair = num / 2 * 3;
                int b = map.getOrDefault(pair, 0);
                answer += (long)a * (long)b;
            }
            if (num % 3 == 0) {
                int pair = num / 3 * 4;
                int b = map.getOrDefault(pair, 0);
                answer += (long)a * (long)b;
            }
            answer += (long) map.getOrDefault(num * 2, 0) * (long) a;
        }
        
        return answer;
    }
}