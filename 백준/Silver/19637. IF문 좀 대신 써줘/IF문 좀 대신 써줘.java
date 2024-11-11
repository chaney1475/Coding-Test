import java.util.*;
import java.io.*;

public class Main {
    
    static int N;
    static int M;
    static Level[] levels;
    
    static class Level{
        String name;
        int val;
        Level(String name, int val){
            this.name = name; this.val = val;
        }
        public String toString(){
            return this.name + " " + this.val + " ";
        }
    }
    
  public static void main(String args[]) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      
      levels = new Level[N];
      
      for (int i = 0; i < N; i++){
          st = new StringTokenizer(br.readLine());
          String name = st.nextToken();
          int val = Integer.parseInt(st.nextToken());
          levels[i] = new Level(name, val);
          
      }
      
      Arrays.sort(levels, (a,b) -> {
          return a.val - b.val;
      });
      
      StringBuilder sb = new StringBuilder();
      
      for (int i = 0; i < M; i++){
          int now = Integer.parseInt(br.readLine());
          sb.append(find(now)).append("\n");
      }
      
      System.out.println(sb);
      
      
  }
  
  static String find(int now){
      int s = 0;
      int e = N - 1;
      
      int ans = -1;
      
      while (s <= e){
          int m = (s + e) / 2;
          
          if(now <= levels[m].val){
              ans = m;
              e = m - 1;
          }else{
              s = m + 1;
          }
      }
      return levels[ans].name;
  }
  
}