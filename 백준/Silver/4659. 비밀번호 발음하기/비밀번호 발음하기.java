import java.io.*;
import java.util.*;

public class Main {
        static Set<Character> set = new HashSet<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String now = br.readLine();

        StringBuilder sb = new StringBuilder();
        Collections.addAll(set, 'a','e','i','o','u');
        
        while(!now.equals("end")){
            if (checkCnt(now) && notSequence(now)){
                sb.append("<").append(now).append(">").append(" is acceptable.\n");
            }else{
                sb.append("<").append(now).append(">").append(" is not acceptable.\n");
            }
            now = br.readLine();
        }
        
        System.out.print(sb);
    }

    static boolean checkCnt(String str){
        
        int n = str.length();
        int cnt = 0;
        
        for (int i = 0; i < n; i++){
            if(set.contains(str.charAt(i)))
                cnt++;
        }
        if (cnt == 0) return false;
        else return true;
    }

    static boolean notSequence(String str){

        int n = str.length();
        
        int cnt1 = 0;
        int cnt2 = 0;

        int before = -1;
        int same = 0;
        
        for (int i = 0; i < n; i++){
            char now = str.charAt(i);
            if(set.contains(now)){
                cnt1++;
                cnt2 = 0;
            }
            else{
                cnt2++;
                cnt1 = 0;
            }
            if (cnt1 == 3 || cnt2 == 3){
                return false;
            }
            
            if (now != 'e' && now != 'o' && before == now - 'a'){
                return false; 
            }
            
            before = now - 'a';
            
        }
        return true;
    }
}
