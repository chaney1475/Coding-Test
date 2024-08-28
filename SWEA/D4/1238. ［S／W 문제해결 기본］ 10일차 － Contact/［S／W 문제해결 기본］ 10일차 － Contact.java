import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		// contact
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int T = 10;
		
		for (int t = 1;  t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

			for (int i = 0;  i < 101; i++) {
				graph.add(new ArrayList<>());
			}

			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N/2; i++) {
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				graph.get(a).add(b);
			}
			
			int[] depth = new int[101];
			Arrays.fill(depth, Integer.MAX_VALUE);
			
			// start에서부터 시작
			Queue<Integer> q = new LinkedList<>();
			
			q.offer(start);
			depth[start] = 0;
			
			while(!q.isEmpty()) {
				Integer now = q.poll();
				int depthNow = depth[now];
				List<Integer> list = graph.get(now);
				
				for (int i = 0; i < list.size(); i++) {
					if ( depth[list.get(i)] > depthNow +1 ) {
						depth[list.get(i)] = depthNow + 1;
						q.add(list.get(i));
					}
				}
			}
			
			int maxValue = Integer.MIN_VALUE;
	        int maxIndex = -1;

	        // 배열 순회
	        for (int i = 0; i < 101; i++) {
	            // 2147483647이 아닌 값 중 가장 큰 값 찾기
	            if (depth[i] != 2147483647 && depth[i] >= maxValue) {
	                maxValue = depth[i];
	                maxIndex = i;
	            }
	        }
			
			System.out.printf("#%d %d\n",t, maxIndex);
			
		}
	}
}
