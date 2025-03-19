import java.util.*;

class Solution {
    ArrayList<Integer>[] right;
    ArrayList<Integer>[] left;
    boolean[] visited;
    int N;
    public int solution(int n, int[][] results) {
        N = n + 1;
        
        right = new ArrayList[N];
        left = new ArrayList[N];
        
        visited = new boolean[N];
        
        for (int i = 0; i < n + 1; i++){
            right[i] = new ArrayList<>();
            left[i] = new ArrayList<>();
        }
        
        int len = results.length;
        for (int i = 0; i < len; i++){
            int a = results[i][0];
            int b  = results[i][1];
            right[a].add(b);
            left[b].add(a);
        }
        
        int ans = 0;
        
        for (int i = 1; i < N; i++){
            
            visited[i] = true;
            bfs(i, right);
            bfs(i, left);
            
            int cnt = 0;
            for (int j = 1; j <= n; j++){
                if (visited[j]) cnt++;
                else break;
            }
            
            if (cnt == n) ans++;
            
            Arrays.fill(visited, false);
        }
        
        return ans;
    }
    
    void bfs(int start, ArrayList<Integer>[] adj){
        
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        
        while(!q.isEmpty()){
            int now = q.poll();
            
            for (int next : adj[now]){
                if (visited[next]) continue;
                visited[next] = true;
                q.add(next);
            }
        }
    }
}