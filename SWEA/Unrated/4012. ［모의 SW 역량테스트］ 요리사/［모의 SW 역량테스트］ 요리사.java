import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int[][] synergy;
	static int N;
	static boolean[] visited;
	static int[] selected;
	static int[] notSelected;
	static int answer;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			synergy = new int[N][N];
			
			for (int i = 0; i < N; i++) {

				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					synergy[i][j] = Integer.parseInt(st.nextToken());
				}
				
			}
			
			// 조합
			visited = new boolean[N];
			selected = new int[N/2];
			answer = Integer.MAX_VALUE;
			
			make(0,0);
			System.out.printf("#%d %d\n", t, answer);
		}
		

	}
	public static void cal() {
		int sum1 = 0;
		for (int i = 0; i < N/2; i ++) {
			for (int j = 0; j < N/2; j++) {
				sum1 += synergy[selected[i]][selected[j]];
			}
		}
		
		int sum2 = 0;
		
		for (int i = 0; i < N/2; i ++) {
			for (int j = 0; j < N/2; j++) {
				sum2 += synergy[notSelected[i]][notSelected[j]];
			}
		}
		
		int temp = Math.abs(sum1 - sum2);
		if (temp < answer ) {
			answer = temp;
		}
	}
	
	
	public static void make(int index, int make_index) {
		if (make_index == N/2) {
			// 완성
			notSelected = new int[N/2];
			int j = 0;
			for (int i = 0; i < N; i++) {
				if(!visited[i]) {
					notSelected[j++] = i;
				}
			}
			
			cal();
			
			return;
		}
		if (index == N) {
			return;
		}
		
		selected[make_index] = index;
		visited[index] = true;
		
		make(index + 1, make_index + 1);
		visited[index] = false;
		
		make(index + 1, make_index);
	}

}
