import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		// RGB 거리

		int N = Integer.parseInt(br.readLine());

		int[] dp = new int[3]; // 이전

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			if (i == 0) {
				dp[0] = Integer.parseInt(st.nextToken());
				dp[1] = Integer.parseInt(st.nextToken());
				dp[2] = Integer.parseInt(st.nextToken());
				continue;
			}
			
			int[] next = new int[3];
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			// 첫번째
			next[0] = Math.min(dp[1] + a, dp[2] + a);
			next[1] = Math.min(dp[0] + b, dp[2] + b);
			next[2] = Math.min(dp[0] + c, dp[1] + c);
			
			dp = next;
		}
		int minD = dp[0];
		minD = Math.min(minD,dp[1]);
		minD = Math.min(minD,dp[2]);
		System.out.println(minD);
	}

}
