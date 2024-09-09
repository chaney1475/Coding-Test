import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    //우주 여행 bfs
    
    static int[][] grid;
    static int N,M;
    
    static class Position{
        int x,y,w,dir;
        Position(int x, int y, int w, int dir){
            this.x = x;
            this.y = y;
            this.w = w;
            this.dir = dir;
        }
    }
    
  public static void main(String args[]) throws Exception{
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    
    grid = new int[N][M];
    int[][] dp = new int[N][M];
      
    for (int i = 0; i < N; i++){
        st = new StringTokenizer(br.readLine());
      
        for (int j = 0; j < M; j++){
            grid[i][j] = Integer.parseInt(st.nextToken());
        }
    }
    
    
    PriorityQueue<Position> pq = new PriorityQueue<>((a,b) -> {
        return Integer.compare(a.w, b.w);
    });
    
    for (int i = 0;  i< M; i++){
        pq.add(new Position(0,i,grid[0][i], -1));// -1은 방향이 없는 경우
    }
    
    int ans = Integer.MAX_VALUE;
    while(!pq.isEmpty()){
        Position now = pq.poll();
        int x = now.x;
        int y = now.y;
        int dir = now.dir;
        int w = now.w;
        
        if (x == N-1){
            ans = w;
            break;
        }
        
        for (int i = 0; i < 3; i++){
            if(dir == i) continue;
            int ny = y + dy[i];
            if (ny < 0 || ny >= M) continue;
            pq.add(new Position(x+1, ny, grid[x+1][ny] + w, i));
        }
        
    }
    
    System.out.print(ans);
      
  }
  static int[] dy = {-1,0,1};
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  
}