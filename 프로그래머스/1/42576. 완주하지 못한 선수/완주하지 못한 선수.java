import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // 한명 빼고 모두 완중함
        
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < participant.length; i++) {
            map.put(participant[i],map.getOrDefault(participant[i], 0) + 1);
        }
        
        for (int i = 0; i < completion.length; i++) {
            int cnt = map.get(completion[i]);
            map.put(completion[i], cnt - 1);
        }
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0) {
                return entry.getKey();   
            }
        }
        
        String answer = "";
        return answer;
    }
}