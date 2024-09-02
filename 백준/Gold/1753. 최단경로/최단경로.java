import java.io.*;
import java.util.*;

public class Main {

	static int V; // 노드의 수
	static int E; // 간선의 수

	static class Edge {
		int x;
		long weight;

		Edge(int x, long weight) {
			this.x = x;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws IOException {
		// 연구소
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

		for (int i = 0; i < V + 1; i++) {
			graph.add(new ArrayList<>());
		}

		int start = Integer.parseInt(br.readLine());

		for (int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long w = Long.parseLong(st.nextToken());

			graph.get(a).add(new Edge(b, w));
		}

		// 방문 여부를 확인할 boolean, start부터 end 까지의 최소 거리를 저장할 배열
		boolean[] visited = new boolean[V + 1];
		long[] dist = new long[V + 1];

		// 최소 거리 정보를 담을 배열 초기화
		Arrays.fill(dist, Long.MAX_VALUE);

		// 시작 정점
		dist[start] = 0;

		// 다익스트라 진행
		for (int i = 0; i < V; i++) { // 노드를 모두 방문하면 종요이므로 노드의 갯수만큼 반복
			Long nodeValue = Long.MAX_VALUE;
			int nodeIndx = 0;

			for (int j = 0; j < V + 1; j++) { // 각 노드를 돌기
				// 방문하지 않았고, 현재 모든 거리 비용중 최소를 찾기
				if (!visited[j] && dist[j] < nodeValue) {
					nodeValue = dist[j];
					nodeIndx = j;
				}
			}

			visited[nodeIndx] = true;

			for (int j = 0; j < graph.get(nodeIndx).size(); j++) { // 최소 비용의 간선을 찾기!
				Edge e = graph.get(nodeIndx).get(j);

				if (dist[e.x] > dist[nodeIndx] + e.weight) {
					dist[e.x] = (dist[nodeIndx] + e.weight);
				}
			}

		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < V + 1; i++) {
			if (dist[i] == Long.MAX_VALUE) {
				sb.append("INF").append("\n");
			} else {
				sb.append(dist[i]).append("\n");
			}
		}

		System.out.println(sb);

	}

}
