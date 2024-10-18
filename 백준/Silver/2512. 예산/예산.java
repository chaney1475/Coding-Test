import java.util.*;
import java.io.*;


public class Main {
    static int N;
    
  public static void main(String args[]) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      
      N = Integer.parseInt(br.readLine());
      int[] a = new int[N];
      
      st = new StringTokenizer(br.readLine());
      long e = 0;
      
      for (int i = 0; i < N; i++){
          a[i] = Integer.parseInt(st.nextToken());
          e = Math.max(a[i], e);
      }
      long limit = Long.parseLong(br.readLine());
      
      long s = 1;
      long answer = -1;
      
      while(s <= e){
          long m = (s + e) / 2;
          
          long sum = 0;
          for (int i = 0; i < N; i++){
              sum += (long) Math.min(m, (long) a[i]);
          }
          
          if (sum <= limit){
              answer = m;
              s = m + 1;
          }else{
              e = m - 1;
          }
          
      }
      
      System.out.println(answer);
  }
}