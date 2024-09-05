import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		// 파이프 옮기기
		int N = Integer.parseInt(br.readLine());
		int[][] grid = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][][] dp = new int[N][N][3];

		dp[0][1][0] = 1;
		
		for (int i = 2; i < N; i++) {
			if (grid[0][i] == 1)
				continue;
			dp[0][i][0] = dp[0][i - 1][0];
		}

		for (int i = 1; i < N; i++) {
			for (int j = 1; j < N; j++) {
				if (grid[i][j] == 1)
					continue;
				dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][1];
				if (grid[i][j-1] == 0 &&  grid[i-1][j] == 0) {
					dp[i][j][1] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
				}
				dp[i][j][2] = dp[i - 1][j][1] + dp[i - 1][j][2];
			}
		}
		

		System.out.println(dp[N - 1][N - 1][0] + dp[N - 1][N - 1][1] + dp[N - 1][N - 1][2]);

	}

}
