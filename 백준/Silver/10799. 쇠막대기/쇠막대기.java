import java.util.*;
import java.io.*;


public class Main {
    public static void main(String args[]) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //pollLast로 빼기
        
        String s = br.readLine();
        int N = s.length();
        
        
        int[] cnt = new int[N];
        
        ArrayList<Integer> ls = new ArrayList<>();
        
        for (int i = 0; i < s.length(); i++){
        	
            char now = s.charAt(i);
            if (i + 1 < s.length() && now == '(' && s.charAt(i + 1) == ')'){
            	plus(ls, cnt);
            	i++;
            }else if(!ls.isEmpty() && s.charAt(ls.get(ls.size()-1)) == '(' && now == ')'){
                ls.remove(ls.size()-1);
            }else{
                ls.add(i);
            }
        }
        
        int ans = 0;
        
        for (int i = 0; i < N; i++){
        	if (cnt[i] != 0) {
        		ans += (cnt[i] + 1);
        	}
        }
        
        System.out.println(ans);
        
    }
    
    static void plus(ArrayList<Integer> ls, int[] cnt){
    	for (Integer i : ls) {
    		cnt[i]++;
    	}
    	
    }
  
}