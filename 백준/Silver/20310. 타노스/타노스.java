import java.util.*;
import java.io.*;

public class Main {
	
    public static void main(String args[]) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String s = br.readLine();
    	int[] A = new int[s.length()];
    	
    	int cntZ = 0;
    	int cntO = 0;
    	
    	for (int i = 0; i < s.length(); i++) {
    		int now = s.charAt(i) - '0';
    		A[i] = now;
    		if (now == 0) cntZ++;
    		else cntO++;
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	
    	int n = 0;
    	int m = 0;
    	
    	
    	for (int i = 0; i < s.length(); i++) {
    		int now = A[i];
    		
    		if (now == 0) {
    			n++;
    			if (n <= cntZ / 2) sb.append(0);
    		}else {
    			m++;
    			if (m > cntO / 2) sb.append(1);
    		}
    	}
    	System.out.println(sb);
    	
    }
    
    
}