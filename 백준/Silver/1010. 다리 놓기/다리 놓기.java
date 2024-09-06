import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static BigInteger ans;

	public static void main(String[] args) throws IOException {
		// 다리놓기
		int T = Integer.parseInt(br.readLine());
		
		int[][] grid = new int[31][31];
		for (int i = 0; i < 31; i++ ) {
			grid[i][0] = 1;
		}

		for (int i = 1; i < 31; i++) {
			for (int j =1; j < 31; j++) {
				grid[i][j] = grid[i-1][j] + grid[i-1][j-1];
			}
		}
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			System.out.println(grid[b][a]);
		}

	}

}
