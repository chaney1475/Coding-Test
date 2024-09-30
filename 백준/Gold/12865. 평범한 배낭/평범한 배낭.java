import java.io.*;
import java.util.*;

class Main {
	static int N; // 물건의 갯수
	static int K; // 가방의 부피

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 물건 갯수
		K = Integer.parseInt(st.nextToken()); // 가방의 무게

		int[][] dp = new int[N][K + 1]; // N개의 물건으로 합이 K가 됨

		int[] weight = new int[N];
		int[] value = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			weight[i] = Integer.parseInt(st.nextToken()); // 무게
			value[i] = Integer.parseInt(st.nextToken()); // 가치
		}

		for (int i = 0; i <= K; i++) {
			// 가능한 배낭에 물건 넣기!
			// 가능한 것은 부피가 넘지 않는 것
			if (weight[0] <= i) {
				dp[0][i] = value[0];
			}
		}

		for (int i = 1; i < N; i++) {
			// 무게 보다 작은것은 이전것 복사
			for (int j = 0; j <= K; j++) {
				
				dp[i][j] = dp[i - 1][j];
				
				if (j >= weight[i]) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - weight[i]] + value[i]);
				}
			}


		}

		int ans = 0;

		for (int i = 0; i < K + 1; i++) {
			ans = Math.max(dp[N - 1][i], ans);
		}

		System.out.println(ans);
	}
}