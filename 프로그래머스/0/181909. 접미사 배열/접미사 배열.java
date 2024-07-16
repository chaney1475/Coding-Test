import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        int s = my_string.length();
        String[] answer = new String[s];
        
        for(int i= 0; i < s; i++){
            answer[i] = my_string.substring(s-i-1,s);
        }
        Arrays.sort(answer);
        return answer;
    }
}