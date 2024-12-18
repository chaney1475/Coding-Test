import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
        
	    int n;
	    int answer = 0;
	    int[] height;
		
		n = Integer.parseInt(br.readLine());
		height = new int[n];
        
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			height[i] = Integer.parseInt(st.nextToken());
		}
        
		Stack<Integer> stack = new Stack<>();
        
		for(int h : height ) {
			if(h == 0) {
				answer += stack.size();
				stack.clear();
			} else if (!stack.isEmpty()) {
				int peek = stack.peek();
				if(peek < h) {
					stack.push(h);
				}else {
					while
						(!stack.isEmpty() && stack.peek()>h) {
						stack.pop();
						answer++;
					}
					if(!stack.isEmpty() && stack.peek()<h)
						stack.push(h);
					if(stack.isEmpty())
						stack.push(h);
				}
			}else {
				// 스택이 비어있으면 무조건 push
				stack.push(h);
			}
		}
		answer += stack.size();
		stack.clear();
		System.out.println(answer);
	}
}