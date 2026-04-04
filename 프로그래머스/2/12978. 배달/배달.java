import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        // 1에서 n번 마을까지 
        int[][] map = new int[N+1][N+1];
        
        for (int i = 0; i <= N; i++) {
            Arrays.fill(map[i], -1); // 못 가는길
            map[i][i] = 0;
        }
        
        for (int i = 0; i < road.length; i++) {
            int[] cur = road[i];
            int a = cur[0];
            int b = cur[1];
            int c = cur[2]; // 가중치
            if (map[a][b] == -1) {
                map[a][b] = c;
                map[b][a] = c;
            } else{
                map[a][b] = Math.min(map[a][b], c);
                map[b][a] = Math.min(map[b][a], c);
            }
            
        }
        
        int[] dist = new int[N+1];
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        // 0 : node , 1: d
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        q.add(new int[]{1, 0});
        
        while(!q.isEmpty()) {
            int[] cur  = q.poll();
            int node = cur[0];
            int d = cur[1];
            
            if (dist[node] < d) continue; // 이미 갱신이 되엇다면 패스
            
            for (int i = 1; i <= N; i++) {
                // 현재 가중치에서 새롭게 노드로 가는 가중치
                if (map[node][i] == -1) continue;
                
                int newD = d + map[node][i];
                if (newD < dist[i]){
                    dist[i] = newD;
                    q.add(new int[]{i, newD});
                }
            }
        }
        
        // System.out.println(Arrays.toString(dist));
        
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) answer++;
        }
        return answer;
    }
}