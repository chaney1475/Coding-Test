import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static boolean flag;

	static ArrayList<ArrayList<Integer>> graph;

	public static void main(String[] args) throws IOException {
		// ABCDE
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		flag = false;
		for (int i = 0; i < N; i++) {
			makeDfs(i);
			if (flag) break;
		}
		System.out.println(flag ? 1 : 0);

	}

	static boolean[] visited;
	static void makeDfs(int r) {

		visited = new boolean[N];

		visited[r] = true;

		dfs(r, 1);
		
	}

	static void dfs(int start, int d) {
		
		if (d == 5) {
			flag = true;
			return;
		}
		
		for (int i : graph.get(start)) {
			if (visited[i])
				continue;

			visited[i] = true;
			dfs(i, d + 1);

			visited[i] = false;
		}

	}

}
