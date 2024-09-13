import java.io.*;
import java.util.*;

public class Main {

	static int last;

	public static void main(String[] args) throws Exception {
		// 가장 긴 증가하는 부분 수열

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		int[] arr = new int[N];
		last = 0;

		for (int i = N - 1; i >= 0; i--) {
			update(A[i], arr);
		}
		System.out.println(last);

	}

	static void update(int x, int[] arr) {
		if (last == 0 || x < arr[last - 1]) {
			arr[last++] = x;
			return;
		}

		int s = 0;
		int e = last - 1;

		int ans = 0;

		while (s <= e) {
			int m = (s + e) / 2;
			if (arr[m] > x) {
				s = m + 1;
			} else {
				e = m - 1;
				ans = m;
			}
		}
		arr[ans] = x;

	}

}
