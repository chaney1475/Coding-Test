import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        
        int[] A = new int[W];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        // 계산
        int total = 0;
        for (int i = 1; i < W - 1; i++) {
            
            int leftMax = 0, rightMax = 0;
            
            for (int j = 0; j <= i; j++) {
                leftMax = Math.max(leftMax, A[j]);
            }
            
            for (int j = i; j < W; j++) {
                rightMax = Math.max(rightMax, A[j]);
            }
            
            total += Math.max(0, Math.min(leftMax, rightMax) - A[i]);
        }
        
        System.out.println(total);
    }
}
