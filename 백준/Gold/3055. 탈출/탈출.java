import java.util.*;
import java.io.*;

public class Main {
	static char[][] map;

	static int N;
	static int M;

	static int startX;
	static int startY;

	static int endX;
	static int endY;

	static int answer;

	public static void main(String[] args) throws Exception {
		// 물 이동 이후 비버가 감

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];

		Queue<int[]> q = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			String s = br.readLine();

			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'S') {
					startX = i;
					startY = j;
				} else if (map[i][j] == 'D') {
					endX = i;
					endY = j;
				} else if (map[i][j] == '*') {
					// 물 먼저 널기
					q.add(new int[] { i, j, '*', 0});
				}
			}
		}
		// 돌은 아예 안되는 지역
		// *이 있는 곳은 인접 리스트로 1씩 증가됨

		answer = Integer.MAX_VALUE;
		
		q.add(new int[] {startX, startY, 'S', 0});
		
		while (!q.isEmpty()) {
			int[] now = q.poll();
			
			int x = now[0];
			int y = now[1];
			int type = now[2];
			int d = now[3];
			
			
			if (x == endX && y == endY) {
				answer = d;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == 'X')
					continue;
				
				if (type == '*') {
					// 나는 물
					if (map[nx][ny] == '.' || map[nx][ny] == 'S') {
						q.add(new int[] { nx, ny, '*', d + 1 });
						map[nx][ny] = '*';
					}
				}else{
					// 나는 고슴도치
					if (map[nx][ny] == '.' || map[nx][ny] == 'D') {
						q.add(new int[] { nx, ny, 'S', d + 1 });
						map[nx][ny] = 'S';
					}
				}
			}

		}

		if (answer < Integer.MAX_VALUE) {
			System.out.println(answer);
		} else {
			System.out.println("KAKTUS");
		}

	}

	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };


}