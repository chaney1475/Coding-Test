import java.util.*;

class Solution {
    public String[] solution(String[] names) {
        int size = (names.length + 4) / 5;  // 배열 크기를 계산할 때 안전하게 처리
        String[] answer = new String[size];
        
        for (int i = 0; i < names.length; i += 5) {
            answer[i / 5] = names[i];
        }
        return answer;
    }
}