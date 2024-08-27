import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	// 미생물 군집
	static int[] dx = { -1, 1, 0, 0 }; // 상하좌우 (-1을 해야함)
	static int[] dy = { 0, 0, -1, 1 };

	static int N;
	static int K;
	static int M;

	static int[][][] grid;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken()); // 한 변에 잇는 셀의 수
			M = Integer.parseInt(st.nextToken()); // 격리 시간 - 몇번의 미생물 이동이 필요한지
			K = Integer.parseInt(st.nextToken()); // 미생물 군집의 수

			grid = new int[N][N][2];


			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());

				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				// 해당 위치의 미생물 수 [1] 방향 [0]
				int microCnt = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken()) - 1;

				grid[a][b][1] = microCnt;
				grid[a][b][0] = dir;
				
				

			}

//			System.out.println("초기 군집");
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(Arrays.toString(grid[i][j]) + " ");
//				}
//				System.out.println();
//			}

//			System.out.println();
			// M 시간 만큼 미생물들을 이동 시키자
			// M만큼 반복
			int[][][] temp;
			for (int m = 0; m < M; m++) {
				// 새로운 군집
				temp = new int[N][N][2];
				List<Integer[]>[][] mircoList = new ArrayList[N][N];
				
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						mircoList[i][j] = new ArrayList<>();
					}
				}
				
				
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (grid[i][j][1] != 0) { // 미생물이 있다는 것!

							int dir = grid[i][j][0];

							int nx = i + dx[dir];
							int ny = j + dy[dir];

							// 끝에 도달한 경우

							if (nx == 0 || nx == N - 1 || ny == 0 || ny == N - 1) {
								int microNums = grid[i][j][1] / 2;
								if (microNums == 0) {
									continue;
								}
								int newDir = -1;
								
								switch (dir) {
								case 0:
									newDir = 1;
									break;
								case 1:
									newDir = 0;
									break;
								case 2:
									newDir = 3;
									break;
								case 3:
									newDir = 2;
									break;
								}
								mircoList[nx][ny].add(new Integer[] {newDir, microNums});

							} else {
								mircoList[nx][ny].add(new Integer[] { grid[i][j][0], grid[i][j][1]});
							}
						}
					}
				}
				
				for (int i = 0; i < N; i ++) {
					for (int j = 0; j < N; j++) {
						if (mircoList[i][j].size() == 1) {
							temp[i][j][0] = mircoList[i][j].get(0)[0];
							temp[i][j][1] = mircoList[i][j].get(0)[1];
						}
						else if (mircoList[i][j].size() > 1){
							int biggest = 0;
							int dir = -1;
							
							for (int k = 0; k < mircoList[i][j].size(); k ++) {
								if (biggest < mircoList[i][j].get(k)[1]) {
									biggest = mircoList[i][j].get(k)[1];
									dir = mircoList[i][j].get(k)[0];
								}
								temp[i][j][1] += mircoList[i][j].get(k)[1];
							}
							
							temp[i][j][0] = dir;
							
						}
					}
				}
				
				grid = temp;


			}

			int answer = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					answer += grid[i][j][1];
				}
			}

			System.out.printf("#%d %d\n", t, answer);

		}

	}

}
