import java.util.*;
import java.io.*;

public class Main {

	private static class Edge {
		int to, idx;

		public Edge(int to, int idx) {
			this.to = to;
			this.idx = idx;
		}
	}

	static int n, m; // 정점, 간선
	static List<List<Edge>> graph;
	static boolean[] visited; // 정점 방문 확인
	static int dfsCount = 0; // dfs 횟수

	static List<Integer> edgePath; // DFS 간선 순서 확인
	static List<Integer> nodePath; // DFS 정점 순서 확인

	static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

		n = Integer.parseInt(stringTokenizer.nextToken());
		m = Integer.parseInt(stringTokenizer.nextToken());

		// 정점이 2개 이하
		if (n <= 2) {
			System.out.println(-1);
			return;
		}

		visited = new boolean[n + 1];
		visited[0] = true; // 0번 안씀

		graph = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 1; i <= m; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
			int u = Integer.parseInt(stringTokenizer.nextToken());
			int v = Integer.parseInt(stringTokenizer.nextToken());

			// 양방향
			graph.get(u).add(new Edge(v, i));
			graph.get(v).add(new Edge(u, i));
		}

		for (int i = 1; i <= n; i++) {
			// 방문 확인
			if (visited[i])
				continue;

			// 3개 이상의 그래프가 입력된 경우를 확인
			if (dfsCount == 2) {
				System.out.println(-1);
				return;
			}
			visited[i] = true;
			dfsCount++;

			edgePath = new ArrayList<>();
			nodePath = new ArrayList<>();
			nodePath.add(i);
			dfs(i);

			if (edgePath.size() == n - 1) {
				divide();
				break;
			}

			if (dfsCount == 1) {

				if (2 * nodePath.size() == n) {
					System.out.println(-1);
					return;
				}

				stringBuilder.append(nodePath.size()).append(" ")
				.append(n - nodePath.size()).append("\n");
			}

			// 정점 방문 순서 출력
			for (int node : nodePath) {
				stringBuilder.append(node).append(" ");
			}
			stringBuilder.append("\n");

			// 간선 방문 순서 출력
			for (int edge : edgePath) {
				stringBuilder.append(edge).append(" ");
			}
			stringBuilder.append("\n");

		}

		System.out.println(stringBuilder);

	}

	private static void divide() {
		stringBuilder.append(n - 1).append(" ").append(1);

		stringBuilder.append("\n");

		for (int i = 0; i < nodePath.size() - 1; i++) {
			stringBuilder.append(nodePath.get(i)).append(" ");
		}

		stringBuilder.append("\n");

		for (int i = 0; i < edgePath.size() - 1; i++) {
			stringBuilder.append(edgePath.get(i)).append(" ");
		}

		stringBuilder.append("\n");

		stringBuilder.append(nodePath.get(nodePath.size() - 1));

		stringBuilder.append("\n");
	}
	
	private static void dfs(int nodeIdx) {
		
		for (Edge edge : graph.get(nodeIdx)) {
			if (visited[edge.to])
				continue;
			visited[edge.to] = true;
			edgePath.add(edge.idx);
			nodePath.add(edge.to);

			dfs(edge.to);
		}

	}
}