import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;

        Map<Character, String> map = new HashMap<>();
        map.put('a', "aya");
        map.put('y', "ye");
        map.put('w', "woo");
        map.put('m', "ma");

        for (String s : babbling) {
            boolean flag = true;
            int j = 0;
            int m = s.length();
            String prev = null;   // 직전 단어 저장

            while (j < m) {

                char c = s.charAt(j);
                String word = map.getOrDefault(c, "");

                if (word.isEmpty()) {
                    flag = false;
                    break;
                }

                // 같은 단어 연속 금지
                if (word.equals(prev)) {
                    flag = false;
                    break;
                }

                // 단어가 실제로 맞는지 확인
                for (int k = 0; k < word.length(); k++) {
                    if (j >= m || s.charAt(j) != word.charAt(k)) {
                        flag = false;
                        break;
                    }
                    j++;
                }

                if (!flag) break;
                prev = word; // 현재 단어를 저장
            }

            if (flag) answer++;
        }

        return answer;
    }
}
