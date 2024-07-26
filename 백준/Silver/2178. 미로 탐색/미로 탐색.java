import java.util.*;

public class Main {
    static int n, m;
    static int[][] graph;
    static int[][] pos = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    static boolean[][] visited;

    static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, 1});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] arr = q.poll();
            int nowX = arr[0];
            int nowY = arr[1];
            int nowD = arr[2];

            if (nowX == n - 1 && nowY == m - 1) {
                return nowD;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + pos[i][0];
                int nextY = nowY + pos[i][1];

                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m
                        && graph[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                    q.add(new int[]{nextX, nextY, nowD + 1});
                    visited[nextX][nextY] = true;
                }
            }
        }

        return -1; // 경로를 찾지 못한 경우
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        graph = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = line.charAt(j) - '0'; // 문자를 숫자로 변환
            }
        }


        System.out.println(bfs(0, 0));
    }
}
