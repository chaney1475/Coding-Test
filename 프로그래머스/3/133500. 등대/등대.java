import java.util.*;

class Solution {
    ArrayList<Integer>[] adj;
    boolean[] visited;
    int[][] dp;

    public int solution(int N, int[][] lighthouse) {
        adj = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        dp = new int[N + 1][2]; // dp[i][0] = i번 노드를 끄는 경우, dp[i][1] = i번 노드를 켜는 경우

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : lighthouse) {
            int a = edge[0];
            int b = edge[1];
            adj[a].add(b);
            adj[b].add(a);
        }

        // 루트 노드는 1로 가정하고 DFS 시작
        dfs(1);

        // 최소 등대 개수 = (루트 노드를 켜거나 안 켜는 경우 중 최소값)
        return Math.min(dp[1][0], dp[1][1]);
    }

    void dfs(int node) {
        visited[node] = true;
        dp[node][0] = 0; // 현재 노드를 끄는 경우
        dp[node][1] = 1; // 현재 노드를 켜는 경우

        for (int next : adj[node]) {
            if (visited[next]) continue;
            dfs(next);

            // 현재 노드를 끄는 경우: 자식 노드는 반드시 켜야 함
            dp[node][0] += dp[next][1];

            // 현재 노드를 켜는 경우: 자식 노드는 꺼도 되고 켜도 됨 (더 작은 값 선택)
            dp[node][1] += Math.min(dp[next][0], dp[next][1]);
        }
    }
}
