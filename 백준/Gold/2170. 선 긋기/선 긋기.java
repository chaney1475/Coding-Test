import java.util.*;
import java.io.*;

public class Main
{
    static class Point{
        int start, end;
        Point(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    int N = Integer.parseInt(br.readLine()); // 선은 그은 횟수
	    Point[] lines = new Point[N];
	    for (int i = 0; i < N; i++){
	        st = new StringTokenizer(br.readLine());
	        int a = Integer.parseInt(st.nextToken());
	        int b = Integer.parseInt(st.nextToken());
	        lines[i] = new Point(a,b);
	    }
	    
	    Arrays.sort(lines, (a,b) -> {
	        if(a.start != b.start) return Integer.compare(a.start, b.start);
	        else return Integer.compare(b.end, b.end);
	    });
	    
	    int S = lines[0].start;
	    int E = lines[0].end;
	    
	    int sum = 0; 
	    
	    for (int i = 1; i < N; i++){
	        Point now = lines[i];
	        int start = now.start;
	        int end = now.end;
	        
	        if(start <= E){
	            E = Math.max(end, E);
	        }else {
	        	sum += E - S;
	            S = start;
	            E = end;
	        }
	    }
	    
	    sum += E - S;
	    
	    System.out.print(sum);
	}
}
