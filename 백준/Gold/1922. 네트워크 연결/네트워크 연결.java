import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Edge implements Comparable<Edge> {
		int x;
		int y;
		int weight;

		public Edge(int x, int y, int weight) {
			this.x = x;
			this.y = y;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			if (this.weight < o.weight) {
				return -1;
			}
			return 1;
		}

	}

	static int V;
	static int E;
	static int[] rep;

	public static void main(String[] args) throws IOException {
		// 네트워크 연결
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		
		Queue<Edge> q = new PriorityQueue<>();
		
		rep = new int[V+1];
		
		for (int i = 1; i < V+1; i++) {
			rep[i] = i;
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			q.offer(new Edge(a,b,c));
			
		}
		
		int sum = 0;
		int eCnt = 0;
		
		while(!q.isEmpty()) {
			Edge e = q.poll();
			if ( union(e.x, e.y) ){
				sum += e.weight;
				eCnt++;
				if (eCnt == V-1) break;
			}
		}
		System.out.println(sum);

	}

	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x == y) {
			return false;
		}
		if (x < y)
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
