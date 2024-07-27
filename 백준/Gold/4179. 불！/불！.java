import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static char[][] grid;
    static boolean[][] visited;
    static final int[][] DIRECTIONS = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        grid = new char[n][m];
        visited = new boolean[n][m];

        List<int[]> fireList = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        int jx = 0, jy = 0;

        // Reading input
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                grid[i][j] = line.charAt(j);
                if (grid[i][j] == 'J') {
                    jx = i;
                    jy = j;
                } else if (grid[i][j] == 'F') {
                    fireList.add(new int[]{i, j});
                }
            }
        }

        // Initialize fire positions in the queue
        for (int[] fire : fireList) {
            queue.add(new int[]{1, fire[0], fire[1], 1});
        }

        // Initialize Jihoon's position in the queue
        queue.add(new int[]{0, jx, jy, 1});
        visited[jx][jy] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int type = current[0];
            int x = current[1];
            int y = current[2];
            int distance = current[3];

            if (type == 0 && (x == 0 || x == n - 1 || y == 0 || y == m - 1)) {
                System.out.println(distance);
                return;
            }

            for (int[] direction : DIRECTIONS) {
                int nx = x + direction[0];
                int ny = y + direction[1];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (type == 1 && (grid[nx][ny] == '.' || grid[nx][ny] == 'J')) {
                        grid[nx][ny] = 'F';
                        queue.add(new int[]{1, nx, ny, distance + 1});
                    } else if (type == 0 && grid[nx][ny] == '.' && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{0, nx, ny, distance + 1});
                    }
                }
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}
