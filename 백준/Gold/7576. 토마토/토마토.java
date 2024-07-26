import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] graph;
    static int[][] pos = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        boolean allRipeInitially = true;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 1) {
                    q.add(new int[] { i, j, 0 });
                } else if (graph[i][j] == 0) {
                    allRipeInitially = false;
                }
            }
        }

        if (allRipeInitially) {
            System.out.println(0);
            return;
        }

        int day = 0;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];
            int nowD = now[2];

            day = nowD;

            for (int i = 0; i < 4; i++) {
                int nx = nowX + pos[i][0];
                int ny = nowY + pos[i][1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || graph[nx][ny] != 0) continue;

                graph[nx][ny] = 1;
                q.add(new int[] { nx, ny, nowD + 1 });
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(day);
    }
}
