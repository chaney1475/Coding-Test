import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String line = br.readLine();
        String word = br.readLine();
        int N = line.length();
        int W = word.length();
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < N; i++) {
            sb.append(line.charAt(i)); 
            
            if (sb.length() >= W && sb.substring(sb.length() - W).equals(word)) {
                sb.delete(sb.length() - W, sb.length()); // 일치하면 삭제
            }
        }
        
        if (sb.length() != 0){
            System.out.print(sb);
        }else {
            System.out.print("FRULA");
        }
        
    }
}