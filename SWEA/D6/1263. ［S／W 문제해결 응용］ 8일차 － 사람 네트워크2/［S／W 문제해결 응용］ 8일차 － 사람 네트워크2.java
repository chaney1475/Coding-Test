import java.io.*;
import java.util.*;

public class Solution {

	static int ans;
	static int[][] map;
	static int N;
	static int X;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (i != j && map[i][j] == 0) {
						map[i][j] = Integer.MAX_VALUE;
					}
				}
			}
			
			//픟로이드 워셜
			
			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					for(int j = 0; j < N; j++) {
						if (map[i][k] != Integer.MAX_VALUE && map[k][j] != Integer.MAX_VALUE) {
							map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
						}
					}
				}
			}
			
			ans = Integer.MAX_VALUE;
			for (int i = 0; i < N;i++) {
				int sum = 0;
				for (int j = 0; j < N; j++) {
					sum += map[i][j];
				}
				ans = Math.min(ans, sum);
			}
			System.out.printf("#%d %d\n", t, ans);
		}
	}
}
