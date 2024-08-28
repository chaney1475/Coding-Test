import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Position {
		int x;
		int y;
		int dist;

		Position(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}

	static int grid[][];
	static int cnt[][];

	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		// 미로 탐색

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		grid = new int[N][M];
		
		cnt = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			Arrays.fill(cnt[i], Integer.MAX_VALUE);
		}
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				grid[i][j] = s.charAt(j) - '1' + 1;
			}
		}
		
		
		Queue<Position> q = new LinkedList<>();
		
		// 무조건 N-1, M-1까지 가야함
		q.offer(new Position(0,0,1));
		
		while(!q.isEmpty()) {
			Position p = q.poll();
			int x = p.x;
			int y = p.y;
			
			int nx;
			int ny;
			int nd = p.dist + 1;
			
			for (int d = 0; d < 4; d++) {
				nx = x + dx[d];
				ny = y + dy[d];
				
				if (nx >=0 && nx < N && ny >=0 && ny < M && grid[nx][ny] == 1) {
					//1로 경로가 있는 경우에
					if (cnt[nx][ny] > nd) {
						cnt[nx][ny] = nd;
						q.add(new Position(nx, ny, nd));
					}
				}
			}
			
		}
		System.out.println(cnt[N-1][M-1]);
	}

}
