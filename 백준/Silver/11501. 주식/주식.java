import java.util.*;
import java.io.*;

public class Main {
    
  public static void main(String args[]) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      
      int T = Integer.parseInt(br.readLine());
      StringBuilder sb = new StringBuilder();
      
      for (int t = 0; t < T; t++){
          int N = Integer.parseInt(br.readLine());
          st = new StringTokenizer(br.readLine());
          
          int[] A = new int[N];
          
          for (int i = 0; i < N; i++){
              A[i] = Integer.parseInt(st.nextToken());
          }
          long ans = 0;
          
          int max = A[N - 1];
          
          for (int i = N - 2; i >= 0; i--){
              int now = A[i];
              if (max > now) {
                  ans += (long) (max - now);
              }
              
              max = Math.max(now, max);
          }
          
          sb.append(ans).append("\n");
          
      }
      System.out.print(sb);
  }
}