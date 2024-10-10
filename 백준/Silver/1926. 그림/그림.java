import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] map;

    static int size;

    static class Point{
        int x, y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = new int[] {0,0,-1,1};
    static int[] dy = new int[] {1,-1,0,0};

    static void bfs(int a, int b){

        int tmp = 1;

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(a, b));

        map[a][b] = 2;

        while( !q.isEmpty()){
            Point now  = q.poll();
            int x = now.x;
            int y = now.y;

            for (int d = 0; d < 4; d++){
                int nx = dx[d] + x;
                int ny = dy[d] + y;

                if (nx < 0 || nx >= N || ny < 0 || ny >= M){
                    continue;
                }
                if (map[nx][ny] == 1){
                    map[nx][ny] = 2;
                    tmp ++;
                    q.add(new Point(nx, ny));
                }

            }
        }
        size = Math.max(size, tmp);

    }
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int cnt = 0;
        size = 0;

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (map[i][j] == 1){
                    cnt++;
                    bfs(i, j);
                }
            }
        }

        System.out.println(cnt);
        System.out.println(size);

    }
}
