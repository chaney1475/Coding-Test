 import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;

    static List<int[]> stores;
    static List<int[]> persons;
    static int[][] grid;

    static int d;
    static int answer;

    public static void main(String[] args) throws IOException {
        // 치킨 배달

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); // M개의 치킨집을 골라서 거리 계산

        grid = new int[N][N];

        stores = new ArrayList<>();
        persons = new ArrayList<>();

        // 치킨집의 수 M + 1 ~ 13까지 -> 폐업 시킬 갯수 : 전체 수  - M개 -> 0개

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());

                if (temp == 2) {
                    stores.add(new int[] {i,j});
                }else if (temp == 1) {
                    persons.add(new int[] {i,j});
                }
                grid[i][j] = temp;
            }
        }
        //삭제해야하는 치킨집의 수
        d = stores.size() - M ;
        answer = Integer.MAX_VALUE;

        make(0, 0);
        System.out.println(answer);

    }
    static class Position{
        int x;
        int y;
        int dist;

        Position(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

    }
    static void make(int cnt, int index) {
        //cnt를 d개까지 삭제해야함
        if (cnt == d) {

            int temp = 0;
            for (int i = 0; i < persons.size(); i++) {
                int x = persons.get(i)[0];
                int y = persons.get(i)[1];
                temp += bfs(x,y);
            }
            answer = Math.min(answer, temp);
            return;
        }

        if (index == stores.size()) {
            return;
        }

        int[] nowStore = stores.get(index);
        grid[nowStore[0]][nowStore[1]] = 0;
        make(cnt + 1, index +1);
        grid[nowStore[0]][nowStore[1]] = 2;
        make(cnt, index + 1);

    }
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    static int bfs(int a, int b) {

        Queue<Position> q =  new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        q.offer(new Position(a, b,0));
        visited[a][b] = true;

        while (!q.isEmpty()){
            Position p = q.poll();
            int x = p.x;
            int y = p.y;

            if (grid[x][y] == 2){
                return p.dist;
            }

            for (int d = 0; d < 4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.offer(new Position(nx, ny, p.dist+1));
                }
            }

        }
        return -1;

    }

}
