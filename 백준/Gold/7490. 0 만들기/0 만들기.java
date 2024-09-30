import java.util.*;
import java.io.*;

public class Main {
    static int[] temp;
    static char[] cals = new char[] {' ', '+', '-'};
    
    static int N;
    
  public static void main(String args[]) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int T = Integer.parseInt(br.readLine()); 
      for (int t = 0; t < T; t++){
       
        N = Integer.parseInt(br.readLine());
       
        temp = new int[N - 1];// 0부터 n-2까지
        
        make(0 , "1");
        System.out.println();
      }
      
      
  }
  static void make(int cnt, String result){
	  
      if (cnt == N-1){
          //계산해서 0이면 출력 
    	  
          if (isZero()){
              System.out.println(result);
          }
          return;
      }
      
      for (int i = 0; i < 3; i++){
          temp[cnt] = i;
          make(cnt + 1, result + cals[i] + (cnt + 2));
      }
  }
  
  static boolean isZero(){
	  int a = 1;
      List<Integer> nums = new ArrayList<Integer>();
      int n = a;
      
      for (int i = 0; i < N - 1; i++) {
    	    int t = temp[i];

    	    if (t == 0) {
    	        n = n * 10 + (i + 2); // 숫자를 이어 붙임
    	    } else if (t == 1 || t == 2) {
    	        nums.add(n); 
    	        n = i + 2;
    	    }
    	}
      
      nums.add(n);
      int result = nums.get(0); // 첫 번째 숫자부터 시작
      int idx = 1; // nums의 두 번째 숫자부터 접근
      
      for (int i = 0; i < N - 1; i++) {
          int t = temp[i];
          
          if (t == 1) {
              result += nums.get(idx); // 연산자가 +이면 더함
              idx++;
          } else if (t == 2) {
              result -= nums.get(idx); // 연산자가 -이면 뺌
              idx++;
          }
      }
      
      return result == 0;
      
  }
}