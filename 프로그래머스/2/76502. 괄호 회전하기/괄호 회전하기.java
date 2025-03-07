import java.util.*;

class Solution {
    
    
    public int solution(String s) {
        
        int N = s.length();
        
        LinkedList<Character> stack = new LinkedList<>();
        
        Map<Character, Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        
        int ans = 0;
        
        for (int i = 0; i < N; i++){
            // 더 할 값
            stack.clear();
            for (int j = 0; j < N; j++){
                Character now = s.charAt((j + i) % N);
                if (!stack.isEmpty() && map.get(stack.getLast()) == now){
                    stack.pollLast();
                }else{
                    stack.addLast(now);
                }
                
            }
            
            if (stack.isEmpty()) {
                ans++;
            }
        }
        return ans;
    }
}