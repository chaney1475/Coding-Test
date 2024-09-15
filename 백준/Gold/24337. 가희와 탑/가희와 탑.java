import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        if (N < A + B - 1){
            System.out.println("-1");
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        
        //기본 배열 만들기
        
        if (A == 1){
            sb.append(Math.max(A,B)).append(" ");
            for (int i = 0; i < N - (A+B-1); i++){
                sb.append("1 ");
            }
            for (int i = B-1; i >= 1; i--){
                sb.append(i).append(" ");
            }
        }else{
            for (int i = 0; i < N - (A+B-1); i++){
                sb.append("1 ");
            }
            for (int i = 1; i <= A-1; i++){
                sb.append(i).append(" ");
            }
        
            sb.append(Math.max(A,B)).append(" ");
            for (int i = B-1; i >= 1; i--){
                sb.append(i).append(" ");
            }
        
        }
        
        sb.deleteCharAt(sb.length()-1);
        
        
        System.out.println(sb);
  }
 
}