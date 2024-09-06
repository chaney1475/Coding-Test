import java.io.*;
import java.util.*;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N; // 나무 갯수
	static int[] tree;
	static int max;

	static int[][] dp;

	static ArrayList<Integer> diff;

	public static void main(String[] args) throws IOException {
		// 나무 높이
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			// 나무의 갯수
			N = Integer.parseInt(br.readLine());

			tree = new int[N];
			st = new StringTokenizer(br.readLine());

			max = 0;

			for (int i = 0; i < N; i++) {
				int temp = Integer.parseInt(st.nextToken());
				max = Math.max(max, temp);
				tree[i] = temp;
			}
			diff = new ArrayList<>();

			int days = 0;

			int one = 0;
			int two = 0;

			for (int i = 0; i < N; i++) {
				int diff = max - tree[i];
				if (diff % 2 == 0) {
					two += diff / 2;
				} else {
					two += diff / 2;
					one++;
				}
			}

			days += Math.min(one, two) * 2;

			if (two > one) {
				int left = two - one;
				days += (left * 2 / 3) * 2;
				days += (left * 2 % 3);

			} else if (one > two) {
				days += (one - two) * 2 - 1;
			}

			System.out.printf("#%d %d\n", t, days);

		}

	}
}
