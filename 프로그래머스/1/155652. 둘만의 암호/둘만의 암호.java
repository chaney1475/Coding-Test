import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        int N = s.length();
        StringBuilder ans = new StringBuilder();

        Set<Integer> skips = new HashSet<>();

        for (int i = 0; i < skip.length(); i++) {
            skips.add(skip.charAt(i) - 'a'); // 숫자만 저장
        }

        for (int i = 0; i < N; i++) {
            char cur = s.charAt(i); // 현재 알파벳
            
            int tmp = cur - 'a'; // 현재 숫자로 표현된 알파벳
            
            for (int j = 0; j < index; j++) {
                tmp = (tmp + 1) % 26;
                if (skips.contains(tmp)) {
                    j--; // 한 번 더 가게
                }
            }
            ans.append((char)(tmp + 'a'));
        }
        return ans.toString();
    }
}