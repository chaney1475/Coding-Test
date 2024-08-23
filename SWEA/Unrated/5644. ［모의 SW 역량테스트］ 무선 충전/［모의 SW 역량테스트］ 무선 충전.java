import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

class Position {
	int x;
	int y;
	int dist;

	public Position(int x, int y, int dist) {
		this.x = x;
		this.y = y;
		this.dist = dist;
	}
}

public class Solution {
	static int M;
	static int bCnt; // 배터리 인덱스, 갯수
	static int[] A; // a의 이동
	static int[] B; // b의 이동

	static int[][] batPosi;

	static int[] batDist; // 영역
	static int[] batPower; // 충전량

	static int[][][] powerSet;

	static int[] answer;

	static int[] dx = new int[] { 0, -1, 0, 1, 0 }; // 이동X, 상 우 하 좌
	static int[] dy = new int[] { 0, 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		// 무선충전
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			st = new StringTokenizer(br.readLine());

			M = Integer.parseInt(st.nextToken());
			bCnt = Integer.parseInt(st.nextToken());

			A = new int[M];
			B = new int[M];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}

			powerSet = new int[10][10][bCnt];
			
			batPosi = new int[bCnt][2];
			batDist = new int[bCnt];
			batPower = new int[bCnt];

			answer = new int[M+1];
			
			for (int i = 0; i < bCnt; i++) {
				st = new StringTokenizer(br.readLine());

				int y = Integer.parseInt(st.nextToken()) - 1;
				int x = Integer.parseInt(st.nextToken()) - 1;

				batPosi[i][0] = x;
				batPosi[i][1] = y;

				batDist[i] = Integer.parseInt(st.nextToken());
				batPower[i] = Integer.parseInt(st.nextToken());

			}
			setPower();


			moveAB();
			System.out.printf("#%d %d\n", t, Arrays.stream(answer).sum());

		}
	}

	static void moveAB() {
		int ax = 0;
		int ay = 0;
		
		int bx = 9;
		int by = 9;
		
		// 초기 배터리 구하기
		int biggestA = 0;
		int biggestB = 0;
		for (int i = 0; i< bCnt; i++) {
			if (powerSet[0][0][i] > biggestA) {
				biggestA = powerSet[0][0][i];
			}
			if (powerSet[9][9][i] > biggestB) {
				biggestB = powerSet[9][9][i];
			}
		}
		answer[0] = biggestA + biggestB;
		
		for (int i = 0; i < M; i++) {
			
			int da = A[i];
			int db = B[i];
			
			int nax = dx[da] + ax;
			int nay = dy[da] + ay;
			
			int nbx = dx[db] + bx;
			int nby = dy[db] + by;
			
			List<Integer> aList = new ArrayList<>();
			List<Integer> bList = new ArrayList<>();
			
			List<Integer> possible = new ArrayList<>();
			
			for (int c = 0; c < bCnt; c++) {
				if (powerSet[nax][nay][c] > 0) {
					aList.add(c);

				}
				if (powerSet[nbx][nby][c] > 0) {
					bList.add(c);
				}
			}
			
			for (int ii = 0; ii < aList.size(); ii++) {
				for (int jj = 0; jj < bList.size(); jj++) {
					if (aList.get(ii).equals(bList.get(jj))) {
						possible.add(batPower[aList.get(ii)]);
					}else {
						possible.add(batPower[aList.get(ii)] + batPower[bList.get(jj)]);
					}
				}
			}
			
			if(aList.size() == 0 && bList.size() > 0) {
				possible.addAll(
			            bList.stream()
			                 .map(index -> batPower[index])
			                 .collect(Collectors.toList())
			        );

			}
			
			if(bList.size() == 0 && aList.size() > 0) {
				possible.addAll(
			            aList.stream()
			                 .map(index -> batPower[index])
			                 .collect(Collectors.toList())
			        );
			}
			
			answer[i+1] = possible.size() == 0 ? 0 : Collections.max(possible);
			
			ax =  nax;
			ay =  nay;
			
			bx = nbx;
			by = nby;
			
		}
	}

	static void setPower() {

		for (int i = 0; i < bCnt; i++) {

			int x = batPosi[i][0];
			int y = batPosi[i][1];
			int limit = batDist[i];
			int power = batPower[i];

			boolean[][] visited = new boolean[10][10];

			Queue<Position> q = new LinkedList<>();
			visited[x][y] = true;
			powerSet[x][y][i] = power;
			q.offer(new Position(x, y, 0));

			while (!q.isEmpty()) {
				// 현재 위치는 가능한 위치
				Position now = q.poll();
				x = now.x;
				y = now.y;

				int dist = now.dist;

				// 4방 탐색을 하여 dist 내에 방문하지 않은 경우 방문
				for (int d = 1; d < 5; d++) {
					int nx = dx[d] + x;
					int ny = dy[d] + y;

					if (0 <= nx && nx < 10 && 0 <= ny && ny < 10 && !visited[nx][ny] && dist + 1 <= limit) {
						// 방문 처리한 후 넣기
						visited[nx][ny] = true;
						powerSet[nx][ny][i] = power;
						q.add(new Position(nx, ny, dist + 1));
					}
				}
			}
		}

	}

}
