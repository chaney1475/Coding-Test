import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int dp[][];
	
	
	static int N;
	static int L;
	
	public static void main(String[] args) throws IOException {
		// 햄다 - dp
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			

			dp = new int[N+1][L + 1];
			
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				int taste = Integer.parseInt(st.nextToken());
				int cal = Integer.parseInt(st.nextToken());
				for (int j = 0; j < cal; j++) {
					dp[i][j] = dp[i-1][j];
				}
				for (int j = cal; j <= L; j++) {
					dp[i][j] = Math.max(dp[i - 1][j-cal] + taste, dp[i-1][j]);
				}
			}
			System.out.printf("#%d %d\n", t, dp[N][L]);
			
		}

	}

}
