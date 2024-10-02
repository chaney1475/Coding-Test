import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		Stack<Integer> stack = new Stack<>();
		

		int[] ans = new int[N];
		Arrays.fill(ans, Integer.MAX_VALUE);
		
		int[] r = new int[N];
		//오른쪽에 잇는 갯수
		for (int i = N-1; i >= 0; i--) {
			if (stack.isEmpty() || A[stack.peek()] > A[i]) {
				stack.push(i);
			}
			while (!stack.isEmpty() && A[stack.peek()] <= A[i]) {
				stack.pop();
			}
			if (!stack.isEmpty() && ans[i] > stack.peek()) {
				ans[i] = stack.peek();
			}
			
			r[i] = stack.size();
			stack.push(i);
		}
		
		stack.clear();

		//왼쪽에 있는 갯수
		for (int i = 0; i < N; i++) {
			if (stack.isEmpty() || A[stack.peek()] > A[i]) {
				stack.push(i);
			}
			
			while (!stack.isEmpty() && A[stack.peek()] <= A[i]) {
				stack.pop();
			}
			
			if (!stack.isEmpty() && ans[i] > stack.peek() && 
					Math.abs(ans[i] - i) >= Math.abs(stack.peek() - i)) {
				ans[i] = stack.peek() ;
			}
			
			r[i] += stack.size();
			
			stack.push(i);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			if (r[i] != 0) {
				sb.append(r[i]).append(" ").append(ans[i] + 1).append("\n");
			}else {
				sb.append("0\n");
			}
		}
//		System.out.println(Arrays.toString(ans));
//		System.out.println(Arrays.toString(r));
		System.out.println(sb);
		
	}

}
