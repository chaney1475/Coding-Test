import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = new int[] {0,0,-1,1};
    static int[] dy = new int[] {-1,1,0,0};
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] A = new int[N][M];
        
        for (int i = 0; i < N; i++){
            String line = br.readLine();
            for (int j = 0; j < M; j++){
                A[i][j] = line.charAt(j) - '0';
            }
            
        }
        
        int[][][] dist = new int[N][M][2];
        
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
            Arrays.fill(dist[i][j], Integer.MAX_VALUE);
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        dist[0][0][1] = 1; // 남은 횟수의 최소 이동 횟수
        q.add(new int[]{0,0,1,1}); // 남은 쓰기
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int D = now[2];
            int left = now[3];
            
            if (x == N-1 && y == M-1) continue;
            
            for (int d = 0; d < 4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                // 그냥 이동
                if (A[nx][ny] == 0){
                    if (dist[nx][ny][left] == Integer.MAX_VALUE 
                        || (dist[nx][ny][left] != Integer.MAX_VALUE && dist[nx][ny][left] > D + 1)){
                        dist[nx][ny][left] = D + 1;
                        q.add(new int[]{nx, ny, D + 1, left});
                    }
                }else if (left > 0){
                    if (dist[nx][ny][left - 1] == Integer.MAX_VALUE 
                    || (dist[nx][ny][left - 1] != Integer.MAX_VALUE && dist[nx][ny][left - 1] > D + 1)){
                        dist[nx][ny][left - 1] = D + 1;
                        q.add(new int[]{nx, ny, D + 1, left - 1});
                    }
                }
            }
        }
        
        int ans = Math.min(dist[N-1][M-1][1], dist[N-1][M-1][0]);
        System.out.print(ans == Integer.MAX_VALUE ? -1 : ans );
        
    }
}