import java.io.*;
import java.util.*;

class Main {
	// 앱

	//실행중인 앱 활성화
	
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
			total += memory[i];
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
//		System.out.println(Arrays.toString(memory));
//		System.out.println(Arrays.toString(cost));
		int[] dp = new int[total + 1];
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = total; j >= memory[i]; j--) {
//				System.out.println("j " + j + " j - memory[i] " + (j - memory[i]));
				if (dp[j - memory[i]] != Integer.MAX_VALUE) {
					dp[j] = Math.min(dp[j - memory[i]] + cost[i] , dp[j]);
				}
				
			}
		}
		
		int ans = Integer.MAX_VALUE;
		
		for (int i = M; i <= total; i++) {
			ans = Math.min(ans, dp[i]);
		}
		
		System.out.println(ans);
	}
}