import java.util.*;
import java.io.*;


public class Main {
  public static void main(String args[]) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      
      int[][] map = new int[N][M];
      
      int startX = -1;
      int startY = -1;
      
      for (int i = 0; i < N; i++){
          st = new StringTokenizer(br.readLine());
          for (int j = 0; j < M; j++){
              int tmp = Integer.parseInt(st.nextToken());
              map[i][j] = tmp;
              if (tmp == 2){
                  startX = i;
                  startY = j;
              }
          }
      }
      
      int[][] dp = new int[N][M];
      for (int i = 0; i < N; i++){
          Arrays.fill(dp[i], Integer.MAX_VALUE);
      }
      
      Queue<int[]> q = new LinkedList<>();
      q.add(new int[] {startX, startY, 0});
      dp[startX][startY] = 0;
      
      int[] dx = new int[] {0,0,-1,1};
      int[] dy = new int[] {1,-1,0,0};
      
      while(!q.isEmpty()){
          int[] now = q.poll();
          int x= now[0];
          int y = now[1];
          int dist = now[2];
          
          for (int d = 0; d < 4; d++){
              int nx = dx[d] + x;
              int ny = dy[d] + y;
              
              if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                  continue;
              }
              
              if (map[nx][ny] == 1) {
              
              if (dp[nx][ny] > dist + 1){
                  dp[nx][ny] = dist + 1;
                  q.add(new int[] {nx, ny, dist + 1});
              }
              }
              
          }
      }
      StringBuilder sb = new StringBuilder();
      
      for (int i = 0; i < N; i++){
          for (int j = 0; j < M;  j++){
              if (dp[i][j] == Integer.MAX_VALUE){
                  if (map[i][j] == 1){
                      sb.append("-1 ");
                  }else{
                      
                  sb.append("0 ");
                  }
              }
              else{
              sb.append(dp[i][j] + " ");
                  
              }
              
          }
          sb.append("\n");
      }
      System.out.print(sb);
      
  }
}