import java.util.*;
import java.io.*;

public class Main
{
    static int target;
    static int N;
    static boolean[] visited;
    static int[][] path;
    
    static int ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		target = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N];
		path = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			path[i] = new int[]{a,b,d};
		}
		
		ans = Integer.MAX_VALUE;
		
		dfs(0,0);
		System.out.println(ans);
		
	}
	static void dfs(int now, int total) {
		
		if (now <= target) {
			if(total + (target - now) < ans) {
				ans = total + (target - now);
			}
		}
		
		if(now >= target) return;
		
		for (int i = 0; i < N; i++) {
			//이미 방문을 햇거나 현재보다 작은 곳일 경우
			if (visited[i] || path[i][0] < now || path[i][1] > target) continue;
			visited[i] = true;
			dfs(path[i][1], total + path[i][2] + (path[i][0] - now));
			visited[i] = false;
		}
	}
}
