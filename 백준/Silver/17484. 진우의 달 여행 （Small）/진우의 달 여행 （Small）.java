import java.util.*;
import java.io.*;

public class Main {

    static int[][] grid;
    static int N, M;

    static class Position {
        int x, y, w, dir;
        Position(int x, int y, int w, int dir) {
            this.x = x;
            this.y = y;
            this.w = w;
            this.dir = dir;
        }
    }

    static int[] dy = {-1, 0, 1};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];
        int[][][] dp = new int[N][M][3]; // 각 좌표에서 방향별 최소 비용

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }

        PriorityQueue<Position> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.w, b.w));

        // 첫 번째 행의 모든 칸에서 시작 가능
        for (int i = 0; i < M; i++) {
            for (int d = 0; d < 3; d++) {
                dp[0][i][d] = grid[0][i];
            }
            pq.add(new Position(0, i, grid[0][i], -1)); // 방향이 없
        }

        int ans = Integer.MAX_VALUE;

        while (!pq.isEmpty()) {
            Position now = pq.poll();
            int x = now.x;
            int y = now.y;
            int dir = now.dir;
            int w = now.w;

            // 마지막 행에 도달했으면 최소값 갱신
            if (x == N - 1) {
                ans = Math.min(ans, w);
                continue;
            }

            // 세 가지 방향으로 이동
            for (int i = 0; i < 3; i++) {
                if (i == dir) continue; // 같은 방향으로 연속 패스
                int ny = y + dy[i];
                if (ny < 0 || ny >= M) continue; // 범위를 벗어나면 패스
                int nw = w + grid[x + 1][ny];
                if (dp[x + 1][ny][i] > nw) { // 현재 위치까지의 최소 비용보다 더 작으면 갱신
                    dp[x + 1][ny][i] = nw;
                }
                pq.add(new Position(x + 1, ny, nw, i));
            }
        }

        System.out.println(ans);
    }
}
