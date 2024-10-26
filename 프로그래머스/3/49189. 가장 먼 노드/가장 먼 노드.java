import java.util.*;

class Solution {
    static boolean[] visited;
    static int N;
    
    static ArrayList<Integer>[] adj;
    static int maxD;
    static int count;
    
    
    public int solution(int n, int[][] edge) {
        N  = n;
        
        visited = new boolean[n + 1];
        adj = new ArrayList[n+1];
        count = 0;
        
        for (int i = 1; i <= N; i++){
            adj[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < edge.length; i++){
            int[] now = edge[i];
            adj[now[1]].add(now[0]);
            adj[now[0]].add(now[1]);
        }
        
        bfs();
        
        return count;
        
    }
    
    static void bfs(){
        
        visited[1] = true;
        Queue<int[]> q = new LinkedList<>();
        for (Integer next : adj[1]){
            visited[next] = true;
            q.add(new int[] {next,1});
        }
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            int node = now[0];
            int d = now[1];
            
            if (maxD == d) count++;
            else if (d > maxD){
                maxD = d;
                count = 1;
            }
            
            for (Integer next : adj[node]){
                if (visited[next]) continue;
                visited[next] = true;
                q.add(new int[] {next, d + 1});
            }
        }
        
        
    }
}