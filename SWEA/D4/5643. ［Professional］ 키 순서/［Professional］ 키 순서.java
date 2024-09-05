import java.io.*;
import java.util.*;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N;
	static int E;

	static class Edge {
		int bigger;
	}

	static List<ArrayList<Integer>> graph;
	static List<ArrayList<Integer>> reverseGraph;

	static Set<Integer> set;

	public static void main(String[] args) throws IOException {
		// 키비교
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			N = Integer.parseInt(br.readLine());
			E = Integer.parseInt(br.readLine());
			graph = new ArrayList<ArrayList<Integer>>();

			reverseGraph = new ArrayList<ArrayList<Integer>>();

			for (int i = 0; i < N + 2; i++) {
				graph.add(new ArrayList<>());
				reverseGraph.add(new ArrayList<>());
			}

			for (int e = 0; e < E; e++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				// a가 b보다 작다
				graph.get(a).add(b);
				// a가 b를 가리키도록
				reverseGraph.get(b).add(a);

			}
			
			int sum = 0;
			for (int i = 1; i <= N; i++) {
				sum += make(i);
			}
			System.out.printf("#%d %d\n", t, sum);
		}

	}

	static int make(int start) {
		set = new HashSet<>();
		
		check(start);
		reverseCheck(start);
		
		if (set.size() == N - 1)
			return 1;
		else
			return 0;

	}

	static void check(int start) {
		for (Integer i : graph.get(start)) {
			if (set.contains(i))
				continue;
			set.add(i);
			check(i);
		}
	}

	static void reverseCheck(int start) {
		for (Integer i : reverseGraph.get(start)) {
			if (set.contains(i))
				continue;
			set.add(i);
			reverseCheck(i);
		}
	}

}
