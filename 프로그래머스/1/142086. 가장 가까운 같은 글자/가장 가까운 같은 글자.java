import java.util.*;

class Solution {
    public int[] solution(String s) {
        int n = s.length();
        int[] answer = new int[n];
        
        Map<Character, Integer> idx = new HashMap<>();
        
        for (int i = 0; i < n; i++){
            char cur = s.charAt(i);
            int foundIndex = idx.getOrDefault(cur, -1);
            if (foundIndex == -1){
                answer[i] = -1;
            }else{
                answer[i] = i - foundIndex;
            }
            
            idx.put(cur, i);
        }
            
        return answer;
    }
}