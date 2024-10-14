import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;
import java.io.*;

public class Solution {
	static int N;
	static int M;
	static int K;

	static Cell[][] map;

	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };

	static class Cell {
		int x;
		int y;
		int time;
		int getIn;
		int activeS;
		int deadS;

		public Cell(int x, int y, int time, int getIn, int activeS, int deadS) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
			this.getIn = getIn;
			this.activeS = activeS;
			this.deadS = deadS;
		}

		@Override
		public String toString() {
			return "Cell [x=" + x + ", y=" + y + ", time=" + time + ", getIn=" + getIn + ", activeS=" + activeS
					+ ", deadS=" + deadS + "]";
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			K = Integer.parseInt(st.nextToken());

			map = new Cell[n + K + 4][m + K + 4];

			N = n + K + 4;
			M = m + K + 4;

			int sN = K / 2;
			int sM = K / 2;

			
			// 먼저 시작하는게 먼저 나옴
			Queue<Cell> q = new PriorityQueue<>((a, b) -> {
				if (a.activeS != b.activeS) {
					return a.activeS - b.activeS;
				} else {
					return b.time - a.time;
				}

			});

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					int time = Integer.parseInt(st.nextToken());
					if (time != 0) {
						Cell newCell = new Cell(sN + i, sM + j, time, 0, time, time * 2);
						map[sN + i][sM + j] = newCell;
						q.add(newCell);
					}
				}
			}
			
			int temp = checkByTime(K, q);

			System.out.printf("#%d %d\n", t, temp);
		}
	}

	static int checkByTime(int limit, Queue<Cell> q) {
		
		//맨 앞에 잇는 것의 시간이 최대 시간보다 작은 경우
		while (q.peek().activeS < limit) {
			
			Cell first = q.peek();
			
			//그 시간과 관련된 모든 값 처리
			while (first.activeS == q.peek().activeS) {
				Cell getC = q.poll();
				
				int x = getC.x;
				int y = getC.y;
				int time = getC.time;

				for (int d = 0; d < 4; d++) {
					int nx = dx[d] + x;
					int ny = dy[d] + y;
					
					int nextActiveS = first.activeS + time + 1;
					int nextDeadS = first.activeS + time * 2 + 1;

					Cell newCell = new Cell(nx, ny, time, first.activeS, nextActiveS, nextDeadS);
					if (map[nx][ny] == null) {
						map[nx][ny] = newCell;
						q.add(newCell);
					}
				}
			}
		}
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != null) {
					if (map[i][j].deadS > limit) {
						cnt++;
					}
				}
			}
		}
		return cnt;
	}
}
