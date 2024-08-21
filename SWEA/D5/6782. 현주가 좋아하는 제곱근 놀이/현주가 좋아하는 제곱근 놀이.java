import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int answer;
	// 현주가 좋아하는 제곱근 놀이
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			long N = Long.parseLong(br.readLine());
			answer = 0;
			
			
			while ( N !=2 ) {
				if ((long) Math.sqrt(N) * (long) Math.sqrt(N) == N) {
					answer++;
					N = (long)Math.sqrt(N);
				}else {
					long next = ((long) Math.sqrt(N) + 1) ;
					long diff = next * next - N;  
					answer += diff;
					N = next * next;
				}
			}
			System.out.printf("#%d %d\n", t, answer);
		}

	}

}