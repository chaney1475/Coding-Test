import java.io.*;
import java.util.*;

public class Main {

	static int[][][] dp;
	static int[][] grid;
	static int N, M;

	static int[] dx = { 0, -1, 0 };
	static int[] dy = { -1, 0, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		dp = new int[N][M][3];
		grid = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
				// dp 갱신을 위한 작은 값으로 초기화
				Arrays.fill(dp[i][j], Integer.MIN_VALUE);
			}
		}
		// 시작 위치는 모두 같은 값으로 초기화
		Arrays.fill(dp[0][0], grid[0][0]);

		// 초기화
		for (int j = 1; j < M; j++) {
			dp[0][j][0] = grid[0][j] + dp[0][j-1][0];
		}

		for (int i = 1; i < N; i++) {
			for (int j = M; j >= 0; j--) {
				//내 현재 위치에서 가능한 방향고려
				for (int d = 0; d < 3; d++) {
					int nx = dx[d] + i;
					int ny = dy[d] + j;

					// 해당 위치가 그리드를 벗어난 경우
					if (nx < 0 || nx >= N || ny < 0 || ny >= M)
						continue;
					
					if (d == 0) {//왼쪽 일때
						int newD = Math.max(dp[nx][ny][0], dp[nx][ny][1]);
						if (newD != Integer.MIN_VALUE) {
							dp[i][j][0] = newD + grid[i][j];
						}
					} else if (d == 2) {
						int newD = Math.max(dp[nx][ny][2], dp[nx][ny][1]);
						if (newD != Integer.MIN_VALUE) {
							dp[i][j][2] = newD + grid[i][j];
						}
					} else {
						int newD = Math.max(dp[nx][ny][0],(Math.max(dp[nx][ny][2], dp[nx][ny][1])));
						if (newD != Integer.MIN_VALUE) {
							dp[i][j][1] = newD + grid[i][j];
						}
					}
				}
			}
			for (int j = 0; j < M; j++) {
				//내 현재 위치에서 가능한 방향고려
				for (int d = 0; d < 3; d++) {
					int nx = dx[d] + i;
					int ny = dy[d] + j;

					// 해당 위치가 그리드를 벗어난 경우
					if (nx < 0 || nx >= N || ny < 0 || ny >= M)
						continue;
					
					if (d == 0) {//왼쪽 일때
						int newD = Math.max(dp[nx][ny][0], dp[nx][ny][1]);
						if (newD != Integer.MIN_VALUE) {
							dp[i][j][0] = newD + grid[i][j];
						}
					} else if (d == 2) {
						int newD = Math.max(dp[nx][ny][2], dp[nx][ny][1]);
						if (newD != Integer.MIN_VALUE) {
							dp[i][j][2] = newD + grid[i][j];
						}
					} else {
						int newD = Math.max(dp[nx][ny][0],(Math.max(dp[nx][ny][2], dp[nx][ny][1])));
						if (newD != Integer.MIN_VALUE) {
							dp[i][j][1] = newD + grid[i][j];
						}
					}
				}
			}
		}

		System.out.println(Math.max(dp[N-1][M-1][2], Math.max(dp[N-1][M-1][0], dp[N-1][M-1][1])));

	}

}
