import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Position {
		int x;
		int y;
		int d;

		public Position(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}

	static int[] dx = { 0, -1, 0, };
	static int[] dy = { -1, 0, 1, };

	static int N;
	static int M;
	static int D;

	static int[][] grid;

	static ArrayList<Integer[]> possible = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		// 캐슬디펜스

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		grid = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		make(0, 0, new Integer[3]);

		int answer = 0;

		for (int i = 0; i < possible.size(); i++) {
			answer = Math.max(answer, attack(possible.get(i)));

		}

		System.out.println(answer);

	}

	static int attack(Integer[] temp) {
		int sum = 0;
		// 공격 부터
		int[][] gridCopy = new int[N][M];


		for (int i = 0; i < N; i++) {
			System.arraycopy(grid[i], 0, gridCopy[i], 0, M);
		}

		for (int h = 0; h < N; h++) { // N번 아래로 내려간다

			int[] last = new int[M];
			last[temp[0]] = 2;
			last[temp[1]] = 2;
			last[temp[2]] = 2;
			List<Position> lists = new ArrayList<>();

			for (int t = 0; t < 3; t++) {
				boolean[][] visited = new boolean[N][M];

				Position p = checkTarget(temp[t], visited, gridCopy);
				if (p != null) {
					lists.add(p);
				}
			}
			for (Position p : lists) {
				if (gridCopy[p.x][p.y] == 1) {
					gridCopy[p.x][p.y] = 0;
					sum++;
				}
			}

			for (int i = N - 1; i > 0; i--) {
				gridCopy[i] = gridCopy[i - 1];
			}

			gridCopy[0] = new int[M];


		}

		return sum;
	}

	static Position checkTarget(int k, boolean[][] visited, int[][] gridCopy) {

		Queue<Position> q = new LinkedList<>();

		q.add(new Position(N - 1, k, 1));
		visited[N-1][k] = true;

		while (!q.isEmpty()) {
			Position p = q.poll();
			
			int x = p.x;
			int y = p.y;

			if (gridCopy[x][y] == 1) {
				return new Position(x, y, 0);
			}
			
			int nx;
			int ny;
			int nd = p.d + 1;
			if (p.d == D) {
				continue;
			}
			for (int d = 0; d < 3; d++) {
				nx = dx[d] + x;
				ny = dy[d] + y;
				if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
					visited[nx][ny] = true;
					if (gridCopy[nx][ny] == 1) {
						return new Position(nx, ny, p.d+1);
					}
					if (nd <= D) {
						q.add(new Position(nx, ny, nd));
					}
				}
			}
		}

		return null;
	}

	static void make(int cnt, int index, Integer[] temp) {
		if (cnt == 3) {
			Integer[] t = new Integer[3];
			t[0] = temp[0];
			t[1] = temp[1];
			t[2] = temp[2];
			possible.add(t);
			return;
		}

		if (index == M) {
			return;
		}

		for (int i = index; i < M; i++) {
			temp[cnt] = i;
			make(cnt + 1, i + 1, temp);
		}

	}

}
