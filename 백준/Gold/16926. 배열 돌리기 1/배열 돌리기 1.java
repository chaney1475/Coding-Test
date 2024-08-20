import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	// 배열 돌리기
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int round = Math.min(N / 2, M /2);
		
		int[][] grid = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//한번 돌리기
		
		for (int r = 0; r < R; r++) {

			for (int i = 0; i < round; i++) {
				
				// x = 시작 + (i) || 끝 - (i) 
				// y = 시작 + (i) || 끝 - (i)
				int temp = grid[i][i]; // 끄트머리 저장
				
				for (int j = i; j < M - i - 1; j ++) {
					grid[i][j] = grid[i][j+1];
				}
			
				for (int j = i; j < N - i - 1; j++) {
					grid[j][M-i - 1] = grid[j+1][M-i -1];
				}
				
				for (int j = M - i - 1; j > i; j--) {
					grid[N - i - 1][j] = grid[N - i - 1][j - 1];
				}
				
				for (int j = N - i -1; j > i + 1; j --) {
					grid[j][i] = grid[j-1][i];
				}
				grid[i+1][i] = temp;
				
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}
}
