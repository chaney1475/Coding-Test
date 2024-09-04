
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// 1로 만들기
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		
		int[] dp = new int[x+1];
		Arrays.fill(dp,Integer.MAX_VALUE);
		
		Queue<Integer> q = new ArrayDeque<>();
		dp[x] = 0;
		q.add(x);
		
		while (!q.isEmpty()) {
			x = q.poll();
			if (x == 1) break;
			if (x % 3 == 0 && dp[x / 3] > dp[x] + 1) {
				dp[x / 3] = dp[x] + 1;
				q.add(x/3);
			}
			if (x % 2 == 0 && dp[x / 2] > dp[x] + 1) {
				dp[x / 2] = dp[x] + 1;
				q.add(x/2);
			}
			if (x > 0 && dp[x-1] > dp[x] + 1) {
				dp[x-1] = dp[x] + 1;
				q.add(x-1);
			}
		}
		System.out.println(dp[1]);

	}

}
