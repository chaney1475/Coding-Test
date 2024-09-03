import java.io.*;
import java.util.*;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N;
	static int M;
	static int[][] grid;

	static int L;

	static Set<Integer>[] next = new HashSet[] { 
			new HashSet<>(Arrays.asList(1, 2, 5, 6)), // 0의 방향이 잇는 경우
			new HashSet<>(Arrays.asList(1, 3, 6, 7)), // 1의 방향이 있는 경
			new HashSet<>(Arrays.asList(1, 2, 4, 7)), // 2의 방향이 있는 경우
			new HashSet<>(Arrays.asList(1, 3, 4, 5)) // 3의 방향이 있는 경우
	};
	static List<Integer>[] dir = new ArrayList[] { 
			new ArrayList<>(), 
			new ArrayList<>(Arrays.asList(0, 1, 2, 3)),
			new ArrayList<>(Arrays.asList(0, 2)), 
			new ArrayList<>(Arrays.asList(1, 3)),
			new ArrayList<>(Arrays.asList(0, 1)),
			new ArrayList<>(Arrays.asList(1, 2)),
			new ArrayList<>(Arrays.asList(2, 3)), 
			new ArrayList<>(Arrays.asList(3, 0)) };

	public static void main(String[] args) throws Exception {
		// 탈주범 검거

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			L = Integer.parseInt(st.nextToken());

			grid = new int[N][M];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			System.out.printf("#%d %d\n", t, bfs(x, y));

		}
	}

	static class Position {
		int x;
		int y;
		int dist;

		Position(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static int bfs(int x, int y) {

		Queue<Position> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		visited[x][y] = true;
		q.offer(new Position(x, y, 0));

		int cnt = 1;
		while (!q.isEmpty()) {
			Position p = q.poll();
			if (p.dist == L - 1) continue;
			int type = grid[p.x][p.y]; // 현재 타입

			for (Integer d : dir[type]) { // 현재 타입에서 가능한 방향가져오기
				
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];

				if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
					if (next[d].contains(grid[nx][ny])) {
						visited[nx][ny] = true;
						cnt++;
						if (p.dist + 1 < L) {
							q.add(new Position(nx, ny, p.dist + 1));
						}
					}
				}
			}
			
		}
		return cnt;
	}

}
