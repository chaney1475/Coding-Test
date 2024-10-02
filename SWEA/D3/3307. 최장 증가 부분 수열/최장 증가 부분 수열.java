import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		// 최장 공통 부분 수열
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] A = new int[N];

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}

			int[] ans = new int[N];
			
			int cnt = 1;
			ans[0] = A[N-1];

			for (int i = N-2; i >= 0; i--) {
				int num = A[i];

				if (num > ans[0]) {
					// 현재 수가 가장 큰 경우 추가
					ans[0] = num;
					
				}else if(num < ans[cnt - 1]) {
					ans[cnt++] = num;
				}
				
				
				else {
					// 이분 탐색으로 삽입 위치 찾기
					int s = 0;
					int e = cnt - 1;

					while (s < e) { // 둘이 같아질때 종료
						int m = (s + e) / 2;
						if (ans[m]>= num) {
							//같은 값중에 오른쪽으로 가도록
							s = m + 1;
						} else {
							e = m;
						}
					}
					ans[s] = num; // 적절한 위치에 값 갱신
				}

			}
			System.out.printf("#%d %d\n",t ,cnt);
		}
	}

}
