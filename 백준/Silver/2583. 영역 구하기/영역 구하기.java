import java.io.*;
import java.util.*;

public class Main {

	static List<Integer> answer;
	static int[][] grid;

	static int N;
	static int M;

	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { 1, -1, 0, 0 };

	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		// 얼어붙은 여행지
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		grid = new int[N][M];

		int K = Integer.parseInt(st.nextToken()); // 얼어붙은 영역의 갯수

		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int ax = Integer.parseInt(st.nextToken());
			int ay = Integer.parseInt(st.nextToken());

			int bx = Integer.parseInt(st.nextToken());
			int by = Integer.parseInt(st.nextToken());

			for (int j = ax; j < bx; j++) {
				for (int i = ay; i < by; i++) {
					grid[i][j] = 1;
				}
			}
		}

		answer = new ArrayList<>();
		visited = new boolean[N][M];
		
		check();
		answer.sort((a,b) -> {return Integer.compare(a, b);});
		
		System.out.println(answer.size());
		for (Integer j : answer) {
			sb.append(j).append(" ");
		}
		System.out.println(sb);

	}

	// 모두 방문을 했는지!
	static void check() {
		
		for (int i = 0; i < N; i++) {
			for ( int j = 0; j < M; j++) {
				if (!visited[i][j]) {
					int a = bfs(i, j, grid[i][j]);
					if (grid[i][j] == 0) {
						answer.add(a);
					}
				}
			}
		}

	}

	static class Position {
		int x;
		int y;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int bfs(int x, int y, int num) {
		int cnt = 1;
		visited[x][y] = true;
		Queue<Position> q = new LinkedList<>();
		q.offer(new Position(x,y));
		
		while(!q.isEmpty()) {
			
			Position p = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];
				if (nx >=0 && nx < N && ny >=0 && ny < M && !visited[nx][ny] && grid[nx][ny] == num) {
					cnt++;
					visited[nx][ny] = true;
					q.add(new Position(nx, ny));
				}
			}
		
		}
		return cnt;
	}


}
