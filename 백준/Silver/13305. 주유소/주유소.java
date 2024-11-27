import java.util.*;
import java.io.*;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        		
        st = new StringTokenizer(br.readLine());
        
        int[] dist = new int[N-1];
        
        for (int i = 0; i < N - 1; i++) {
        	dist[i] = Integer.parseInt(st.nextToken());
        }
        
        int ans = 0;
        int k = 0;
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N - 1; i++) {
        	
        	int now = Integer.parseInt(st.nextToken());
        	
        	if(i == 0) {
        		k = now;
        	}else {
        		k = Math.min(k,now);
        	}
        	
        	ans += k * dist[i];
        }
        
        System.out.println(ans);
        

    }

}
