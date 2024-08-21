import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] grid;
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		// 배열돌리기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int r_num = Integer.parseInt(st.nextToken());

		grid = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < r_num; i++) {
			int r = Integer.parseInt(st.nextToken());

			switch (r) {
			case 1:
				oper1();
				break;
			case 2:
				oper2();
				break;
			case 3:
				oper3();
				break;
			case 4:
				oper4();
				break;
			case 5:
				oper5();
				break;
			default:
				oper6();
				break;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void oper1() {
		int start = 0;
		int end = N - 1;

		while (start <= end) {
			int[] temp = grid[start];
			grid[start] = grid[end];
			grid[end] = temp;
			start++;
			end--;
		}
	}

	static void oper2() {
		for (int i = 0; i < N; i++) {
			int start = 0;
			int end = M - 1;
			while (start <= end) {
				int temp = grid[i][start];
				grid[i][start] = grid[i][end];
				grid[i][end] = temp;
				start++;
				end--;
			}
		}
	}

	static void oper3() {

		int[][] nextGrid = new int[M][N];

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				nextGrid[i][j] = grid[N - 1 - j][i];
			}
		}

		int temp = N;
		N = M;
		M = temp;

		grid = nextGrid;

	}

	static void oper4() {
		int[][] nextGrid = new int[M][N];

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				nextGrid[i][j] = grid[j][M - i - 1];
			}
		}

		int temp = N;
		N = M;
		M = temp;

		grid = nextGrid;
	}

	static void oper5() {
		// 분면 오른쪽으로 돌리기
		int n = N / 2;
		int m = M / 2;
		
		int[][] temp = new int[n][m];
		for (int i = 0; i< n; i ++) {
			for (int j = 0; j < m; j ++) {
				temp[i][j] = grid[i][j];
			}
		}
		
		for (int i = 0; i< n; i ++) {
			for (int j = 0; j < m; j ++) {
				grid[i][j] = grid[i+n][j];
			}
		}
		for (int i = n; i < N; i ++) {
			for (int j = 0; j < m; j ++) {
				grid[i][j] = grid[i][j+m];
			}
		}
		for (int i = n; i < N; i ++) {
			for (int j = m; j < M; j ++) {
				grid[i][j] = grid[i-n][j];
			}
		}
		for (int i = 0; i < n; i ++) {
			for (int j = m; j < M; j ++) {
				grid[i][j] = temp[i][j-m];
			}
		}
		
	}

	static void oper6() {
		oper5();
		oper5();
		oper5();
	}
}
