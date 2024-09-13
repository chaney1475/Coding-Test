import java.io.*;
import java.util.*;
import java.util.Map.*;

public class Main {
	// 이중 우선순위 큐
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] arg) throws IOException {
		int T = Integer.parseInt(br.readLine());

		TreeMap<Integer, Integer> tree;

		StringBuilder sb = new StringBuilder();

		for (int t = 0; t < T; t++) {

			tree = new TreeMap<>(Collections.reverseOrder());

			int N = Integer.parseInt(br.readLine());

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());

				String a = st.nextToken();
				int num = Integer.parseInt(st.nextToken());

				if (a.equals("I")) {
					tree.merge(num, 1, (v1, v2) -> (v1 + v2));
				} else {
					if (tree.isEmpty())
						continue;

					if (num == 1) {
						int first = tree.firstKey();
						if (tree.get(first) == 1) {
							tree.remove(first);
						} else {
							tree.put(first, tree.get(first) - 1);
						}

					} else {
						int last = tree.lastKey();
						if (tree.get(last) == 1) {
							tree.remove(last);
						} else {
							tree.put(last, tree.get(last) - 1);
						}
					}
				}
			}

			if (tree.isEmpty()) {
				sb.append("EMPTY\n");
			} else {
				sb.append(tree.firstKey()).append(" " + tree.lastKey() + "\n");
			}
		}
		System.out.println(sb);

	}

}
