import java.util.*;

class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];

        for (int i = 0; i < s.length; i++) {
            answer[i] = process(s[i]);
        }

        return answer;
    }

    private String process(String s) {
        Stack<Character> stack = new Stack<>();
        int count110 = 0;

        for (char c : s.toCharArray()) {
            stack.push(c);
            
            if (stack.size() >= 3 &&
                stack.get(stack.size() - 3) == '1' &&
                stack.get(stack.size() - 2) == '1' &&
                stack.get(stack.size() - 1) == '0') {
                
                stack.pop();
                stack.pop();
                stack.pop();
                count110++;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        
        int pos = sb.lastIndexOf("0") + 1;
        if (pos == 0) pos = 0;

        StringBuilder result = new StringBuilder();
        result.append(sb.substring(0, pos));
        while (count110-- > 0) {
            result.append("110");
        }
        result.append(sb.substring(pos));

        return result.toString();
    }
}
