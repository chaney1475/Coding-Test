import java.util.*;

class Solution {
    ArrayList<Integer>[] adj;
    int n;
    int len;
    
    int ans;
    int[] dist;
    
    public int solution(int n, int[][] edge) {
        this.n = n;
        
        adj = new ArrayList[n+1];
        
        for (int i = 0; i < n+ 1; i++){
            adj[i] = new ArrayList<>();
        }
        
        len = edge.length;
        
        dist = new int[n+1];
        Arrays.fill(dist, -1);
        
        for (int i = 0; i < len; i++){
            int a = edge[i][0];
            int b = edge[i][1];
            adj[a].add(b);
            adj[b].add(a);
        }
        
        // 1에서 가장 멀리 떨어져있는 노드
        
        dist[1] = 0;
        Queue<Integer> q = new LinkedList<>();
        
        q.add(1);
        while(!q.isEmpty()){
            int now = q.poll();
            for (int next : adj[now]){
                if (dist[next] != -1) continue;
                dist[next] = dist[now] + 1;
                q.add(next);
            }
        }
        int max = 0;
        int ans = 0;
        
        for (int i = 1; i < n + 1 ; i++){
            int now = dist[i];
            if (max < now){
                max = now;
                ans = 1;
            } else if (max == now){
                ans++;
            }
        }
        
        return ans;
        
    }
    
}