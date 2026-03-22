// 5 3 3 2 //
// 3 5 5 -1
import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        Deque<Integer> dq = new ArrayDeque<>();
        
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        
        for (int i = n -1; i >= 0; i--) {
            int cur = numbers[i]; // 현재 숫자
            
            while(!dq.isEmpty() && dq.peekLast() <= cur) {
                dq.pollLast();
            }
            
            if(!dq.isEmpty() && dq.peekLast() > cur) {
                answer[i] = dq.peekLast();
            }
            dq.add(cur);
        }
        
        return answer;
    }
}