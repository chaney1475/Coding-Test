import java.util.*;
import java.io.*;

public class Main {
    
    static class Edge {
        int v;       
        int w;
        long cost; 
        
        Edge(int v, int w, long cost){
            this.v = v;
            this.w = w;
            this.cost = cost;
        }
    }
    
    static ArrayList<Edge> graph;
    static long[] dist;
    
    public static void main(String args[]) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 정점 개수
        int M = Integer.parseInt(st.nextToken()); // 간선 개수
        
        graph = new ArrayList<>();
        
        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int v    = Integer.parseInt(st.nextToken());
            int w    = Integer.parseInt(st.nextToken());
            long cost = Long.parseLong(st.nextToken());
            graph.add(new Edge(v, w, cost));
        }
        
        dist = new long[N+1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;  
        for (int i = 0; i < N-1; i++){
            for (int j = 0; j < M; j++){
                Edge edge = graph.get(j);
                if (dist[edge.v] != Long.MAX_VALUE && dist[edge.w] > dist[edge.v] + edge.cost) {
                    dist[edge.w] = dist[edge.v] + edge.cost;
                }
            }
        }
        
        for (int i = 0; i < M; i++){
            Edge edge = graph.get(i);
            if (dist[edge.v] != Long.MAX_VALUE && dist[edge.w] > dist[edge.v] + edge.cost){
                System.out.println(-1);
                return;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++){
            if (dist[i] == Long.MAX_VALUE) {
                sb.append(-1).append("\n");
            } else {
                sb.append(dist[i]).append("\n");
            }
        }
        
        System.out.print(sb);
    }
}
