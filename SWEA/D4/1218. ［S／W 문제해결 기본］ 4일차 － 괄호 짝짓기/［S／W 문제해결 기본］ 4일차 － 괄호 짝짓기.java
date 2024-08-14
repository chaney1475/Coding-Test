import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution { // 구간 합 구하기 4
	
	static int N;
	static int M;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t <= 10; t++) {
			
			int flag  = 1;
			
			N = Integer.parseInt(br.readLine());
			
			String string = br.readLine();
			
			Stack<Character> s = new Stack<>();
			
			for(int i = 0; i < N; i++) {
				char c = string.charAt(i);
				if(c == '{' ||c == '[' ||c == '<' ||c == '(') {
					s.add(c);
				}else if (c == '}') {
					if (s.pop() != '{' ) {
						flag = 0;
						break;
					}	
				}else if (c == '>') {
					if (s.pop() != '<' ) {
						flag = 0;
						break;
					}	
				}else if (c == ')') {
					if (s.pop() != '(' ) {
						flag = 0;
						break;
					}	
				}else if (c == ']') {
					if (s.pop() != '[' ) {
						flag = 0;
						break;
					}	
				}
			}
			System.out.printf("#%d %d\n",t,flag);
			
		}
		

	}
	
}
