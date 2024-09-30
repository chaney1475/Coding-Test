import java.io.*;
import java.util.*;

class Main {
	// 앱

	// 실행중인 앱 활성화

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 갯수
		int M = Integer.parseInt(st.nextToken()); // 바이트 수

		// M 바이트 확보하는데 가장 적게 드는 비용
		//

		int[] memory = new int[N]; // 바이트
		int[] cost = new int[N]; // 끄는데 쓰이는 비용

		int total = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			memory[i] = Integer.parseInt(st.nextToken());

		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
			total += cost[i];
		}

//		System.out.println(Arrays.toString(memory));
//		System.out.println(Arrays.toString(cost));

		int[] dp = new int[total + 1];

		for (int i = 0; i < N; i++) {
			for (int j = total; j >= cost[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j - cost[i]] + memory[i]);
			}
		}

		int ans = 0;
		for (int i = 0; i <= total; i++) {
			if (dp[i] >= M) {
				ans = i;
				break;
			}
		}

		System.out.println(ans);
	}
}