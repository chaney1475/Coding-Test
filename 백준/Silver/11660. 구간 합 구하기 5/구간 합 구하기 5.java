import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { // 구간 합 구하기 4
	
	static int N;
	static int M;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // N개의 숫자
		M = Integer.parseInt(st.nextToken()); // M 번 물어볼것
		
		
		int[][] grid = new int[N][N];
		
		dp = new int[N][N];
				
		int sumR = 0;
		int sumC = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j  = 0; j < N; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = grid[0][0];
		for (int i = 1; i < N; i++) {
			dp[0][i] = dp[0][i-1] + grid[0][i];
		}
		
		for (int i = 1; i< N; i++) {
			dp[i][0] = dp[i-1][0] + grid[i][0];
		}
		
		for (int i = 1; i < N; i++) {
			for (int j  = 1; j < N; j++) {
				dp[i][j] = dp[i -1][j] + dp[i][j-1] + grid[i][j] - dp[i-1][j-1];
			}
		}
		
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int aX = Integer.parseInt(st.nextToken()) - 1;
			int aY = Integer.parseInt(st.nextToken()) - 1;

			int bX = Integer.parseInt(st.nextToken()) - 1;
			int bY = Integer.parseInt(st.nextToken()) - 1;
			// 
			int answer;
			int t1 = 0; 
			int t2 = 0;
			int t3 = 0;
			
			if (aX - 1 >= 0){
				t1 = dp[aX -1][bY];
			}
			if(aY - 1 >= 0) {
				t2 = dp[bX][aY - 1];
			}
			if(aX - 1 >= 0 && aY - 1 >= 0) {
				t3 = dp[aX -1][aY - 1];
			}
			answer = dp[bX][bY] - t1 - t2 + t3;
			
			bw.write(answer + "\n");
		}
		
		bw.flush(); // 버퍼에 남은 데이터를 모두 출력
		bw.close(); // BufferedWriter 닫기
		br.close(); // BufferedReader 닫기
		
	}
	
}
