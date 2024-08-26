import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Position {
	int x;
	int y;

	Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Solution {
	static boolean[][] visited;
	static int N;
	static int[][] grid;
	
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	
	static int answer ;

	public static int cntCheese() {
		int cnt = 0;
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && grid[i][j] != 0) {
					bfs(i,j);
					cnt ++;
				}
			}
		}
		if (answer < cnt) {
			answer = cnt;
		}

		return cnt;

	}

	public static void bfs(int i, int j) {

		Queue<Position> queue = new LinkedList<>();

		visited[i][j] = true;
		
		queue.add(new Position(i, j));
		
		while(!queue.isEmpty()) {
			Position p = queue.poll();
			int x = p.x;
			int y = p.y;
			for (int d = 0; d < 4; d ++) {
				int nx = dx[d] + x;
				int ny = dy[d] + y;
				if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && grid[nx][ny] != 0) {
					visited[nx][ny] = true;
					queue.add(new Position(nx, ny));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// 치즈도둑
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			grid = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}


			answer = 0;
			
			while (cntCheese() != 0) {
				
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (grid[i][j] > 0) {
							grid[i][j]--;
						}
					}
				}
				
			}
			System.out.printf("#%d %d\n", t, answer);

		}

	}

}
