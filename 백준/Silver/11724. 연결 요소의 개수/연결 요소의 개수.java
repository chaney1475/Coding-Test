import java.util.*;
import java.io.*;

public class Main {
    static int[] rep;
    
  public static void main(String args[]) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      st = new StringTokenizer(br.readLine());
      
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      
      rep = new int[N+1];
      
      for (int i = 1; i <= N; i++){
          rep[i] = i;
      }
      
      for (int m = 0; m < M; m++){
          st = new StringTokenizer(br.readLine());
          int a = Integer.parseInt(st.nextToken());
          int b = Integer.parseInt(st.nextToken());
          
          union(a,b);
      }
      
      Set<Integer> set = new HashSet<>();
      
      for (int i = 1; i < N+1; i++){
          set.add(find(i));
      }
      System.out.print(set.size());
      
  }
  
  static int find(int x){
      if (x != rep[x]){
          rep[x] = find(rep[x]);
      }
      return rep[x];
  }
  
  static boolean union(int a, int b){
      a = find(a);
      b = find(b);
      
      if (a == b){
          return false;
      }
      if (a < b){
          rep[b] = a;
      }else{
          rep[a] = b;
      }
      return true;
      
  }
  
}