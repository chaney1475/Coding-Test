import java.io.*;
import java.util.*;

public class Main {

	static int K;
	static int N;

	static int[] A; // 랜선들

	static boolean check(long x) {
		int cnt = 0;
		for (int i = 0; i < K; i++) {
			cnt += A[i] / x;
		}
		return (cnt >= N);
	}

	public static void main(String[] args) throws Exception {
		// 랜선 자르기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		int big = 0;
		A = new int[K];

		for (int i = 0; i < K; i++) {
			int temp = Integer.parseInt(br.readLine());
			big = Math.max(temp, big);
			A[i] = temp;
		}

		long s = 1;
		long e = big;
        long ans = 0;
		while (s <= e) {
			long m = ((s + e) / 2);
			if (check(m)) {
				ans = m;
				s = m + 1; // 성공 시, 더 큰 값을 탐색하기 위해 s = m + 1
			} else {
				e = m - 1;
			}
		}
		System.out.println(ans); 
	}
}
