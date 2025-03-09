import java.util.*;

class Solution {
    
    boolean[] visited;
    int N;
    int ans = 0;
    int[][] map;
    
    public int solution(int k, int[][] dungeons) {
        
        N = dungeons.length;
        visited = new boolean[N];
        map = dungeons;
        // ?ans = -1;
        for (int i = 0; i < N; i++){
            visited[i] = true;
            dfs(k - map[i][1], 1);
            visited[i] = false;
        }
        return ans;
    }
    
    void dfs(int temp, int cnt){
        
        ans = Math.max(cnt, ans);
        
        if (cnt == N) {
            return;
        }
        
        for (int i = 0; i < N; i++){
            if (visited[i]) continue;
            if (map[i][0] <= temp) {
                visited[i] = true;
                dfs(temp - map[i][1], cnt + 1);
                visited[i] = false;
            }
        }
        
    }
}