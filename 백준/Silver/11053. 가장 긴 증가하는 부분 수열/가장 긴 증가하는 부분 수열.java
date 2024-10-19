import java.util.*;
import java.io.*;

public class Main {
    static int len;
  public static void main(String args[]) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      
      int N = Integer.parseInt(br.readLine());
      st = new StringTokenizer(br.readLine());
      
      int[] a = new int[N];
      
      int[] ans = new int[N];
      
      len = 0;
      for (int i = 0; i < N; i++){
          a[i] = Integer.parseInt(st.nextToken());
      }
      
      for (int i = 0; i < N; i++){
          find(ans, a[i]);
      }
      
      System.out.print(len);
  }
  
  static void find(int[] ans, int x){
      if (len == 0 || ans[len - 1] < x){
          ans[len++] = x;
          return;
      }
      
      int answer = -1;
      
      int s = 0;
      int e = len - 1;
      
      while(s <= e){
          int m = (s + e) / 2;
          if (ans[m] >= x){
              answer = m;
              e = m - 1;
          }else{
              s = m + 1;
          }
      }
      
      ans[answer] = x;
  }
}