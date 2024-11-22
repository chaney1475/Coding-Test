import java.util.*;
import java.io.*;

public class Main {
    
    static int N, M;
    static int[] A;
    
  public static void main(String args[]) throws Exception{
      
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      
      N = Integer.parseInt(br.readLine()); // 굴다리 길이
      M = Integer.parseInt(br.readLine()); // 가로등의 갯수
      
      A = new int[M];
      //가로등의 위치
      
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < M; i++){
          A[i] = Integer.parseInt(st.nextToken());
      }
      
      int s = 1;
      int e = 100000;
      
      int answer = -1;
      
      while (s <= e){
          int m = (s + e) / 2;
          
          if (check(m)){ // 가능한 경우
              answer = m;
              e = m - 1;
          }else{
              s = m + 1;
          }
      }
      
      System.out.println(answer);
      
  }
  
  static boolean check(int m){
      int start = A[0] - m; // 시작점
      int end = A[0] + m;
      
      if (start > 0) return false;
      
      for (int i = 1; i < M; i++){
          if (end < A[i] - m) return false;
          end = A[i] + m;
      }
      
      if (end < N ) return false;
      
      return true;
  }
}