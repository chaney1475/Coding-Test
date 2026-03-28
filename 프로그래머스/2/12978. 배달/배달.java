import java.util.*;
class Solution {
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        int[][] map = new int[N+1][N+1];
        
        for (int i = 0; i < N + 1; i++) {
            Arrays.fill(map[i], 10001);
            map[i][i] = 0;
        }
        
        for (int i = 0; i < road.length; i++) {
            int[] r = road[i];
            int a = r[0];
            int b = r[1];
            int c = r[2];
            
            if (map[a][b] > c) {
                map[a][b] = c;
                map[b][a] = c;
            }
        }
        
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        
        // 도착한 노드와 현재까지의 가중치
        dist[1] = 0;
        pq.add(new int[] {1,0});
        
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            
            int now = cur[0];
            int w = cur[1];
            
            if (w > dist[now]) continue;
            
            for (int i = 1; i < N + 1; i++) {
                if (map[now][i] == 10001) continue;
                
                int newW = w + map[now][i];
                if (newW < dist[i]) {
                    dist[i] = newW;
                    pq.add(new int[]{i, newW});
                }
            }
        }
        
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }
        return answer;
    }
}