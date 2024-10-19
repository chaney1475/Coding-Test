import java.util.*;
import java.io.*;

public class Main {
    
    static Map<Integer,Integer> map1;
    static Map<Integer,Integer> map2;
    static int[] arr;
    
  public static void main(String args[]) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int N = Integer.parseInt(st.nextToken());
      int S = Integer.parseInt(st.nextToken());
      
      arr = new int[N];
      
      st = new StringTokenizer(br.readLine());
      
      map1 = new HashMap<>();
      map2 = new HashMap<>();
      
      Long ans = 0L;
      
      for (int i = 0; i < N; i++){
          arr[i] = Integer.parseInt(st.nextToken());
      }
      
      // 반나눠서 전체 조합 구하기
      dfs(true, 0, 0, N/2, 0);
      dfs(false, 0, N/2, N, 0);
      
    //   System.out.println(map1);
    //   System.out.println(map2);
      for (Map.Entry<Integer,Integer> entry: map1.entrySet()){
          int left = S - entry.getKey();
          if (map2.containsKey(left)){
              ans += (long)entry.getValue() * (long)map2.get(left);
          }
      }
      
    //   System.out.println(ans);
      for (Map.Entry<Integer,Integer> entry: map1.entrySet()){
          if (entry.getKey() == S){
              ans += (long)entry.getValue();
          }
      }
      
    //   System.out.println(ans);
      for (Map.Entry<Integer,Integer> entry: map2.entrySet()){
          if (entry.getKey() == S){
              ans += (long)entry.getValue();
          }
      }
      
      System.out.println(ans);
  }
  
  static void dfs (boolean one, int cnt, int idx, int limit, int sum){
      
    //   System.out.println(one + " " + cnt + " " + idx+ " " +sum);
      
      if (cnt != 0 ){
              if (one){
                  map1.merge(sum, 1, Integer::sum);
                }else{
                  map2.merge(sum, 1, Integer::sum);   
            }
    }
      if (idx == limit){
          return;
      }
      
      for (int i = idx; i < limit; i++){
          dfs(one, cnt + 1, i + 1, limit, sum + arr[i]);
      }
      
  }
}