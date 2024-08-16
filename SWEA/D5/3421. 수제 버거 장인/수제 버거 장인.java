import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int M;
	
	static boolean[][] except;
	
	static int answer; 
	static boolean[] visited;
	static int[] result;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());


		int T = Integer.parseInt(st.nextToken());
		
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken()); // 1번부터 N번
			
			M = Integer.parseInt(st.nextToken()); // M쌍
			
			except = new boolean[N][N];
			//true인 경우 제외해야함
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				except[a-1][b-1] = true;
				except[b-1][a-1] = true;
			}
			
			answer = 0;
			
			visited = new boolean[N];
			
			result = new int[N];
			
			make(0,0);
			
			System.out.printf("#%d %d\n", t, answer);
			
		}
		

	}
	public static void make(int n_index,  int bugggerIndex) {
		//확인한 실제 숫자 n_index, 몇개를 만들었나 index
		
		if(n_index == N) {
			answer++;
			return;
		}
		
		boolean flag = true;
		
		for (int i = 0; i < bugggerIndex; i++) {
			if (except[result[i]][n_index]) {
				flag = false;
				break;
			}
		}
		
		if (flag) {
			result[bugggerIndex] = n_index;
			make(n_index + 1, bugggerIndex + 1);
		}
		
		make(n_index + 1, bugggerIndex);
					
	}
	

}
