import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	// 지뢰 찾기
	static class Position {
		int x;
		int y;

		Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static boolean[][] visited;
	static int N;
	static char[][] grid;
	static int[][] cnt;

	static int[] dx = { 0, 0, -1, 1, 1, -1, 1, -1 };
	static int[] dy = { 1, -1, 0, 0, 1, -1, -1, 1 };

	public static int cntBomb() {
		int countZ = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && cnt[i][j] == 0) {
					bfs(i, j);
					countZ++;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 방문이 안되어있고 -1이 아닌 경우
				if (!visited[i][j] && cnt[i][j] != -1) {
					visited[i][j] = true;
					countZ++;
				}
			}
		}
		return countZ;

	}

	public static void bfs(int i, int j) {

		Queue<Position> queue = new LinkedList<>();

		visited[i][j] = true;

		queue.add(new Position(i, j));

		while (!queue.isEmpty()) {
			Position p = queue.poll();
			int x = p.x;
			int y = p.y;
			for (int d = 0; d < 8; d++) {
				int nx = dx[d] + x;
				int ny = dy[d] + y;
				if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
					visited[nx][ny] = true;
					if (cnt[nx][ny] == 0) {
						queue.add(new Position(nx, ny));
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			grid = new char[N][N];
			cnt = new int[N][N];

			visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					grid[i][j] = s.charAt(j);
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int temp = 0;
					if (grid[i][j] == '*') {
						cnt[i][j] = -1;
						continue;
					}
					for (int d = 0; d < 8; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						if (nx >= 0 && nx < N && ny >= 0 && ny < N && grid[nx][ny] == '*') {
							temp++;
						}
					}
					cnt[i][j] = temp;

				}
			}

			int answer = cntBomb();

			System.out.printf("#%d %d\n", t, answer);

		}

	}

}
