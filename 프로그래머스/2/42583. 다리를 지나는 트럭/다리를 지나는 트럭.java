import java.util.*;

class Solution {
    public int solution(int length, int weight, int[] truck) {
        
        int time = 1;
        
        int N = truck.length;
        
        int sum = 0;
        Deque<int[]> dq = new ArrayDeque<>();
        
        int tidx = 0;
        
        while(true){
            int now = truck[tidx];
            // [0] : 무게 , [1] : 나가는 시간
            if (!dq.isEmpty() && dq.peekFirst()[1] == time){
                sum -= dq.pollFirst()[0];
            }
            
            if (sum + now <= weight && dq.size() < length){
                dq.add(new int[]{now, time + length});
                sum += now;
                tidx++;
            }
            
            time++;
            if (tidx == N) break;
        }
        
        if (!dq.isEmpty()){
            time = dq.pollLast()[1];
        }
        
        return time;
    }
}