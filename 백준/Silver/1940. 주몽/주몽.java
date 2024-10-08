import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());

		int M = Integer.parseInt(br.readLine());
		
		int[] A = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);
		
		int s = 0;
		int e = N-1;
		
		int cnt = 0;
		
		while(s < e) {
			int num = A[s] + A[e];
			if (num == M) {
				cnt++;
				s++;
				e--;
			}
			else if (num < M) { // 현재 숫자보다 만들어진 수가 작을 때
				s++;
				
			}else {// 현재 숫자가 더 큰경우
				e--;
			}
			
		}
		System.out.println(cnt);
		
	}
	
}