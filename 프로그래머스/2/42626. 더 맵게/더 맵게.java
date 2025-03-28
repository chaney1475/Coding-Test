import java.util.*;

class Solution {
    public int solution(int[] scov, int K) {
        
        PriorityQueue<Long> q = new PriorityQueue<>();
        
        int N = scov.length;
        for (int i = 0; i < N; i++){
            q.add((long)scov[i]);
        }
        
        int i = 0;
        while(q.size() >= 2 && q.peek() < K){
            long small = q.poll();
            long small2 = q.poll();
            q.add(small + small2 * 2);
            i++;
        }
        
        if (q.peek() < K){
            return -1;
        }else{
            return i;
        }
        
    }
}