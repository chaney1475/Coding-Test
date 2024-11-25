import java.util.*;
import java.io.*;

public class Main {
    static int N, L, R;
    static int[][] A;
    static boolean[][] visited;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        A = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int days = 0;

        while (true) {
            visited = new boolean[N][N];
            boolean isMoved = false;

            // 전체 순회
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        // bfs
                        if (bfs(i, j)) {
                            isMoved = true;
                        }
                    }
                }
            }

            if (!isMoved) break; //끝
            days++;
        }

        System.out.println(days);
    }

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static boolean bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        List<int[]> union = new ArrayList<>();
        visited[x][y] = true;
        q.offer(new int[] {x, y});
        union.add(new int[] {x, y});

        int sum = A[x][y];

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int cx = now[0];
            int cy = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;

                int diff = Math.abs(A[cx][cy] - A[nx][ny]);
                if (diff >= L && diff <= R) {
                    visited[nx][ny] = true;
                    q.offer(new int[] {nx, ny});
                    union.add(new int[] {nx, ny});
                    sum += A[nx][ny];
                }
            }
        }

        if (union.size() > 1) {
            int newPopulation = sum / union.size();
            for (int[] pos : union) {
                A[pos[0]][pos[1]] = newPopulation;
            }
            return true; // 인구 이동 잇음
        }

        return false; // 인구 이동 없음
    }
}
