import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[][] dist;
	
	static boolean[] visited;
	
	static int[] work;
	static int[] home;
	static int[][] clients;
	
	static int answer;

	public static void main(String[] args) throws Exception {
		// 최적경로
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			
			work = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			home = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			
			clients = new int[N][2];
			
			dist = new int[N][N];
			
			for (int i = 0; i < N; i++){
				clients[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			}

			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					int d = Math.abs(clients[i][0] - clients[j][0]) + Math.abs(clients[i][1] - clients[j][1]);
					dist[i][j] = d;
					dist[j][i] = d;
				}
			}
			
			visited = new boolean[N];
			answer = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				// 각 클라이언트에서 부터 출발
				int tempD = Math.abs(work[0] - clients[i][0]) + Math.abs(work[1] - clients[i][1]);
				visited[i] = true;
				dfs(i,tempD);
				visited[i] = false;
			}
			System.out.printf("#%d %d\n", t, answer);
		}
	}
	
	static void dfs(int client, int tempDist) {
		boolean flag = true;
		
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				flag = false;
			}
		}
		if (flag) {
			int newTemp = tempDist + Math.abs(home[0] - clients[client][0]) + Math.abs(home[1] - clients[client][1]);
			if (answer > newTemp) {
				answer = newTemp;
			}
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(i, tempDist+ dist[client][i]);
				visited[i] = false;
			}
		}
		
	}

}
