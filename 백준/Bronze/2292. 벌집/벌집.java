import java.util.*;
import java.io.*;


public class Main {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        //일단 한겹씩 추가
        
        int cnt = 1;
        
        N -= 1;
        
        for (int i = 1; i <= 1000000000; i++){
            
            if (N >= i * 6){
                
                N -= i * 6;
                
            }else{
                break;
            }
            
            cnt++;
        } 
        //
        if (N != 0){
            cnt++;
        }
        
        System.out.print(cnt);
        
    }
}