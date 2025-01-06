import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        
        int[] A = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        int s = 0;
        int e = 0;
        
        int sum = 0;
        
        int ans = Integer.MAX_VALUE;
        
        while(e < N){
            
            sum += A[e];
            
            if (sum >= X){
                    ans = Math.min(ans, e - s + 1);
            }
            
            while(s <= e && sum > X){
                sum -= A[s];
                s++;
                              
                if (sum >= X){
                    ans = Math.min(ans, e - s + 1);
                }
            }
            
            e++;
        }
        
        System.out.print(Integer.MAX_VALUE == ans? 0 : ans);
    }
}