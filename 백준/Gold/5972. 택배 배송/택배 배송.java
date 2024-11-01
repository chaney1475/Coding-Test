import java.util.*;
import java.io.*;

//1에서 N까지 가는 최소 거리

public class Main {
    static class Edge{
        int node, w;
        
        Edge(int node, int w){
            this.node = node;
            this.w = w;
        }
    }
    
  public static void main(String args[]) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    //1부터N까지 가야함 M개의 간선
    
    List<Edge>[] adj= new ArrayList[N+1];
    for (int i = 0; i <= N; i++){
        adj[i] = new ArrayList<>();
    }
    
    for (int i = 0; i < M ;i++){
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        adj[a].add(new Edge(b,w));
        adj[b].add(new Edge(a,w));
    }
    
    int[] dist = new int[N+1]; // 
    Arrays.fill(dist, Integer.MAX_VALUE);
    
    PriorityQueue<Edge> q = new PriorityQueue<>((a,b) -> a.w - b.w);
    
    dist[1] = 0;
    q.add(new Edge(1,0));
    
    while(!q.isEmpty()){
        Edge now = q.poll();
        int node = now.node;
        int w = now.w;
        
        if (node == N) break;
        
        for (Edge next : adj[node]){
            int nw = next.w;
            int nnode = next.node;
            
            if (w + nw < dist[nnode]){// 현재까지 온 값보다 작은 경우
                dist[nnode] = w + nw;
                q.add(new Edge(nnode, w + nw));
            }
        }
    }
    
    // System.out.println(Arrays.toString(dist));
    System.out.println(dist[N]);
  }
}