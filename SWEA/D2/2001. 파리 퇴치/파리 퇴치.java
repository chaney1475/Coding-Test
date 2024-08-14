import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author SSAFY
 *
 */
public class Solution {
	
	static int N;
	static int M;
	
	static int[][] grid;
	
	static int answer;
	
	
	public static void main(String[] args) throws IOException{;
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {

			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			
			answer = 0;
			
			grid = new int[N][N];
			

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < N - M + 1; i++) {
				for(int j = 0; j < N - M + 1; j++) {
					getFlies(i,j);
				}
			}
			System.out.printf("#%d %d\n", t , answer);
		}
		
	}
	public static void getFlies(int x, int y) {
		int temp = 0;
		
		for(int i = x; i < x + M; i ++) {
			for(int j = y; j < y + M; j++) {
				temp += grid[i][j];
			}
		}
		
		if (answer < temp) {
			answer = temp;
		}
	}
}
