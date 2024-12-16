import java.util.*;
import java.io.*;

public class Main {
    
  public static void main(String args[]) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int N = Integer.parseInt(st.nextToken());
      int L = Integer.parseInt(st.nextToken());
      // 숫자는 L개 까지만 가능
      
      st = new StringTokenizer(br.readLine());
      
      int A[] = new int[N];
      int cnt[] = new int[100001];
      
      boolean can = true;
      
      for (int i = 0; i < N; i++) {
          A[i] = Integer.parseInt(st.nextToken());
      }
      
      int ans = 0;
      
      int s = 0;
      int e = 0;
      
      while (e < N) {
          cnt[A[e]]++;
          
          while (s < e && cnt[A[e]] > L){
              cnt[A[s++]]--;
          }
          ans = Math.max(ans, e - s + 1);
          
          e++;
      }
      System.out.print(ans);
  }
}