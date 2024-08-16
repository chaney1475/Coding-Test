import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int M;
	static int[] num;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;


		int T = 10;
		
		
		for(int t = 1; t <= T; t++) {
			br.readLine();
			
			num = new int[8];
			
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < 8; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			
			int cur = 0;
			int index = 0;
			int diff = 0;
			
			while(true) {
				diff = diff % 5;
				cur = num[index];
				
				if (cur - (diff+1) <= 0) {
					num[index] = 0;
					
					// index일때까지만 떼기!
					String tmp = "";
					
					for(int i = index + 1; i < 8; i++ ) {
						tmp += num[i] +" ";
					}
					
					for(int i = 0; i <= index; i++) {
						tmp += num[i]+" ";
					}
					
					System.out.println("#" + t + " " + tmp);
					break;
				}
				
				num[index] = cur - (diff+1);
				
				diff++;
				index = (index + 1) % 8;
				
			}
		}
	}
}
