import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int M;
	
	static int[][] map;
	static int cnt[];
	
	static int ans;
	
    public static void main(String args[]) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	cnt = new int[26];
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	map = new int[N][M];
    	
    	ans = 0;
    	
    	for (int i = 0; i < N; i++) {
    		String now = br.readLine();
    		for (int j = 0; j < M; j++) {
    			map[i][j] = now.charAt(j) - 'A';
    		}
    	}

    	cnt[map[0][0]]++;
    	dfs(1, 0, 0);
    	
    	System.out.println(ans);
    	
    }
    
    static int[] dx = new int[] {0,0,-1,1};
    static int[] dy = new int[] {-1,1,0,0};
    
    static void dfs(int tmp, int x, int y) {
    	
    	ans = Math.max(tmp, ans);
    	
    	for (int d = 0; d < 4; d++) {
    		
    		int nx = dx[d] + x;
    		int ny = dy[d] + y;
    		
    		if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
    		if (cnt[map[nx][ny]] == 0) {
    			cnt[map[nx][ny]]++;
    			dfs(tmp + 1, nx, ny);
    			cnt[map[nx][ny]]--;
    		}
    	}
    	
    }
    
}