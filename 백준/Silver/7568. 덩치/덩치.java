import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        int[][] A = new int[N][2];
        
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A[i][0] = a;
            A[i][1] = b;
        }
        
        int[] ans = new int[N];
        
        for (int i = 0; i < N; i++){
            int cnt = 1;
            for (int j = 0; j < N; j++){
                if (A[i][0] < A[j][0] && A[i][1] < A[j][1]) cnt++;
            }
            ans[i] = cnt;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < N; i++){
            sb.append(ans[i]).append(" ");
        }
        
        System.out.print(sb);
        
    }
}