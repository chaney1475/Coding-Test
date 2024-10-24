import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        
        int N = maps.length;
        int M = maps[0].length;
        
        int ans = -1;
        
        int[][] dp = new int[N][M];
        
        for (int i = 0; i < N; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        
        ArrayDeque<int[]> q = new ArrayDeque<>();
        
        q.add(new int[] {0,0,1} );
        dp[0][0] = 1;
        
        int[] dx = new int[]{0,0,-1,1};
        int[] dy = new int[]{1,-1,0,0};
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            
            int x = now[0];
            int y = now[1];
            int dist = now[2];
            
            if (x == N-1 && y == M -1) {
                ans = dp[x][y];
                break;
            } 
            
            for (int d = 0; d < 4; d++){
                int nx = dx[d] + x;
                int ny = dy[d] + y;
                if(nx < 0 || nx >= N || ny < 0 || ny >= M || maps[nx][ny] == 0) continue;
                if (dp[nx][ny] > dist + 1){
                    dp[nx][ny] = dist + 1;
                    q.add(new int[] {nx, ny, dist + 1});
                }
            }
        }
        
        return ans;
    }
}