import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Solution {
	// 농작물 수확하기

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			int N = Integer.parseInt(br.readLine());
			
			int[][] grid = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				String[] st = br.readLine().trim().split("");
				for (int j = 0; j < N; j++) {
					grid[i][j] = Integer.parseInt(st[j]);
				}
			}
			
			int answer = 0;
			
			for (int i = 0; i < N / 2 + 1; i++) {
				for (int j = N/2 - i; j <= N/2 + i; j ++) {
					answer += grid[i][j];
				}
			}
			for (int i = N / 2  + 1; i < N; i++) {
				for (int j =(i - N/2); j < N - (i - N /2); j ++) {
					answer += grid[i][j];
				}
			}
			System.out.printf("#%d %d\n", t, answer);
			
		}

	}

}
