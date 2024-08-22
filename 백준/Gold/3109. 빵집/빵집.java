import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static char[][] grid;
	static int answer;

	// 빵집
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] st = br.readLine().trim().split(" ");
		N = Integer.parseInt(st[0]);
		M = Integer.parseInt(st[1]);
		
		// 초기화
		grid = new char[N][M];
		
		for (int i = 0; i < N; i++) {
			st = br.readLine().trim().split("");
			for  (int j = 0; j < M; j++) {
				grid[i][j] = st[j].charAt(0);
			}
		}
		answer = 0;
		
		for (int i = 0; i < N; i++) {
			if (hasPath (i, 0)) {
				answer ++;
			}
		}
		
		System.out.println(answer);
	}

	static boolean hasPath(int x, int y) {
		
		if (y == M - 1) {
			return true;
		}

		// 다음으로 진행할 수 있는 경우
		if (y + 1 < M && x - 1 >= 0 && grid[x - 1][y + 1] == '.') {
			grid[x - 1][y + 1] = (char) (answer + 48);
			if( hasPath(x - 1, y + 1)) return true;
		}

		if (y + 1 < M && grid[x][y + 1] == '.') {
			grid[x][y + 1] = (char) (answer + 48);
			if( hasPath( x, y + 1)) return true;
		}

		if (y + 1 < M && x + 1 < N && grid[x + 1][y + 1] == '.') {
			grid[x + 1][y + 1] = (char) (answer + 48);
			if ( hasPath( x + 1, y + 1)) return true;
		}
		
		return false;

	}

}
