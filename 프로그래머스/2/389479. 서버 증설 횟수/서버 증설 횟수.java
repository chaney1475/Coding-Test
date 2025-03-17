import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int n = players.length;
        int ans = 0;
        int now = 0;
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            // 1. 현재 시간에서 만료된 서버 제거 및 now 감소
            while (!queue.isEmpty() && queue.peek() == i) {
                queue.poll();
                now--;
            }
            
            // 2. 필요한 서버 수 계산 (올림 처리)
            int required = (players[i]) / m;
            
            // 3. 필요한 서버 수가 현재 서버 수보다 많으면 추가 증설
            while (now < required) {
                queue.add(i + k); // k시간 동안 운영
                now++;
                ans++;
            }
        }
        
        return ans;
    }
}
