import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;


	public static void main(String[] args) throws IOException {
		
		// 나무 수, 상근이가 집으로 가져가려고 하는 나무의 길이
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		long[] A = new long[N];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);
		
		long s = 0;
		long e = A[N-1];
		
		long ans = 0;
		
		while (s <= e) {
			long m = (s + e) / 2;
			
			long len = 0;
			for (int i = 0; i < N; i++) {
				if (m >= A[i]) continue;
				len += A[i] - m; // 가져갈 수 있는 길이 모으기
			}
			if (len >= M) {
				ans = m;
				s = m + 1;
			}else {
				e = m - 1;
			}
			
		}
		
		System.out.println(ans);
	}

}
