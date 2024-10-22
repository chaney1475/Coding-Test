import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        int sum = 0; // k 개를 모아야함!
        int N = tangerine.length;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < N; i++){
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        
        List<Map.Entry<Integer, Integer>> set = new ArrayList<>(map.entrySet());
        set.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));
        
        for (Map.Entry<Integer, Integer> e : set){
            sum += e.getValue();
            answer ++;
            if(sum >= k) break;
        }
        
        return answer;
        
    }
}