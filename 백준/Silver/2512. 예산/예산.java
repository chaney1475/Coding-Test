import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;


	public static void main(String[] args) throws IOException {
		
		int N = Integer.parseInt(br.readLine());
		long[] A = new long[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int limit = Integer.parseInt(br.readLine());
		
		Arrays.sort(A);
		long s = 1;
		long e = A[N-1];
		long m;
		long ans = 0;
		
		while (s <= e) {
			m = (s + e) / 2;
			
			long sum = 0;
			for (int i = 0; i < N; i++) {
				if (m > A[i]) {
					sum += A[i];
				}else {
					sum += m;
				}
			}
			
			if (sum <= limit) {
				ans = m;
				s = m + 1;
			}else {
				e = m - 1;
			}
		}
		System.out.println(ans);
		
	}

}
