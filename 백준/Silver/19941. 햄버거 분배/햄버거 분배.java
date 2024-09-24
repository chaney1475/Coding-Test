import java.util.*;
import java.io.*;

public class Main {
  public static void main(String args[]) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int K = Integer.parseInt(st.nextToken());
      
      char[] line = new char[N];
      
      String str = br.readLine();
      
      for (int i = 0; i < N; i++){
          line[i] = str.charAt(i);
      }
      int cnt = 0;
      
      boolean[] eat = new boolean[N];
      for (int i = 0; i < N; i++){
          if (line[i] == 'H' || eat[i]) continue; // 사람인 경우에만
          
          int s = Math.max(0, i - K);
          int flag = 0;
          
          for (int j = s; j < i; j++){
              if (line[j] == 'H' && !eat[j]){
                  flag = 1;
                  cnt ++;
                  eat[j] = true; // 해당 햄버거도 완료
                  eat[i] = true; // 해당 사람도 완료
                  break;
              }
          }
          
          if (flag == 1) continue;
          
          int e = Math.min(N-1, i + K);
          for (int j = i+1; j <= e; j++){
              if (line[j] == 'H' && !eat[j]){
                  cnt++;
                  eat[j] = true;
                  eat[i] = true;
                  break;
              }
          }
      }
      System.out.println(cnt);
      
  }
}