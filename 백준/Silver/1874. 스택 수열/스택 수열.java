import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		
		StringBuilder sb = new StringBuilder();
		
		Stack<Integer> stack = new Stack<>();
		
		
		int[] ans = new int[N];
		for (int i = 0; i < N; i++) {
			ans[i] = Integer.parseInt(br.readLine());
		}
		
		int n = 1; // 스택에 넣을 다음 수! (1부터 N까지 있음)

		int j = 0; // 정답에 있는 수를 확인하기 위한 인덱스
		
		while (n <= N || !stack.isEmpty() ) { // 추가할 수 있는 수가 있거나 현재 수가 남아잇다
			// 스택의 수와 현재 답으로 나와야하는 수가 같으면 뽑기
			if (!stack.isEmpty() && stack.peek() == ans[j]) { 
				stack.pop();
				sb.append("-\n");
				j++;
			}else if(n <= N){
				//현재 들어가지 않은 수가 나와야하는 수보다 같거나 작으면 나올때까지 push
				stack.push(n++);
				sb.append("+\n");
			}else {
				System.out.print("NO");
				return;
			}
		}
		
		System.out.println(sb);
		
	}

}