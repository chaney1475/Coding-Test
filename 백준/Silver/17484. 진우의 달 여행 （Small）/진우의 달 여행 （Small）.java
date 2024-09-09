import java.util.*;
import java.io.*;

public class Main {

    static int[][] grid;
    static int N, M;
    static int[][][] dp; // 방향별 최소 비용을 저장할 dp 배열

    static int[] dy = {-1, 0, 1};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];
        dp = new int[N][M][3]; // 각 좌표에서 방향별 최소 비용

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }

        Deque<Position> deque = new ArrayDeque<>();

        // 첫 번째 행의 모든 칸에서 시작 가능
        for (int i = 0; i < M; i++) {
            for (int d = 0; d < 3; d++) {
                dp[0][i][d] = grid[0][i];
            }
            deque.add(new Position(0, i, grid[0][i], -1)); // 초기값 추가
        }

        int ans = Integer.MAX_VALUE;

        while (!deque.isEmpty()) {
            Position now = deque.poll();
            int x = now.x;
            int y = now.y;
            int dir = now.dir;
            int w = now.w;

            if (x == N - 1) {
                ans = Math.min(ans, w);
                continue;
            }

            for (int i = 0; i < 3; i++) {
                if (i == dir) continue; // 같은 방향으로 연속 패스
                int ny = y + dy[i];
                if (ny < 0 || ny >= M) continue; // 범위를 벗어나면 패스
                int nw = w + grid[x + 1][ny];

                if (dp[x + 1][ny][i] > nw) { // 더 작은 비용일 때만 갱신
                    dp[x + 1][ny][i] = nw;
                    deque.add(new Position(x + 1, ny, nw, i)); // 새 경로 큐에 추가
                }
            }
        }

        System.out.println(ans);
    }

    static class Position {
        int x, y, w, dir;
        Position(int x, int y, int w, int dir) {
            this.x = x;
            this.y = y;
            this.w = w;
            this.dir = dir;
        }
    }
}
