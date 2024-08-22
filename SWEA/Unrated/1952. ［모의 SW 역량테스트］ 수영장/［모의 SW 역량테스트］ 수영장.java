import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] cost;
	static int[] month;
	static boolean[] visited;
	static int answer;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			cost = new int[4]; // 1일 / 1달 / 3달 / 1년

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
			}

			month = new int[12];
			visited = new boolean[12];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				month[i] = Integer.parseInt(st.nextToken());
				if (month[i] == 0) {
					visited[i] = true;
				}
			}

			answer = Integer.MAX_VALUE;

			// visited 가 false인 부분을 방문

			for (int i = 0; i < 12; i++) {
				// 방문 해야하는 곳 부터 방문
				if (!visited[i]) {
					make(i, 0);
					break;
				}
			}

			System.out.printf("#%d %d\n", t, answer);

		}

	}

	static void make(int index, int total) {

		if (index >= 12) {
			// 모두 커버 헸음
			if (answer > total) {
				answer = total;
			}
			return;
		}
		
		if (visited[index]) {
			// 할필요 없는 경우 한달 전진
			make(index + 1, total);

		}

		// 1일 권
		make(index + 1, total + cost[0] * month[index]);
		// 1달 권
		make(index + 1, total + cost[1]);
		// 3달 권
		make(index + 3, total + cost[2]);
		// 1년권
		make(index + 12, total + cost[3]);
	}

}
