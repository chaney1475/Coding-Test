import java.util.*;
import java.io.*;


public class Main {
    
    static class Position{
        int x; // 위치
        int cnt; // 횟수
        
        Position(int x, int cnt){
            this.x = x;
            this.cnt = cnt;
        }
    }
    
  public static void main(String args[]) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int N = Integer.parseInt(st.nextToken());
      int K = Integer.parseInt(st.nextToken());
      
      //위치
      int[] dp = new int[100001];
      Arrays.fill(dp, Integer.MAX_VALUE);
      
    //   PriorityQueue<Position> pq = new PriorityQueue<>((a,b) -> {
    //       return a.cnt - b.cnt;
    //   });
      
      
      Queue<Position> pq = new LinkedList<>();
      
      pq.add(new Position(N,0)); // 위치랑 cnt넣고시작
      dp[N] = 0; 
      
      while(!pq.isEmpty()){
          Position now = pq.poll();
          
          if(dp[K] != Integer.MAX_VALUE){
              break;
          }
          if (now.x == K){
              break;
          }
          
          if (now.x * 2 <= 100000 && dp[now.x * 2] > now.cnt + 1){
              dp[now.x * 2] = now.cnt;
              pq.add(new Position(now.x*2, now.cnt));
          }
          
          if (now.x - 1 >= 0 && dp[now.x - 1] > now.cnt + 1 ){
              dp[now.x - 1] = now.cnt +1;
              pq.add(new Position(now.x -1, now.cnt + 1));
          }
          
          if (now.x + 1 <= 100000 && dp[now.x + 1] > now.cnt + 1){
              dp[now.x + 1] = now.cnt +1;
              pq.add(new Position(now.x + 1, now.cnt+1));
          }
          
      }
      
      System.out.println(dp[K]);
  }
}