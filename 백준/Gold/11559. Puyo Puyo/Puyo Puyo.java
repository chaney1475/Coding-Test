import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static char[][] grid;
	static boolean[][] visited;

	static int cnt;

	public static void main(String[] args) throws IOException {
		// 뿌요뿌요
		grid = new char[12][6];

		for (int i = 0; i < 12; i++) {
			String st = br.readLine();

			for (int j = 0; j < 6; j++) {
				grid[i][j] = st.charAt(j);
			}
		}
		
		int ans = 0;

		char[][] next;
		while (pop()) {
			// 모으기
			ans++;
			next = new char[12][6];
			for (int i = 0; i < 12; i++) {
				Arrays.fill(next[i], '.');
			}
			
			for (int j = 0; j < 6; j++) {
				int idx = 11;
				for (int i = 11; i >= 0; i --) {
					if (grid[i][j] == '.') break;
					if (Character.isAlphabetic(grid[i][j])) {
						next[idx--][j] = grid[i][j];
					}
				}
			}
			grid = next;
//			print(next);
			
		}
		System.out.println(ans);

	}
//	static void print(char[][] grid) {
//		for( int i = 0; i < 12; i++) {
//			System.out.println(Arrays.toString(grid[i]));
//		}
//		System.out.println();
//	}
	static boolean pop() {
		visited = new boolean[12][6];
		boolean flag = false;
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 6; j++) {
				if (visited[i][j] || grid[i][j] == '.' || grid[i][j] == 0)
					continue;
				cnt = 0;
				visited[i][j] = true;
				dfs(i, j, grid[i][j]);
				if (cnt >= 4) {
					flag = true;
					make0(i, j);
				}
			}
		}
		return flag;

	}

	static int[] dx = { 0, 1, -1, 0 };
	static int[] dy = { 1, 0, 0, -1 };

	static void dfs(int x, int y, char C) {
		cnt++;
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx < 0 || nx >= 12 || ny < 0 || ny >= 6 || visited[nx][ny] || grid[nx][ny] != C)
				continue;
			visited[nx][ny] = true;
			dfs(nx, ny, C);
		}
	}

	static void make0(int i, int j) {
		Queue<int[]> q = new LinkedList<int[]>();
		char C = grid[i][j];
		q.add(new int[] { i, j });
		grid[i][j] = 0;

		int x = 0;
		int y = 0;
		
		while (!q.isEmpty()) {
			int[] now = q.poll();
			x = now[0];
			y = now[1];
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx < 0 || nx >= 12 || ny < 0 || ny >= 6 || grid[nx][ny] != C)
					continue;
				grid[nx][ny] = 0;
				q.add(new int[] {nx, ny});
			}
		}

	}

}
