import java.util.*;
import java.io.*;

public class Main {
    
  public static void main(String args[]) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int N = Integer.parseInt(br.readLine());
      String s  = br.readLine();
      
      if (N == 1) {
          System.out.println(0);
          return;
      }
      
      char start = s.charAt(0);
      char end = s.charAt(N - 1);
      
      int leftR = 0, leftB = 0, rightR = 0, rightB = 0;
      
      for (int i = 0; i < N; i++) {
          if (s.charAt(i) != start) break;
          if (start == 'R') leftR++;
          else leftB++;
      }
      
      for (int i = N - 1; i >= 0; i--) {
          if (s.charAt(i) != end) break;
          if (end == 'R') rightR++;
          else rightB++;
      }
      
      int totalR = 0, totalB = 0;
      for (int i = 0; i < N; i++) {
          if (s.charAt(i) == 'R') totalR++;
          else totalB++;
      }
      
      int moveR = Math.min(totalR - leftR, totalR - rightR);
      int moveB = Math.min(totalB - leftB, totalB - rightB);
      
      System.out.println(Math.min(moveR, moveB));
  }
}
