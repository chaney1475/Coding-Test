import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;

	static int[][] grid;
	static int N;

	public static void main(String[] args) throws IOException {
		// 녹색옷 입은 애가 젤다지?
		sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		int index = 1;
		while (N != 0) {
			grid = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			sb.append("Problem ").append(index++).append(": ").append(bfs()).append("\n");
			N = Integer.parseInt(br.readLine());
		}
		
		System.out.println(sb);

	}

	static class Position {
		int x;
		int y;

		Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	static int bfs() {
		int[][] dist = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		dist[0][0] = grid[0][0];

		Queue<Position> q = new LinkedList<>();
		q.offer(new Position(0, 0));

		while (!q.isEmpty()) {
			Position p = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = dx[d] + p.x;
				int ny = dy[d] + p.y;
				if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
					if (dist[nx][ny] > dist[p.x][p.y] + grid[nx][ny]) {
						dist[nx][ny] = dist[p.x][p.y] + grid[nx][ny];
						q.add(new Position(nx, ny));
					}
				}
			}
		}
		return dist[N - 1][N - 1];
	}

}
