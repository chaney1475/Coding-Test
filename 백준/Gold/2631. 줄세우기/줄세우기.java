import java.util.*;
import java.io.*;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int[] A = new int[N];
        
        for (int i = 0; i < N; i++) {
        	A[i] = Integer.parseInt(br.readLine());
        }
        
        List<Integer> lis = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            int idx = Collections.binarySearch(lis, A[i]);
            if (idx < 0) idx = -(idx + 1);
            
            if (idx == lis.size()) {
                lis.add(A[i]);
            } else {
                lis.set(idx, A[i]);
            }
        }
        
        int ans = lis.size();
        
        System.out.println(N - ans);
    }
    

}
