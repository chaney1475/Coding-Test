import java.io.*;
import java.util.*;

public class Main {

	static int N;

	static int[][] grid;
	static Set<Integer> friends;

	static Set<Integer>[] favorite;

	static int aX;// 행 위치
	static int aY; // 열 위치
	static int aS; // 인접한 학생수
	static int empty;

	public static void main(String[] args) throws Exception {
		// 상어초등학교
		// 행의 번호가 가장 작고 열의 번호도 가장 작은 것
		// 특정 자리에 좋아하는 학생이 얼마나 있는지 확인

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		grid = new int[N][N];

		favorite = new Set[N*N + 1];
		
		for (int i = 0; i < N * N; i++) {
			st = new StringTokenizer(br.readLine());
			int student = Integer.parseInt(st.nextToken());

			friends = new HashSet<>();
			for (int j = 0; j < 4; j++) {
				friends.add(Integer.parseInt(st.nextToken()));
			}
			favorite[student] = friends;
			
			aX = N; // 행 위치
			aY = N; // 열 위치
			aS = -1; // 인접한 학생수
			empty  = -1;
			findPosition(student, friends);

		}
		
		int ans = 0;;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int now = grid[i][j];// 그 위치의 학생
				int satis = 0;
				for (int d = 0; d < 4; d++) {
					int nx = i + dx[d];
					int ny = j + dy[d];
					if (nx < 0 || nx >= N || ny < 0 || ny >= N)
						continue;
					if (favorite[now].contains(grid[nx][ny])) {
						if (satis == 0) satis = 1;
						else {
							satis *= 10;
						}
					}
				}
				ans += satis;
			}
		}
		System.out.println(ans);

	}

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	static void findPosition(int student, Set<Integer> friends) {

		for (int i = 0; i < N; i++) {


			for (int j = 0; j < N; j++) {
				int cnt = 0;
				int emp = 0;


				if (grid[i][j] != 0)
					continue;
				for (int d = 0; d < 4; d++) {
					int nx = i + dx[d];
					int ny = j + dy[d];
					if (nx < 0 || nx >= N || ny < 0 || ny >= N)
						continue;
					if (friends.contains(grid[nx][ny])) {
						cnt++;
					}
					if (grid[nx][ny] == 0)
						emp++;
				}

				if (cnt > aS) { // 학생이 제일 많을 때
					set(i, j, cnt, emp);
				} else if (cnt == aS) {
					// 빈칸이 제일 많은 경우
					if (emp > empty) {
						set(i, j, cnt, emp);
					} else if (emp == empty) {
						if (aX > i || (aX == i && aY > j)) {
							set(i, j, cnt, emp);
						}
					}
				}

			}
		}

		grid[aX][aY] = student;

	}

	static void set(int x, int y, int students, int emp) {
		aX = x; // 위치
		aY = y; // 위치
		aS = students; // 학생수
		empty = emp; // 빈자리 수
	}

}
