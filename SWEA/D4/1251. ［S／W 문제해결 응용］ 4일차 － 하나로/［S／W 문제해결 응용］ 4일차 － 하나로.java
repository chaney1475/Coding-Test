import java.io.*;
import java.util.*;

public class Solution {

	// 하나로
	static class Edge implements Comparable<Edge>{

		int x;
		long weight;
		
		Edge(int x, long weight){
			this.x = x;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			if (weight < o.weight) {
				return -1;
			}else {
				return 1;
			}
		}
		
	}

	static int[] rep;
	
	static int N; // 섬의 수
	static int E; // 간선수
	
	static double d;
	
	static PriorityQueue<Edge> q; // min heap 간선 정보 저장

	public static void main(String[] args) throws IOException {
		// 최소 스패닝 트리

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());

			boolean[] visited = new boolean[N + 1]; 
			
			List<long[]> islands = new ArrayList<>();
			
			List<Edge>[] graph = new ArrayList[N+1];
			
			for (int i = 0; i < N+1; i++) {
				graph[i] = new ArrayList<>();
			}
			
			String[] islandX = br.readLine().split(" ");
			String[] islandY = br.readLine().split(" ");
			
			for (int i = 0; i < islandX.length; i++) {
				islands.add(new long[] {Long.parseLong(islandX[i]), Long.parseLong(islandY[i])});
			}

			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1;  j < N; j++) {
					
					long a = islands.get(i)[0];
					long b = islands.get(i)[1];
					
					long c = islands.get(j)[0];
					long d = islands.get(j)[1];
					
					long l1 = Math.abs(a-c);
					
					long l2 = Math.abs(b-d);
					
					
					graph[i].add(new Edge(j,(long) Math.pow(l1, 2) + (long) Math.pow(l2, 2)));
					graph[j].add(new Edge(i,(long) Math.pow(l1, 2) + (long) Math.pow(l2, 2)));
					
				}
			}
			
			d = Double.parseDouble(br.readLine());
	    	double weight = 0L;

	    	q = new PriorityQueue<>();
	    	q.offer(new Edge(0, 0));
	    	
	    	while(!q.isEmpty()) {
	    		Edge e = q.poll();
	    		int v = e.x;
	    		long w = e.weight;
	    		
	    		if (visited[v]) continue;
	    		
	    		visited[v] = true;
	    		weight += w;
	    		
	    		for (Edge n : graph[v]) {
	    			if(!visited[n.x]) q.add(n);
	    		}
	    		
	    	}
	        
	        weight *= d;
	        weight += 0.5d;
	        
			System.out.printf("#%d %d\n", t, (long) weight);

		}
	}

}
