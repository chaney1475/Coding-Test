import java.util.*;

class Solution {
    //나보다 뒤에있는 수 중에서 나보다 크면서 가장 가까이에 잇는 수
    //arrayDeque
    
    public int[] solution(int[] nums) {
        int N = nums.length;
        int[] answer = new int[N];
        
        Arrays.fill(answer, -1);
        
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = N -1; i >= 0; i--){
            int now = nums[i];
            
            while(!deque.isEmpty() && deque.peekLast() <= now){
                deque.pollLast();
            }
            
            if (!deque.isEmpty() && deque.peekLast() > now){
                answer[i] = deque.peekLast();
            }
            
            deque.addLast(now);
        }
        
        return answer;
    }
}