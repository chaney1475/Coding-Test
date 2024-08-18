import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        // 짝수 번 째 1, 3, 5.. -> 대문자
        // 홀수 번 째 0, 2, 4.. -> 소문자
        
        String[] temp = s.split(" ", -1);
        
        for (String t : temp){
            int length = t.length();
            for (int i = 0; i < length; i++){
                if (i % 2 == 0) {
                    answer += Character.toUpperCase(t.charAt(i));
                } else{
                    answer += Character.toLowerCase(t.charAt(i));
                }
            }
            answer += " ";
        }
        return answer.substring(0, answer.length() - 1);
    }
}