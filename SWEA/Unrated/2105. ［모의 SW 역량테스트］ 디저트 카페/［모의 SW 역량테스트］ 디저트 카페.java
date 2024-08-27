import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int[][] grid;

	public static void main(String[] args) throws IOException {
		// 디저트 카페
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			// 초기화
			grid = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int answer = -1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int a = 1; a < N; a++) {
						for (int b = 1; b < N; b++) {
							answer = Math.max(answer, makePath(i, j, a, b));
						}
					}
				}
			}
			
			System.out.printf("#%d %d\n", t, answer);

		}

	}

	static int makePath(int i, int j, int a, int b) {

		if (j - a < 0) {
			return -1;
		}
		if (j + b >= N) {
			return -1;
		}
		if (i + a + b >= N) {
			return -1;
		}
		
		HashSet<Integer> set = new HashSet<>();

		for (int x = 0; x < a; x++) {
			i += 1;
			j -= 1;

			if (!set.add(grid[i][j])) {
				return -1;
			}
		}

		for (int x = 0; x < b; x++) {
			i += 1;
			j += 1;

			if (!set.add(grid[i][j])) {
				return -1;
			}
		}

		for (int x = 0; x < a; x++) {
			i -= 1;
			j += 1;

			if (!set.add(grid[i][j])) {
				return -1;
			}
		}

		for (int x = 0; x < b; x++) {
			i -= 1;
			j -= 1;

			if (!set.add(grid[i][j])) {
				return -1;
			}
		}

		return set.size();
	}

}
