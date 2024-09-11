import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    // 아기 상어
    static int N, M;
    static int[][] grid;

    static class Baby {
        int x, y, size, eating;

        Baby(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.eating = 0;
        }
    }

    static class Position {
        int x, y, time;

        Position(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());

        Baby baby = new Baby(0, 0, 2);
        grid = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 9) {
                    baby.x = i;
                    baby.y = j;
                    grid[i][j] = 0;  // 아기 상어는 빈칸으로 처리
                } else {
                    grid[i][j] = temp;
                }
            }
        }

        int ans = 0;
        while (true) {
            List<Position> eatableFishes = bfs(baby);
            if (eatableFishes.isEmpty()) break;

            Position fish = eatableFishes.get(0);
            ans += fish.time;

            baby.x = fish.x;
            baby.y = fish.y;
            baby.eating++;

            if (baby.eating == baby.size) {
                baby.size++;
                baby.eating = 0;
            }

            // 물고기 먹은 칸을 빈 칸으로 처리
            grid[fish.x][fish.y] = 0;
        }

        System.out.println(ans);
    }

    static List<Position> bfs(Baby baby) {
        Queue<Position> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        List<Position> eatableFishes = new ArrayList<>();

        queue.offer(new Position(baby.x, baby.y, 0));
        visited[baby.x][baby.y] = true;

        int minTime = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            Position now = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) continue;

                if (grid[nx][ny] <= baby.size) {
                    visited[nx][ny] = true;
                    queue.offer(new Position(nx, ny, now.time + 1));

                    // 먹을 수 있는 물고기
                    if (grid[nx][ny] > 0 && grid[nx][ny] < baby.size) {
                        if (now.time + 1 <= minTime) {
                            minTime = now.time + 1;
                            eatableFishes.add(new Position(nx, ny, now.time + 1));
                        }
                    }
                }
            }
        }

        Collections.sort(eatableFishes, (a, b) -> {
            if (a.time == b.time) {
                if (a.x == b.x) return Integer.compare(a.y, b.y);  // 가장 위쪽
                return Integer.compare(a.x, b.x);  // 가장 왼쪽
            }
            return Integer.compare(a.time, b.time);  // 가장 가까운 물고기
        });

        return eatableFishes;
    }
}
