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
	    ArrayList<Point> lines = new ArrayList<Point>();
	    
	    for (int i = 0; i < N; i++){
	        st = new StringTokenizer(br.readLine());
	        int a = Integer.parseInt(st.nextToken());
	        int b = Integer.parseInt(st.nextToken());
	        lines.add(new Point(a,b));
	    }
	    
	    Collections.sort(lines, (a,b) -> a.start - b.start);
	    
	    int S = lines.get(0).start;
	    int E = lines.get(0).end;
	    
	    int sum = 0; 
	    
	    for (int i = 1; i < N; i++){
	        Point now = lines.get(i);
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
