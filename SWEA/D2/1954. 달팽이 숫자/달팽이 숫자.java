import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] grid =  new int[N][N];
			
			for(int i = 1; i<= N; i++) {
				grid[0][i-1] = i; 
			}
			int flag = 0;
			int[] dx = {1, 0, -1, 0};
			int[] dy = {0, -1, 0, 1};
			
			int start = N+1;
			
			int x = 0;
			int y = N-1;
			
			for(int i = N -1; i > 0; i--) {
				for (int k = 0; k < 2; k ++) {
					for (int j = 0; j <i; j ++) {
						x = dx[flag] + x;
						y = dy[flag] + y;
						grid[x][y] = start++;
					}
					flag = (flag + 1) % 4;
				}
				
			}
			
            System.out.printf("#%d\n", t);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(grid[i][j] + " ");
				}
				System.out.println();
			}
			
		}
		

	}

}
