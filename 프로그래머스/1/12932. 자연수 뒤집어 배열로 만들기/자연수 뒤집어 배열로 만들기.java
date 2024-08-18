import java.util.*;

class Solution {
    public int[] solution(long n) {
        
        String str = String.valueOf(n);
        
        int[] answer = new int[str.length()];
        
        System.out.print(str);
        
        for (int i = 0; i < str.length(); i++){
            answer[str.length() - i  - 1] = str.charAt(i) - '0';
        }
        
        return answer;
    }
}