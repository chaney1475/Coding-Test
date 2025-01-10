import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        
        int[] list = new int[N * N];
        
        
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < N; j++) {
                int a = i * N + j;
                
                list[a] = Integer.parseInt(st.nextToken());
            }
        }
        
        Arrays.sort(list);
        
        System.out.print(list[N*(N-1)]);
        
    }
}