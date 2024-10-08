import java.util.*;
import java.io.*;

public class Main {
	
	static ArrayList<Edge>[] graph;
	
	static class Edge{
		int node;
		double dist;
		public Edge(int node, double dist){
			this.node = node;
			this.dist = dist;
			
		}
	}
	
	static class Point{
		int x,y;
		public Point(int x, int y){
			this.x = x;
			this.y =y;
		}
	}
	
	public static void main(String args[]) throws Exception {
		// 발전소 설치
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());// 발전소 갯수
		int M = Integer.parseInt(st.nextToken()); // 남아있는 전선의 수
		
		double limit = Double.parseDouble(br.readLine());
		
		Point[] station = new Point[N];
		
		graph = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		
		for (int i = 0; i < N;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			station[i] = new Point(x,y);
		} // 각각의 위치를 만들음
		
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				double tmp = calDist(station[i], station[j]);
				if (tmp <= limit) {
					graph[i].add(new Edge(j, tmp));
					graph[j].add(new Edge(i, tmp));
				}
			}
		}
		// 연결된 아이들
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) -1;
			int b = Integer.parseInt(st.nextToken()) -1;
			//듀개가 이어져있음
			graph[a].add(new Edge(b, 0));
			graph[b].add(new Edge(a, 0));
		}
		
		//0에서 N-1이 이어져야함
		
		PriorityQueue<Edge> q = new PriorityQueue<>((a,b) -> {
			return (int) (a.dist - b.dist);
		}); 
		
		q.add(new Edge(0, 0));
		double[] dp = new double[N];
		Arrays.fill(dp, Double.MAX_VALUE);
		dp[0] = 0.0;
		
		while (!q.isEmpty()) {
			Edge now = q.poll();
			
			int n = now.node;
			double d = now.dist; // 현재 노드까지 오는데에 d가 걸렸음
			
			if (n == N-1) {
				// 마지막 노드에 도달함
				break;
			}
			
			for (Edge next : graph[n]) {
				// n과 연결된 노드들을 보자!
				if (dp[next.node] > d + next.dist) {
					//나까지 온 값에 다가 
					dp[next.node] = d + next.dist;
					
					q.add(new Edge(next.node, d + next.dist));
				}
			}
		}
		System.out.println((int)(dp[N-1] * 1000));
		
	}
	
	static double calDist(Point p1, Point p2) {
		double n1 = Math.abs(p1.x - p2.x);
		double n2 = Math.abs(p1.y - p2.y);
		
		return Math.sqrt(n1* n1 + n2 * n2);
	}
	
}