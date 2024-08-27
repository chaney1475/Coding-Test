import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int V;
	static int E;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st;

		int T = 10;
		

		for (int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder();
			
			st = new StringTokenizer(br.readLine());
			
			V = Integer.parseInt(st.nextToken()); // 정점 수
			E = Integer.parseInt(st.nextToken()); // 간선 수
			

			int[] edgeCnt = new int[V + 1]; //각 정점의 진입 차수 저장 
			
			// 2차원 그래프 
			ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
			
	        for (int i = 0; i < V+1; i++) {
	            graph.add(new ArrayList<Integer>());
	        }
	        
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < E; i++) {
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
						
				graph.get(s).add(e);
				edgeCnt[e]++;
				
			}
			
			//위상 정렬 큐
			Queue<Integer> q = new LinkedList<>();
			
			// 진입 차수가 0인 값 큐에 넣기
			for (int i = 1; i < V+1; i++) {
				if (edgeCnt[i] == 0) {
					q.offer(i);
				}
			}
			
			while (!q.isEmpty()) {
				// 큐에서 노드 번호 빼기
				int nodeNo = q.poll();
				
				sb.append(nodeNo).append(" ");
				
				List<Integer> list = graph.get(nodeNo);
				
				for (int i = 0; i < list.size(); i++) {
					edgeCnt[list.get(i)] --;
					if (edgeCnt[list.get(i)] == 0) {
						q.add(list.get(i));
					}
					
				}
				
			}
			
			System.out.printf("#%d %s\n", t, sb);

		}

	}

}
