import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] height;
	static int B;
	static int N;
	static boolean[] visited;
	static int answer;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			height = new int[N];
			
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				height[i] = Integer.parseInt(st.nextToken());
			}
			
			answer = Integer.MAX_VALUE;
			visited = new boolean[N];
			
			make(0, 0);
			
			System.out.printf("#%d %d\n", t, answer - B);
			
		}
	}
	public static void make(int index, int h) {
		if (h >= B) {
			if (answer > h) {
				answer = h;
			}
			return;
		}
		if (index == N) {
			return;
		}
		
		make(index + 1, h + height[index]);
		make(index + 1, h);
	}

}
