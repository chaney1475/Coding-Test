
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main { // 구간 합 구하기 4
	
	static int N;
	static int M;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // N개의 숫자
		M = Integer.parseInt(st.nextToken()); // M 번 물어볼 것
		
		st = new StringTokenizer(br.readLine());
		
		dp = new int[N];
				
		int sum = 0;
		for(int i = 0; i < N; i++) {
			sum += Integer.parseInt(st.nextToken());
			dp[i] = sum;
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int answer;
			int k = Integer.parseInt(st.nextToken());
			int kk = Integer.parseInt(st.nextToken());
			if (k == 1) {
				answer = dp[kk-1];
			} else {
				answer = dp[kk-1] - dp[k-2];
			}
			bw.write(answer + "\n");
		}
		
		bw.flush(); // 버퍼에 남은 데이터를 모두 출력
		bw.close(); // BufferedWriter 닫기
		br.close(); // BufferedReader 닫기
	}
}
