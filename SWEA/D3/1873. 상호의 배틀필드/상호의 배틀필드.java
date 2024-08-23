import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {

	static char[][] grid;
	static int H;
	static int W;

	static int N;
	static char[] input;

	static Map<Character, Integer[]> map = new HashMap<Character, Integer[]>() {
		{
			put('v', new Integer[] { 1, 0 });
			put('<', new Integer[] { 0, -1 });
			put('>', new Integer[] { 0, 1 });
			put('^', new Integer[] { -1, 0 });
		}
	};

	public static void main(String[] args) throws IOException {
		// 상호의 배틀 필드
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			grid = new char[H][W];

			int x = -1;
			int y = -1;

			for (int i = 0; i < H; i++) {
				String[] string = br.readLine().trim().split("");
				
				for (int j = 0; j < W; j++) {
					grid[i][j] = string[j].charAt(0);
					if (grid[i][j] == '^' || grid[i][j] == '<' || grid[i][j] == '>' || grid[i][j] == 'v') {
						x = i;
						y = j;
					}
				}
			}

			N = Integer.parseInt(br.readLine());

			String[] string = br.readLine().trim().split("");
			input = new char[N];
			for (int i = 0; i < N; i++) {
				input[i] = string[i].charAt(0);
			}

			for (int i = 0; i < N; i++) {
				char now = input[i];
				
				switch (now) {

				case 'U':
					grid[x][y] = '^';
					if (x - 1 >= 0 && grid[x - 1][y] == '.') {
						grid[x - 1][y] = '^';
						grid[x][y] = '.';
						x = x - 1;
					}
					break;

				case 'D':
					grid[x][y] = 'v';
					if (x + 1 < H && grid[x + 1][y] == '.') {
						grid[x + 1][y] = 'v';
						grid[x][y] = '.';
						x = x + 1;
					}
					break;

				case 'L':
					grid[x][y] = '<';
					if (y - 1 >= 0 && grid[x][y - 1] == '.') {
						grid[x][y - 1] = '<';
						grid[x][y] = '.';
						y = y - 1;
					}
					break;

				case 'R':
					grid[x][y] = '>';
					if (y + 1 < W && grid[x][y + 1] == '.') {
						grid[x][y + 1] = '>';
						grid[x][y] = '.';
						y = y + 1;
					}
					break;

				case 'S':
					shoot(x, y);
					break;
				}
				
			}
			System.out.printf("#%d ", t);
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(grid[i][j]);
				}
				System.out.println();
			}

		}

	}

	static void shoot(int x, int y) {
		// 전차의 위치에서 shoot 하자
		Integer[] dir = map.get(grid[x][y]);

		int dx = dir[0];
		int dy = dir[1];

		int nx = dx + x;
		int ny = dy + y;

		while (0 <= nx && nx < H && 0 <= ny && ny < W) {
			// 범위에 존재하는 경우 확인
			
			if (grid[nx][ny] == '*') {
				// 벽돌인 경우
				grid[nx][ny] = '.';
				return;
			}
			
			if (grid[nx][ny] == '#') {
				return;
			}

			nx = dx + nx;
			ny = dy + ny;

		}

	}

}
