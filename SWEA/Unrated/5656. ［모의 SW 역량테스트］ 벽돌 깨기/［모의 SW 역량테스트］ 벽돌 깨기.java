import java.util.*;
import java.io.*;

public class Solution {

	static class Position {
		int x;
		int y;
		int dist;

		Position(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
		
		@Override
		public String toString() {
			return "x: " + x+ "y: "  + y + "d " + dist + " ";
		}
	}

	static int N; // 구슬의 갯수

	static int H; // 높이
	static int W; // 너비

	static int ans;

	static int[][] map;

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			ans = Integer.MAX_VALUE;

			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			map = new int[H][W];

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			dfs(0, map); // 몇개를 팝해야하는지!

			// 결과 출력
			System.out.println("#" + t + " " + ans);
		}

		br.close();
	}

	static void dfs(int cnt, int[][] now) {

		int[][] ori = new int[H][W];

		for (int i = 0; i < H; i++) {
			// 원본 배열에 있는걸 새 배열
			System.arraycopy(now[i], 0, ori[i], 0, W);
		}

		if (cnt == N) {
			ans = Math.min(check(now), ans);
			return;
		}

//		for (int k = 0; k < H; k++) {
//			System.out.println(Arrays.toString(now[k]));
//		}

		for (int j = 0; j < W; j++) {

			int i = findI(j, now);

			boolean[][] visited = new boolean[H][W];

			bfs(visited, now, new Position(i, j, now[i][j]));

			now = sortMap(now);

			dfs(cnt + 1, now);

			// 복원하기
			for (int k = 0; k < H; k++) {
				System.arraycopy(ori[k], 0, now[k], 0, W);
			}
		}
	}

	static int findI(int j, int[][] now) {
		for (int i = 0; i < H; i++) {
			if (now[i][j] > 0) {
				return i;
			}
		}
		return H - 1;
	}

	static void bfs(boolean[][] visited, int[][] nowMap, Position start) {

		visited[start.x][start.y] = true;
		
		Queue<Position> q = new ArrayDeque<>();
		
		nowMap[start.x][start.y] = -1; 

		// 사방에 대해서 dist만큼 확인한다
		
		for (int i = 1; i < start.dist; i++) {
			for (int d = 0; d < 4; d++) {
				
				int nx = dx[d] * i + start.x;
				int ny = dy[d] * i + start.y;
				
				if(nx >= 0 && nx < H && ny >= 0 && ny < W) {
					//범위에 맞으면 넣어줌
					visited[nx][ny] = true;
					
					if (nowMap[nx][ny] >= 1) {
						q.add(new Position(nx, ny, nowMap[nx][ny]));
					}
					
				}
			}
		}
		
		for (Position p : q) {
			bfs(visited, nowMap,  p);
		}
		

	}

	static int[][] sortMap(int[][] nowMap) {
		// 정렬하기
		int[][] newMap = new int[H][W];

		for (int j = 0; j < W; j++) {
			int idx = H - 1;
			for (int i = H - 1; i >= 0; i--) {
				if (nowMap[i][j] == 0)
					break;
				else if (nowMap[i][j] > 0) {
					newMap[idx--][j] = nowMap[i][j];
				}

			}
		}
		return newMap;

	}

	static int check(int[][] now) {

		// 세로로 읽는데
		// 아래서부터 있는지 확인하기
		int cnt = 0;

		for (int j = 0; j < W; j++) {
			for (int i = H - 1; i >= 0; i--) {
				if (now[i][j] > 0) {
					cnt++;
				} else {
					break;
				}
			}
		}
		
//		System.out.println("--------- 결과 맵 ----------");
//		for (int i = 0; i < H; i++) {
//			System.out.println(Arrays.toString(now[i]));
//		}
//
		return cnt;
	}

}
