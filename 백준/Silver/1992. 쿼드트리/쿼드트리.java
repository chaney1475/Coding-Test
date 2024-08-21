import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] grid;

	// 쿼드 트리
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		grid = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String[] st = br.readLine().trim().split("");
			
			for (int j = 0; j < N; j++) {
				grid[i][j] = Integer.parseInt(st[j]);
			}
		}
		String answer = compressGrid(0,0,N);
		
		System.out.println(answer);
		
	}
	public static String compressGrid(int x, int y, int n) {
		
		if (n == 1) {
			return grid[x][y] + "";
		}
		
		int newN = n / 2;
		
		String a = compressGrid(x, y, newN);
		String b = compressGrid(x, y + newN, newN);
		String c = compressGrid(x + newN, y, newN);
		String d = compressGrid(x+newN, y+newN, newN);

		if ( (a.equals("1") || a.equals("0")) && a.equals(b) && b.equals(c) && c.equals(d)) {
			return a;
		}else {
			return "(" + a + b + c + d + ")";
		}
		
	}

}
