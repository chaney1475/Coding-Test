import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static long[][] ingredient;
	static long answer;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		ingredient = new long[N][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			long s = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			
			ingredient[i][0] = s;
			ingredient[i][1] = b;
			
		}

		answer = Long.MAX_VALUE;
		
		make(0,1L,0L);
		
		System.out.println(answer);
		
	}
	public static void make(int index, long S, long B) {
		
		if (!(S == 1L && B == 0L) && Math.abs(S - B) < answer) {
			answer = Math.abs(S - B);
		}
		
		if (index == N)
			return;
		
		make(index + 1, S * ingredient[index][0], B + ingredient[index][1]);
		make(index + 1, S, B);
		
		
	}
	

}
