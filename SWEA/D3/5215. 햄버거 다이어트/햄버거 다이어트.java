import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N;
	static int[][] bugger;
	static int answer;
	static int limit;
	public static void main(String[] args) throws IOException{;
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {

			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());

			limit = Integer.parseInt(st.nextToken());
			
			answer = 0;
			
			bugger = new int[N][2];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				bugger[i][0] = Integer.parseInt(st.nextToken());
				bugger[i][1] = Integer.parseInt(st.nextToken());
				
			}
			
			make(0, 0, 0);
			System.out.printf("#%d %d\n",t ,answer);
		}
		
	}
	public static void make(int index, int taste, int calo) {
		
		if (index == N) {
			// 끝까지 온 경우
			if (taste > answer)
				answer = taste;
			
			return;
		}
        
		if (bugger[index][1] + calo <= limit)
			make(index + 1 , bugger[index][0] + taste , bugger[index][1] + calo);

		make(index + 1 ,taste , calo);
		
	}
}
