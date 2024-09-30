import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] top = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++){
			top[i] = Integer.parseInt(st.nextToken());
		}    
		
		int[] ans = new int[n];
		
		Stack<Integer> q = new Stack<>();
		
		for (int i = n - 1; i >= 0; i--) {
			//탑의 가장 최근이 지금 현재 숫자보다 큼
			if (q.isEmpty() || top[q.peek()] > top[i]){
				q.add(i);
			}else{
				while(!q.isEmpty() && (top[q.peek()] < top[i] )){
						ans[q.pop()] = i + 1;
				}
				q.push(i);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < n; i++){
			sb.append( ans[i] + " ");
		}    
		
		System.out.print(sb);
		
	}
}