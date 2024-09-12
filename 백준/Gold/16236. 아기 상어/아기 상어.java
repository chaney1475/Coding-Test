import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N;
	static int[][] grid;

	static int babyX;
	static int babyY;
	static int eating;
	static int size;

	static boolean[][] visited;

	static class Position {
		int x, y, dist;

		Position(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}

	public static void main(String[] args) throws IOException {
		// 아기 상어
		N = Integer.parseInt(br.readLine());

		grid = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if (temp == 9) {
					babyX = i; // 아기 상어 초기화
					babyY = j;
					size = 2;
					eating = 0;
					continue;
				}
				grid[i][j] = temp;
			}
		}

		int time = 0;
		while (true) {
			int[] found = findFish(babyX, babyY);
			if (found[0] == Integer.MAX_VALUE)
				break;

			// 찾은경우
			eating++;
			if (eating == size) {
				size++;
				eating = 0;
			}

			grid[found[0]][found[1]] = 0;

			time += found[2]; // 시간 더하기

			babyX = found[0];
			babyY = found[1];
		}

		System.out.println(time);

	}

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static int[] findFish(int i, int j) {
		int dist = Integer.MAX_VALUE; // 거리 초기화
		int fx = Integer.MAX_VALUE, fy = Integer.MAX_VALUE; // 위치 초기화

		Queue<Position> q = new LinkedList<>();
		q.offer(new Position(i, j, 0));
		visited = new boolean[N][N];
		visited[i][j] = true;

		while (!q.isEmpty()) {
			Position now = q.poll();
			int x = now.x;
			int y = now.y;
			int tempD = now.dist;

			if (grid[x][y] > 0 && grid[x][y] < size) { // 먹을 수 있는 물고기 if (dist == tempD) { // 거리가 같으면 위치 확인 후 갱신
				if (dist > tempD) {
					// 거리가 작으면 무조건 갱신
					dist = tempD;
					fx = x;
					fy = y;
				} else if (dist == tempD) {
					if (fx > x || (fx == x) && (fy > y)) {
						// 더위에 있거나 같은 높이인데 더 왼쪽에 있는 경우 갱신
						dist = tempD;
						fx = x;
						fy = y;
					}
				}
			}

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				// 범위를 벗어나거나 방문 햇거나 물고기 사이즈가 상어보다 더 크면 패스
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] || grid[nx][ny] > size)
					continue;
				visited[nx][ny] = true;
				q.offer(new Position(nx, ny, tempD + 1));
			}

		}

		return new int[] { fx, fy, dist };

	}

}
