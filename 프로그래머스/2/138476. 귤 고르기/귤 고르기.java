import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        int sum = 0; // k 개를 모아야함!
        int N = tangerine.length;
        
        Map<Long, Long> map = new HashMap<>();
        
        for (int i = 0; i < N; i++){
            map.putIfAbsent((long) tangerine[i], 0L);
            map.put((long) tangerine[i], map.get((long)tangerine[i]) + 1L);
        }
        
        // System.out.println(map);
        
        List<Map.Entry<Long, Long>> set = new ArrayList<>(map.entrySet());
        set.sort((a, b) -> Long.compare(b.getValue(), a.getValue()));
        
        for (Map.Entry<Long, Long> e : set){
            sum += e.getValue();
            answer ++;
            if(sum >= k) break;
        }
        
        return answer;
        
    }
}