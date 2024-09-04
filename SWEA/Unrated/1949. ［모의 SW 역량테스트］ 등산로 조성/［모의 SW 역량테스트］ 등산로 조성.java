import java.io.*;
import java.util.*;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N;
	static int K;

	static int top;
	static List<Integer[]> topList;

	static int[][] grid;
	static boolean[][] visited;

	static int ans;

	public static void main(String[] args) throws IOException {
		// 등산

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken()); // 한변의 길이
			K = Integer.parseInt(st.nextToken()); // 최대 공사 가능 깊이

			grid = new int[N][N];
			top = 0;
			topList = new ArrayList<Integer[]>();

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int temp = Integer.parseInt(st.nextToken());

					if (temp == top) {
						topList.add(new Integer[] { i, j });
					} else if (temp > top) {
						topList.clear();
						topList.add(new Integer[] { i, j });
						top = temp;
					}
					grid[i][j] = temp;
				}
			}
			ans = 0;

			for (Integer[] i : topList) {
				visited = new boolean[N][N];
				visited[i[0]][i[1]] = true;
				make(i[0], i[1], 1, false);
				visited[i[0]][i[1]] = false;
			}
			System.out.printf("#%d %d\n", t, ans);

		}

	}

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	static void make(int x, int y, int dist, boolean used) {
		
		ans = Math.max(dist, ans);

		for (int d = 0; d < 4; d++) {
			int nx = dx[d] + x;
			int ny = dy[d] + y;
			if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny])
				continue;
			
			if (grid[nx][ny] < grid[x][y]) {
				visited[nx][ny] = true;
				make(nx, ny, dist + 1, used);
				visited[nx][ny] = false;
			} else {
				if (!used) {
					int diff = grid[nx][ny] - grid[x][y];
					if (diff < K) {
						int ori = grid[nx][ny];
						grid[nx][ny] = grid[x][y] - 1;

						visited[nx][ny] = true;
						make(nx, ny, dist + 1, true);

						visited[nx][ny] = false;
						grid[nx][ny] = ori;
					}
				}

			}
		}

	}

}
