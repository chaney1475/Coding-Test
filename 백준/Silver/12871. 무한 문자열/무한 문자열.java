import java.util.*;
import java.io.*;

// 두개의 공약수가 있음 ->
// 그 공약수만큼 수를 잘라서 같다면 같음!

public class Main {
    static String a;
    static String b;
    
    static boolean checkLen(int i){
        return ( a.length() % i == 0 ) && (b.length() % i == 0); 
    }
    static boolean checkString(int x){
        
        //각 조각이 모두 숫자가 같아야함
        String tmp = "";
        
        for (int i = 0; i < x; i++){
            if (a.charAt(i) != b.charAt(i)){
                return false;
            }
            tmp += a.charAt(i);
        }
        for (int i = 0; i < a.length(); i++){
            if (a.charAt(i) != tmp.charAt(i % x))
                return false;
        }
        for (int i = 0; i < b.length(); i++){
            if (b.charAt(i) != tmp.charAt(i % x))
                return false;
        }
        
        return true;
    }
    
    public static void main(String args[]) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = br.readLine();
        b = br.readLine();
        
        for (int i = 1; i <= Math.min(a.length(), b.length()); i++){
            if (checkLen(i) && checkString(i)){
                System.out.println("1");
                System.exit(0);
            }
        }
        
        System.out.println("0");
        
    }
    
    
}