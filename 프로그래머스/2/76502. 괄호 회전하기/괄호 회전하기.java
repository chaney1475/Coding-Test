import java.util.*;
// []  -> 
// 열리는 애다  -> 안에 있음 잇으면 닫는거 확인하기 
// 열리는 애고 또 열리는 애면 일단 쌓기

class Solution {
    Map<Character, Character> map = new HashMap<>();
    
    public int solution(String s) {
        
        map.put('[',']');
        map.put('{','}');
        map.put('(',')');
        
        int answer = 0;
        int n = s.length();
        char[] tmp = new char[n];
            
        for (int i = 0; i < n; i++) {
            tmp = new char[n];
            for (int j = 0; j < n; j++) {
                char now = s.charAt((i + j) % n);
                tmp[j] = now;
            }
            answer += isTrue(tmp) ? 1 : 0;
            
        }
        
        return answer;
    }
    
    public boolean isTrue(char[] tmp) {
        Deque<Character> d = new ArrayDeque<>();
        
        int n = tmp.length;
        
        for (int i = 0; i < n; i++) {
            if (!d.isEmpty() && tmp[i] == map.getOrDefault(d.peekLast(), '1')) {
                d.pollLast();
                
            } else {
                d.add(tmp[i]);
            }
        }
        
        if (d.size() == 0) {
            return true;
        }
        return false;
    }
}