import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        Deque<Character> dq = new ArrayDeque<>();
        
        int N = str.length();
        
        for (int i = 0; i < N; i++){
            dq.addLast(str.charAt(i));
        }
        
        int i = 1;
        
        while (!dq.isEmpty()) {
            check(String.valueOf(i), dq);
            i++;
        }
        System.out.print(i-1);
        
    }
    
    static void check (String str, Deque<Character> dq){
        
        for (int i = 0; i < str.length() && !dq.isEmpty(); i++){
            if (dq.getFirst() == str.charAt(i)){
                dq.poll();
            }
        }
        
    }
}