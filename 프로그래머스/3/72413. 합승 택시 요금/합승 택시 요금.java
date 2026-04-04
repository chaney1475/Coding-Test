import java.util.*;
// 무지가 어피치에게 합승 제안
class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        
        // n 노드 갯수
        // s 도착 a 사람 b 사람의 노드
        
        int[][] dist = new int[n+1][n+1];
        
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }
        
        for (int i = 0; i < fares.length; i++) {
            int[] cur = fares[i];
            int c = cur[0];
            int d = cur[1];
            int f = cur[2]; // 가중치
            
            dist[c][d] = f;
            dist[d][c] = f;
        }
        
        for (int i = 1; i <= n; i++) { // 경유지
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (dist[j][i] == Integer.MAX_VALUE
                       || dist[i][k] == Integer.MAX_VALUE) continue;
                    int newD = dist[j][i] + dist[i][k];
                    if (newD < dist[j][k]) {
                        dist[j][k] = newD;
                    }
                }
            }
        }
        int answer = dist[a][s] + dist[b][s];
        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, dist[a][i] + dist[s][i] + dist[b][i]);
        }
        
        return answer;
    }
}