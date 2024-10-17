import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static int M;
	static int V;
	
	static ArrayList<Integer>[] graph;
	
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N + 1];
		
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph[a].add(b);
			graph[b].add(a);
			
		}
		
		visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			graph[i].sort((a,b) -> a - b);
		}
		
		StringBuilder sb = new StringBuilder();
		
		visited[V] = true;
		dfs(V, sb);
		System.out.println(sb);
		
		visited = new boolean[N + 1];
		bfs(V);
		
	}
	
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;
		StringBuilder sb = new StringBuilder();
		
		while (!q.isEmpty()) {
			int now = q.poll();
			sb.append(now).append(" ");
			
			for (Integer next : graph[now]) {
				if (visited[next]) continue;
				visited[next] = true;
				q.add(next);
			}
		}
		
		System.out.println(sb);
	}
	
	static void dfs(int n, StringBuilder sb) {
		sb.append(n).append(" ");

		for (Integer next : graph[n]) {
			if (!visited[next]) {
				visited[next] = true;
				dfs(next, sb);
			}
		}
	}
	
}