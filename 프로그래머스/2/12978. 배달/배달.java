import java.util.*;

class Solution {
    static class Node{
        int edge, dist;
        Node(int edge, int dist){
            this.edge = edge; this.dist = dist;
        }
    }
    public int solution(int N, int[][] road, int K) {
        ArrayList<Node>[] adj = new ArrayList[N + 1];
        
        for (int i = 1; i <= N; i++){
            adj[i] = new ArrayList<>();
        }
        
        int len = road.length;
        for (int i = 0; i < len; i++){
            int[] now = road[i];
            adj[now[0]].add(new Node(now[1], now[2]));
            adj[now[1]].add(new Node(now[0], now[2]));
        }
        
        int[] dist = new int[N+1];
        Arrays.fill(dist, -1);
        dist[1] = 0;
        
        PriorityQueue<Node> q = new PriorityQueue<>((a,b) -> a.dist - b.dist);
        q.add(new Node(1, 0));   
        
        while(!q.isEmpty()){
            Node now = q.poll();
            for (Node next : adj[now.edge]){
                if (dist[next.edge] == -1 || dist[next.edge] > dist[now.edge] + next.dist){
                    dist[next.edge] = dist[now.edge] + next.dist;
                    q.add(new Node(next.edge, dist[next.edge]));
                }
            }
        }
        int ans = 0;
        for (int i = 0; i <= N; i++){
            if (dist[i] != 0 && dist[i] <= K) ans++;
        }
        
        return ans;
        
    }

}