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

			ans = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken()); // 경사로의 길이

			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			ans = 0;

			for (int i = 0; i < N; i++) {
				if ((check(map[i]))) {
					ans++;
				}
			}

			for (int j = 0; j < N; j++) {
				int[] a = new int[N];

				for (int i = 0; i < N; i++) {
					a[i] = map[i][j];
				}

				if (check(a)) {
					ans++;
				}
			}

			System.out.printf("#%d %d\n", t, ans);
		}
	}

	static boolean check(int[] arr) {

		boolean[] used = new boolean[N];
		for (int i = 0; i < N - 1; i++) {
			if (arr[i] == arr[i + 1])
				continue;
			if (Math.abs(arr[i] - arr[i + 1]) > 1)
				return false;

			if (arr[i] - arr[i + 1] == 1) {
				// 내려감
				for (int j = 1; j <= X; j++) {
					// 범위 내에 잇어야하고, 그 다음 수와 일치해야하고, 사용하지 않았어야함
					if (i + j >= N || arr[i + j] != arr[i + 1] || used[i + j])
						return false;
					used[i + j] = true;
				}
			} else if (arr[i] - arr[i + 1] == -1) {
				// 올라감
				for (int j = 0; j < X; j++) {
					if (i - j < 0 || arr[i - j] != arr[i] || used[i - j])
						return false;
					used[i - j] = true;
				}
			}

		}
		return true;

	}

}
