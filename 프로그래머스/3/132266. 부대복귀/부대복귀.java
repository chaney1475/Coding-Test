import java.util.*;

class Solution {
    
    public int[] solution(int n, int[][] roads, int[] sources, int dest) {
        int N = n;
        int[] ans = new int[sources.length];
        
        int len = roads.length; // 로드의 길이
        
        ArrayList<Integer>[] adj = new ArrayList[N+1];
        for (int i = 0; i <= N; i++){
            adj[i] = new ArrayList<Integer>();
        }
        
        for (int i = 0; i < len; i++){
            int a = roads[i][0];
            int b = roads[i][1];
            adj[a].add(b);
            adj[b].add(a);
        }
        int dist[] = new int[N+1];
        Arrays.fill(dist, -1);
        
        dist[dest] = 0;
        
        // 숫자가 더 작은게 앞으로
        Queue<Integer> q = new LinkedList<>();
        q.add(dest);
        
        while(!q.isEmpty()){
            int now = q.poll();
            for (Integer next : adj[now]){
                if(dist[next] == -1){
                    dist[next] = dist[now] + 1;
                    q.add(next);
                }
            }
        }
        
        for (int i = 0; i < sources.length; i++){
            int now = dist[sources[i]];
            if (now == Integer.MAX_VALUE){
                ans[i] = -1;
            }else{
                ans[i] = now;
            }
        }
        
        return ans;
    }
}