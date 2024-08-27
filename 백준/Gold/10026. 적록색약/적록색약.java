import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static class Position {
		int x;
		int y;

		Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	static int N;
	static char[][] grid;
	static boolean[][] visited;

	static int colorBlind() {
		// 빨강과 초록을 동일하게 취급
		int cnt = 0;
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					bfs(i, j, true);
					cnt++;
				}
			}
		}

		return cnt;
	}

	static int nonColorBlind() {
		int cnt = 0;

		// 다 따로 취급
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					bfs(i, j, false);
					cnt++;
				}
			}
		}

		return cnt;
	}

	static void bfs(int i, int j, boolean redGrean) {
		// readGrean true 일때는 R == G로 취급

		char color = grid[i][j];

		visited[i][j] = true;
		Queue<Position> q = new LinkedList<>();

		q.add(new Position(i, j));

		while (!q.isEmpty()) {

			Position p = q.poll();
			int x = p.x;
			int y = p.y;

			int nx;
			int ny;

			for (int d = 0; d < 4; d++) {
				nx = x + dx[d];
				ny = y + dy[d];

				if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
					char now = grid[nx][ny];
					if (!redGrean) {
						if (color == now) {
							visited[nx][ny] = true;
							q.add(new Position(nx, ny));
						}

					} else {
						if (color == 'R' || color == 'G') {
							if (now == 'R' || now == 'G') {
								visited[nx][ny] = true;
								q.add(new Position(nx, ny));
							}
						} else {
							if (color == now) {
								visited[nx][ny] = true;
								q.add(new Position(nx, ny));
							}
						}

					}

				}
			}
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		grid = new char[N][N];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				grid[i][j] = line.charAt(j);
			}
		}


		int a = nonColorBlind();
		int b = colorBlind();

		System.out.println(a + " " + b);

	}

}
