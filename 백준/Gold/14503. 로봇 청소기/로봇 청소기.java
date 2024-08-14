import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	
	static int[][] grid;

	static int[] dx = {-1,0,1,0}; 
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		grid = new int[n][m];
		
		st = new StringTokenizer(br.readLine());
		
		int robotX = Integer.parseInt(st.nextToken());
		int robotY = Integer.parseInt(st.nextToken());
		
		// 로봇이 어느 방향을 보고 있는지  0, 1, 2, 3 --> 북 동 남 서 -> 반시계는 -1을 하는 것
		int robotDir = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = 0;

		// 종료 조건 -> 바라보는 방향의 뒤쪽이 벽인 경우!
		
		while(robotX >= 0 && robotX <n && robotY >= 0 && robotY < m) { // 벽안쪽에 잇는 경우!
			
			int oriX = robotX;
			int oriY = robotY;
			
			if(grid[robotX][robotY] == 0) { // 청소되지 않은 경우 청소
				grid[robotX][robotY] = 2;
				answer++;
				
			}
			
			for(int d = 1; d <= 4; d ++) { // 네번 돌 거임 d를 빼자
				int nextDir = robotDir - d;
				if (nextDir < 0) nextDir += 4; // 각 방향
				
				//
				
				int nx = robotX + dx[nextDir];
				int ny = robotY + dy[nextDir];
				
				if (nx >= 0 && nx <n && ny >= 0 && ny < m) {
					if (grid[nx][ny] == 0) {
						// 청소되지 않은 방향 발견
						robotX = nx;
						robotY = ny;
						robotDir = nextDir;
						break;
					}
				}
				
			}
			
			if(oriX == robotX && oriY == robotY) {
				//바뀐게 없다 -> 현재 방향의 반대로 고
				int nextDir = (robotDir + 2) % 4;
				int nx = robotX + dx[nextDir];
				int ny = robotY + dy[nextDir];
				
				if (nx < 0 || nx >= n || ny < 0 || ny >= m || grid[nx][ny] == 1) {
					System.out.println(answer);
					System.exit(0);
				}
				
				robotX = nx;
				robotY = ny;
				
			}
			
			
		}
		
	}
	
}
