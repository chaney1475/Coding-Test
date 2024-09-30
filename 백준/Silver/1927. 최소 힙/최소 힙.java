import java.util.*;
import java.io.*;


public class Main {
    
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int t = 0; t < N; t++){
            int x =  Integer.parseInt(br.readLine());
            if (x == 0){
                if (pq.isEmpty()){
                    System.out.println(0);
                }else{
                    System.out.println(pq.poll());
                }
            }else{
                pq.add(x);
            }
        }
        
        
    }
}