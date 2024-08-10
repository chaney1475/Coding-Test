import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;

    static int[][] grid;
    static boolean[][] visited;
    static List<int[]> virus;

    static int answer = 0;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int[] now;
    static List<List<int[]>> comb = new ArrayList<>();

    public static void combination(List<int[]> list, int dept, int index, int target) {
        if (dept == 3) {
            List<int[]> temp = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                temp.add(list.get(now[i]));
            }
            comb.add(temp);
            return;
        }
        if (target == list.size()) return;

        now[dept] = target;
        combination(list, dept + 1, index + 1, target + 1);
        combination(list, dept, index + 1, target + 1);
    }

    public static void checkVirus(int[][] tempGrid) {

        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[n][m];

        queue.addAll(virus); // 컬렉션에 요소를 추가하는 메서드

        for (int i = 0; i < virus.size(); i++) {
            int[] ints = virus.get(i);
            visited[ints[0]][ints[1]] = true;
        }

        while (!queue.isEmpty()) {
            int[] v = queue.poll();
            int x = v[0];
            int y = v[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                // 벽이거나 방문한 곳이면 pass
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || tempGrid[nx][ny] == 1 || visited[nx][ny])
                    continue;
                tempGrid[nx][ny] = 2;
                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny});
            }
        }

        long count = Arrays.stream(tempGrid)
                .flatMapToInt(Arrays::stream)
                .filter(value -> value == 0)
                .count();

        if (count > answer) answer = (int) count;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];
        List<int[]> blank = new ArrayList<>(); // 빈칸 저장

        virus = new ArrayList<>();
        now = new int[3];

        /**
         * 0 - 빈칸
         * 1 - 벽
         * 2 - 바이러스 (2 ~ 10개)
         */

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 0) blank.add(new int[]{i, j});
                else if (grid[i][j] == 2) virus.add(new int[]{i, j});
            }
        }

        combination(blank, 0, 0, 0);

        //조합의 경우를 확인하고 되돌리기
        for (int i = 0; i < comb.size(); i++) {
            List<int[]> c = comb.get(i);

            // grid의 복사본을 생성하여 checkVirus에 전달
            int[][] tempGrid = new int[n][m];
            for (int j = 0; j < n; j++) {
                tempGrid[j] = grid[j].clone();
            }

            for (int j = 0; j < 3; j++) {
                tempGrid[c.get(j)[0]][c.get(j)[1]] = 1;
            }

            checkVirus(tempGrid);
        }
        System.out.println(answer);
    }
}
