import java.util.*;
import java.io.*;

public class Main {
  public static void main(String args[]) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      
      int T = Integer.parseInt(br.readLine());
      
      StringBuilder sb = new StringBuilder();
      
      for (int t = 0; t < T; t++){
          st = new StringTokenizer(br.readLine());
          int a = Integer.parseInt(st.nextToken());
          int b = Integer.parseInt(st.nextToken());
          int d = b - a;
          
          int s = 0;
          int e = 100000;
          
          int ans = 0;
          
          while(s <= e){
              int m = (s + e) / 2;
              if (getDist(m) >= d){
                  ans = m; 
                  e = m - 1;
              }else{
                  s = m + 1;
              }
          }
          sb.append(ans).append("\n");
      }
      System.out.print(sb);
      
  }
  
  static long getDist(int K){
      long k = K / 2;
      if (K % 2 == 0){
          return k * (k + 1) ;
      }
      return k * (k + 1) + k + 1;
      
  }
}