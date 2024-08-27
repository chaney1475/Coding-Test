import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// 줄 세우기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] edgeCnt = new int[N + 1];

		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

		for (int i = 0; i < N+1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph.get(a).add(b);
			edgeCnt[b]++;

		}

		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i < N + 1; i++) {
			if (edgeCnt[i] == 0) {
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			int nodeNo = q.poll();
			List<Integer> list = graph.get(nodeNo);

			sb.append(nodeNo).append(" ");

			for (int i = 0; i < list.size(); i++) {
				edgeCnt[list.get(i)]--;
				if (edgeCnt[list.get(i)] == 0) {
					q.add(list.get(i));
				}
			}

		}
		System.out.println(sb);

	}

}
