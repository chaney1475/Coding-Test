import java.util.*;
import java.io.*;

public class Main {
  public static void main(String args[]) throws Exception {
      
      List<Integer> line = new ArrayList<>();
      
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int N = Integer.parseInt(br.readLine());
      
      int[] A = new int[N];
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      for (int i = 0; i < N; i++){
          A[i] = Integer.parseInt(st.nextToken());
      }
      
      for (int i = N; i > 0; i--){
          int cnt = A[i - 1]; // 이숫자에 앞에 몇개의 수가 있는가
          line.add(cnt, i);
      }
      
      StringBuilder sb = new StringBuilder();
      
      
      for (Integer i : line){
          sb.append(i).append(" ");
      }
      
      System.out.println(sb);
      
  }
}