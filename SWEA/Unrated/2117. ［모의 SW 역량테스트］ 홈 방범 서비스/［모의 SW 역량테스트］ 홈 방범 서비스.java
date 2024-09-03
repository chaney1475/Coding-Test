import java.io.*;
import java.util.*;

public class Solution {

	static int N;
	static int M;
	
	static List<Integer[]> homes;
	
	static int answer;
	static int answer_cnt;
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		// 홈 방범 서비스
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			M = Integer.parseInt(st.nextToken()); // 하나의 집이 지불 할 수 있는 비용

			homes = new ArrayList<Integer[]>();
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int temp = Integer.parseInt(st.nextToken());
					if (temp == 1) {
						homes.add(new Integer[] {i,j});
					}
				}
			}
			answer = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cal(i,j);
				}
			}
			System.out.printf("#%d %d\n", t, answer);
			
		}

	}
	static void cal(int x, int y) {
		int cnt = 0;
		for (int d = 1 ; d <= N*2; d++) {
			cnt = 0;
			for (Integer[] h : homes) {
				int dist = Math.abs(x - h[0]) + Math.abs(y - h[1]);
				if (dist < d) {
					cnt++;
				}
			}
			int profit = cnt * M - (d * d + (d-1)* (d-1));
			
			if (profit >= 0) {
				answer = Math.max(answer, cnt);
			}
		}
	}

}
