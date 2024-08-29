
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	// 하나로
	static class Edge implements Comparable<Edge>{

		int x;
		int y;
		long weight;
		
		Edge(int x, int y, long weight){
			this.x = x;
			this.y = y;
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

			q = new PriorityQueue<>();

			rep = new int[N + 1];
			
			for (int i = 1; i < N + 1; i++) {
				rep[i] = i;
			}
			
			E = N * (N + 1) / 2;
			
			List<long[]> islands = new ArrayList<>();
			
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
					
					q.offer(new Edge(i, j, (long) Math.pow(l1, 2) + (long) Math.pow(l2, 2)));
				}
			}
			
			d = Double.parseDouble(br.readLine());
					
			// 사이클 확인 (union-find)
	    	double weight = 0L;
	        while(!q.isEmpty()) {
	            Edge cur = q.poll(); // 가중치가 가장 작은 간선
	            // 부모노드가 다를때만 (사이클X)
	            if(union(cur.x, cur.y)) {
	                weight += cur.weight;
	            }
	        }
	        
	        weight *= d;
	        weight += 0.5d;
	        
			System.out.printf("#%d %d\n", t, (long) weight);

		}
	}

	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x == y) {
			return false;
		}
		if (x <= y)
			rep[y] = x;
		else
			rep[x] = y;
		return true;
	}

	static int find(int x) {
		if (x != rep[x]) {
			rep[x] = find(rep[x]);
		}
		return rep[x];
	}

}
