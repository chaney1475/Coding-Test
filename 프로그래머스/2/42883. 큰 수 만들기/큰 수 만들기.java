import java.util.*;

class Solution {
    public String solution(String number, int k) {
        int N = number.length();
        
        StringBuilder sb = new StringBuilder();
        Deque<Integer> dq = new ArrayDeque<>();
        
        int count = 0;
        for (int i = 0; i < N ; i++) {
            int now  = number.charAt(i) - '0';

            while (count < k && !dq.isEmpty() && dq.peekLast() < now) {
                dq.pollLast();
                count++;
            }
            dq.add(now);
        }

        while (count < k) {
            dq.pollLast();
            count++;
        }

        while (!dq.isEmpty()) {
            sb.append(dq.pollFirst());
        }
        
        return sb.toString();
    }
}