import java.util.*;
import java.io.*;

public class Main {
  public static void main(String args[]) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      
      int[] A = new int[N];
      st = new StringTokenizer(br.readLine());
      
      int sum = 0;
      for (int i = 0; i < N; i++){
          A[i] = Integer.parseInt(st.nextToken());
          if(i < M){
              sum += A[i];
          }
      }
      int answer = sum;
      int cnt = 1;
      
      for (int i = M; i < N; i++){
          sum -= A[i - M];
          sum += A[i];
          
          if (sum == answer){
              cnt ++;
          }else if (sum > answer){
              cnt = 1;
              answer = sum;
          }
      }
      if (answer == 0){
          System.out.print("SAD");
          
      }else{
          System.out.println(answer);
          System.out.println(cnt);
          
      }
      
  }
}