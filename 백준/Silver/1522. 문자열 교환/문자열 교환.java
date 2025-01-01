import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String line = br.readLine();
        
        int cnt = 0;
        
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == 'a') cnt++;
        }
        
        int aMax = 0;
        for (int i = 0; i < line.length(); i++){
            int aCnt = 0;
            
            for (int j = 0; j < cnt; j++){
                int idx = (i + j < line.length() ? i + j : i + j - line.length());
                
                
                if (line.charAt(idx) == 'a') aCnt++;
                if (aCnt > aMax) aMax = aCnt;
            }
        }
        
        System.out.print(cnt - aMax);
    }
}