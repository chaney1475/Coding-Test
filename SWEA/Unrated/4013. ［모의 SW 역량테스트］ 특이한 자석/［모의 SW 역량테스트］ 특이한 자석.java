import java.io.*;
import java.util.*;

public class Solution {

	static int[][] wheel;
	static int[] start;
	public static void main(String[] args) throws Exception {
		// 최장 공통 부분 수열
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine()); // 몇번 돌지
			wheel = new int[4][8];
			
			
			int ans = 0;
			
			start = new int[4]; // 초기의 시작은 무조건 0
			// 오른쪽은 2 왼쪽은 6
			
			//입력밪기
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					wheel[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//뭐할지 입력 받기
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken()) - 1; 
				int b = Integer.parseInt(st.nextToken());
				// a인덱스 바퀴를 b만큼 회전하자
				
				roll(a, -b);
				
			}
			
			int a = 0;
			
			int[] scores = {1, 2, 4, 8}; // 각 자석의 점수
			for (int i = 0; i < 4; i++) {
			    if (wheel[i][start[i]] == 1) { // S극인 경우
			        ans += scores[i];
			    }
			}

			
			System.out.printf("#%d %d\n",t, ans);
		}
	}
	static void roll(int i, int d) {
		
		// 오른쪽이 존재하는 경우
		if( i + 1 < 4) {
			// 오른쪽 휠의 왼쪽 확인
			int rightLeft = wheel[i+1][(start[i+1] + 6) % 8];
			if (rightLeft != wheel[i][(start[i] + 2) % 8]) {
				right(i+1, d * (-1));
			}
			
		}
		
		//왼쪽이 존재하는 경우
		if (i - 1 >= 0) {
			//왼쪽휠의 오른쪽 확인
			int leftRight = wheel[i-1][(start[i-1] + 2) % 8];
			if (leftRight != wheel[i][(start[i] + 6) % 8]) {
				left(i-1, d * (-1));
			}
					
		}
		// 갱신은 무조건 끝까지 갓다가 하기
		start[i] = (start[i] + d + 8) % 8;
		
	}
	static void right(int i, int d) {
		if(i + 1 < 4) {
			// 오른쪽 휠의 왼쪽 확인
			int rightLeft = wheel[i+1][(start[i+1] + 6) % 8];
			if (rightLeft != wheel[i][(start[i] + 2) % 8]) {
				right(i+1, d * (-1));
			}
		}
		
		start[i] = (start[i] + d + 8) % 8;
	}
	static void left(int i, int d) {
		
		if (i - 1 >= 0) {
			//왼쪽휠의 오른쪽 확인
			int leftRight = wheel[i-1][(start[i-1] + 2) % 8];
			if (leftRight != wheel[i][(start[i] + 6) % 8]) {
				left(i-1, d * (-1));
			}
					
		}
		
		start[i] = (start[i] + d + 8) % 8;
	}
	
}
