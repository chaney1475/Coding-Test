import java.io.*;
import java.util.*;

public class Main {

	static int K;
	static int[][] grid;
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		// 말이되고픈 원숭이
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		grid = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(bfs());

	}

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	static int[] hx = { 1, 2, -1, 1, -2, 2, -2, -1 };
	static int[] hy = { 2, 1, 2, -2, 1, -1, -1, -2 };

	static class Position {
		int x;
		int y;
		int leftK; // 남의 k횟수
		int dist;

		Position(int x, int y, int leftK, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.leftK = leftK;
		}
	}

	static int bfs() {
		Queue<Position> q = new LinkedList<>();

		q.offer(new Position(0, 0, K, 0));

		int[][][] dist = new int[N][M][K + 1];


		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				Arrays.fill(dist[i][j], Integer.MAX_VALUE);
			}
		}
		dist[0][0][K] = 0;

		while (!q.isEmpty()) {
			Position p = q.poll();

			if (p.leftK > 0) {
				for (int h = 0; h < 8; h++) {
					int nx = p.x + hx[h];
					int ny = p.y + hy[h];
					if (nx >= 0 && nx < N && ny >= 0 && ny < M && grid[nx][ny] == 0) {
						if (dist[nx][ny][p.leftK - 1] > p.dist + 1) {
							dist[nx][ny][p.leftK - 1] = p.dist + 1;
							q.add(new Position(nx, ny, p.leftK - 1, p.dist + 1));
						}
					}
				}
			}

			for (int d = 0; d < 4; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];
				if (nx >= 0 && nx < N && ny >= 0 && ny < M && grid[nx][ny] == 0) {
					if (dist[nx][ny][p.leftK] > p.dist + 1) {
						dist[nx][ny][p.leftK] = p.dist + 1;
						q.add(new Position(nx, ny, p.leftK, p.dist + 1));
					}
				}
			}
		}
		
		int min = Arrays.stream(dist[N - 1][M - 1])
				.filter(n -> n != Integer.MAX_VALUE) // Integer.MAX_VALUE 값 제외
				.min().orElse(-1); // 값이 없으면 -1 반환
		return min;

	}

}
