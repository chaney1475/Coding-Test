import java.util.*;
import java.io.*;

public class Main {
  public static void main(String args[]) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    
    int T = Integer.parseInt(br.readLine());
    
    StringBuilder sb = new StringBuilder();
    
    for (int t = 0; t < T; t++){
        int N = Integer.parseInt(br.readLine());
    
    Set<Integer> set = new HashSet<>();
    
    st = new StringTokenizer(br.readLine());
    
    for (int i = 0; i< N; i++){
        set.add(Integer.parseInt(st.nextToken()));
    }
    
    int M = Integer.parseInt(br.readLine());

    
    st = new StringTokenizer(br.readLine());
    
    for (int i = 0; i < M; i++){
        int now = Integer.parseInt(st.nextToken());
        if (set.contains(now)){
            sb.append(1).append("\n");
        }else{
            sb.append(0).append("\n");
        }
    }
    }
    
    
    System.out.print(sb);
  }
}