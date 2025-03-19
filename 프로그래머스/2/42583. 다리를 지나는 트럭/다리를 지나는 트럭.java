import java.util.*;

/*
올라갈 수 잇는 수 : length
견딜 수 잇는 무게 : weight

트럭 배열 [7,4,5,6]

1초씩 체크 하기

수랑 무게 체크 : 올릴 수 잇다?
올리기

못 올린다 하면
맨 앞에잇는애가 언제나가는지 보기

올릴때 나가는 수 적기
1초에 올렷으면 언제 나갈 수 잇는지
무게랑 나갈 초수 같이 쓰기
1에 올라온 애면 3에 나감
올라온 시간 + 길이

*/

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