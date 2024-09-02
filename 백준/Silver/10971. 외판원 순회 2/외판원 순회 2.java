import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

	static long[][] grid;
	static int N;
	static boolean[] visited;
	static long answer;
	public static void main(String[] args) throws  IOException {
		// 외판원 순회2
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		grid = new long[N][N];
		visited = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				grid[i][j] = Long.parseLong(st.nextToken());
			}
		}
		
		answer = Long.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			visited[i] = true;
			dfs(i, i, 0, 0);
			visited[i] = false;
		}
		
		System.out.println(answer);
	}
	
	static void dfs(int init, int start, long total, int cnt) {
		if (cnt == N - 1) {
			if (grid[start][init] == 0) return;
			answer = Math.min(answer, total + grid[start][init]);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (!visited[i] && grid[start][i] != 0) {
				visited[i] = true;
				dfs(init, i, total + grid[start][i], cnt +1);
				visited[i] = false;
			}
		}
	}

}
