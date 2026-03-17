import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        
        int answer = 0;
        
        int total_sec = players.length;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < total_sec; i++) {
            int playerCnt = players[i];
            int server = playerCnt / m;
            
            while (!pq.isEmpty() && pq.peek() <= i) {
                pq.poll();
            }
            
            // 추가해야하는 서버 수
            int newServer = server - pq.size();
            for (int j = 0; j < newServer; j++) {
                answer++;
                pq.add(i + k);
            }
            
        }
        return answer;
    }
}