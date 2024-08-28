import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int[][] grid;
	static int N;
	static int M;
	
	static List<Integer> cctvTpe;
	static List<Integer[]> cctvIndex;

	static int answer;

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		// 감시
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		grid = new int[N][M];


		cctvTpe = new ArrayList<>();
		cctvIndex = new ArrayList<>();
		
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());

				if (0 < grid[i][j] && grid[i][j] < 6) {
					cctvTpe.add(grid[i][j]);
					cctvIndex.add(new Integer[] { i, j });

				}
			}
		}

		answer = Integer.MAX_VALUE;
		
		int[][] next = new int[N][M];

		for (int i = 0; i < N; i++) {
			System.arraycopy(grid[i], 0, next[i], 0, M);
		}

		make(0, next);
		
		System.out.println(answer);

	}
	
	static void check(int[][] g) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0;  j < M; j++) {
				if (g[i][j] == 0) {
					cnt ++;
				}
			}
		}
		answer = Math.min(answer, cnt);
	}

	static void make(int index, int[][] origin) {
		
		if (index == cctvIndex.size()) {
			// 완료된 경우
			check(origin);
			return;
		}

		int[][] next = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			System.arraycopy(origin[i], 0, next[i], 0, M);
		}

		int type = cctvTpe.get(index);
		
		switch (type) {

		case 1:
			check(index, next, new boolean[] { true, false, false, false });

			make(index + 1, next);
			
			for (int i = 0; i < N; i++) {
				System.arraycopy(origin[i], 0, next[i], 0, M);
			}
			
			check(index, next, new boolean[] { false, true, false, false });
			make(index + 1, next);
			for (int i = 0; i < N; i++) {
				System.arraycopy(origin[i], 0, next[i], 0, M);
			}
			
			check(index, next, new boolean[] { false, false, true, false });
			make(index + 1, next);
			for (int i = 0; i < N; i++) {
				System.arraycopy(origin[i], 0, next[i], 0, M);
			}
			check(index, next, new boolean[] { false, false, false, true });
			make(index + 1, next);
			for (int i = 0; i < N; i++) {
				System.arraycopy(origin[i], 0, next[i], 0, M);
			}
			break;
		case 2:
			check(index, next, new boolean[] { false, true, false, true });
			make(index + 1, next);
			for (int i = 0; i < N; i++) {
				System.arraycopy(origin[i], 0, next[i], 0, M);
			}
			check(index, next, new boolean[] { true, false, true, false });
			make(index + 1, next);
			for (int i = 0; i < N; i++) {
				System.arraycopy(origin[i], 0, next[i], 0, M);
			}
			break;
		case 3:
			check(index, next, new boolean[] { false, false, true, true });
			make(index + 1, next);
			for (int i = 0; i < N; i++) {
				System.arraycopy(origin[i], 0, next[i], 0, M);
			}
			
			check(index, next, new boolean[] { true, false, false, true });
			make(index + 1, next);
			for (int i = 0; i < N; i++) {
				System.arraycopy(origin[i], 0, next[i], 0, M);
			}
			
			check(index, next, new boolean[] { true, true, false, false });
			make(index + 1, next);
			for (int i = 0; i < N; i++) {
				System.arraycopy(origin[i], 0, next[i], 0, M);
			}
			
			check(index, next, new boolean[] { false, true, true, false });
			make(index + 1, next);
			for (int i = 0; i < N; i++) {
				System.arraycopy(origin[i], 0, next[i], 0, M);
			}
			
			break;
		case 4:
			
			check(index, next, new boolean[] { true, true, true, false });
			make(index + 1, next);
			for (int i = 0; i < N; i++) {
				System.arraycopy(origin[i], 0, next[i], 0, M);
			}
			
			check(index, next, new boolean[] { true, true, false, true });
			make(index + 1, next);
			for (int i = 0; i < N; i++) {
				System.arraycopy(origin[i], 0, next[i], 0, M);
			}
			
			check(index, next, new boolean[] { true, false, true, true });
			make(index + 1, next);
			for (int i = 0; i < N; i++) {
				System.arraycopy(origin[i], 0, next[i], 0, M);
			}
			
			check(index, next, new boolean[] { false, true, true, true });
			make(index + 1, next);
			for (int i = 0; i < N; i++) {
				System.arraycopy(origin[i], 0, next[i], 0, M);
			}
			break;
		case 5:
			
			check(index, next, new boolean[] { true, true, true, true });
			make(index + 1, next);
			for (int i = 0; i < N; i++) {
				System.arraycopy(origin[i], 0, next[i], 0, M);
			}
			break;
		}

	}

	static void check(int index, int[][] next, boolean[] temp) {
		Integer[] i = cctvIndex.get(index);

		int x = i[0];
		int y = i[1];

		for (int t = 0; t < 4; t++) {
			if (!temp[t])
				continue;
			
			int nx = dx[t] + x;
			int ny = dy[t] + y;
			
			while (nx >=0 && nx < N && ny >=0 && ny < M && next[nx][ny] != 6) {
				if (next[nx][ny] == 0) {
					next[nx][ny] = -1;
				}
				nx = nx + dx[t];
				ny = ny + dy[t];
			}

		}

	}

}