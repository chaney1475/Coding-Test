import java.util.*;
import java.io.*;

public class Main {
	
    public static void main(String args[]) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int N = Integer.parseInt(br.readLine());
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int[] A = new int[N];
    	
    	int[] cnt = new int[1000001];
    	
    	for (int  i = 0; i < N; i++) {
    		A[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	int s = 0;
    	int e = 0;
    	
    	long sum = 0;
    	
    	while (e < N) {
    		
    		if (++cnt[A[e]] > 1) {
    			while(--cnt[A[s]] == 0) {
    				s++;
    			}
    			s++;
    		}

			e++;
			sum += e - s;
    	}
    	
    	System.out.println(sum);
    	
    }
    
    
}