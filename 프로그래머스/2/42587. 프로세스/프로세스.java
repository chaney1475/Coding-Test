import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> big = new PriorityQueue<>((a,b) -> b - a);
        
        int N = priorities.length;
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        
        
        for (int i = 0; i < N; i++){
            big.add(priorities[i]);
            dq.addLast(new int[] {priorities[i], i});
        }
        
        int idx = 1;
        
        while (!dq.isEmpty()){
            
            int now = big.poll();
            
            while(dq.peekFirst()[0] != now){
                dq.addLast(dq.pollFirst());
            }
            
            int[] p = dq.pollFirst();
            if (p[1] == location){
                return idx;
            }
            
            idx++;
        }
        
        return answer;
    }
}