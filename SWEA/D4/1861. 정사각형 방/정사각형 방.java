import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] grid;
	static int answer;
	static int len;
	static int N;
	
	static boolean[][] visited;
	
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 정사각형방
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			grid = new int[N][N];
			visited = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < N; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			answer = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						
						int s = small(i,j, 0);
						int b = big(i,j, 0);

						int temp = 1 + s + b;
						
						int num = grid[i][j] - s;
						
						if (answer < temp) {
							len = num;
							answer = temp;
							
						}
						if (answer == temp) {
							if (num < len) {
								len = num;
							}
						}
					}
				}
			}
			
			
			System.out.printf("#%d %d %d\n", t, len, answer);
			
			
		}
	}
	static int small(int i, int j, int cnt) {
		
		for (int d = 0; d < 4; d++) {
			int nx = dx[d] + i;
			int ny = dy[d] + j;
			
			if ( nx >= 0 && nx < N && ny >= 0 && ny < N ) {
				if (!visited[nx][ny] && grid[nx][ny] == grid[i][j] - 1) {
					visited[nx][ny] = true;
					return small(nx, ny, cnt +1);
				}
			}
		}
		
		return cnt;
		
	}
	
	static int big(int i, int j, int cnt) {
		for (int d = 0; d < 4; d++) {
			int nx = dx[d] + i;
			int ny = dy[d] + j;
			if ( nx >= 0 && nx < N && ny >= 0 && ny < N ) {
				if (!visited[nx][ny] && grid[nx][ny] == grid[i][j] + 1) {
					visited[nx][ny] = true;
					return big(nx, ny, cnt +1);
				}
			}
		}
		return cnt;
	}

}
