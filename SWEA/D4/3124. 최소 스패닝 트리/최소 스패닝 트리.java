import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	static class Edge implements Comparable<Edge> {
		int w;
		long dist;

		public Edge(int w, int dist) {
			this.w = w;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Edge o) {
			if (this.dist < o.dist) {
				return -1;
			}
			return 1;
		}
	}

	static int V;
	static int E;
	
	public static void main(String[] args) throws IOException {
		// 최소 스패닝 트리 - mst
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			List<Edge>[] graph = new ArrayList[V+1];
			
			for (int i = 0; i < graph.length; i++) {
				graph[i] = new ArrayList<>();
			}
			
			for (int e = 0; e < E; e++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				graph[a].add(new Edge(b,c));
				graph[b].add(new Edge(a,c));
			}
			
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			boolean[] visit = new boolean[V + 1];
			pq.offer(new Edge(1, 0));
				
			long total = 0;
			while(!pq.isEmpty()) {
				Edge edge = pq.poll();
				int v = edge.w;
				long cost = edge.dist;
				
		        //방문 했으면 건너뜀
				if(visit[v]) continue;
		        
				visit[v] = true;
				total += cost;
				
				for(Edge e : graph[v]) {
					if(!visit[e.w]) {
						pq.add(e);
					}
				}
			}
			
			System.out.printf("#%d %d\n",t, total);
		}
		

	}

}
