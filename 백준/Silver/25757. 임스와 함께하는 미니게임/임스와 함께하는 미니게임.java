import java.util.*;
import java.io.*;


public class Main {
    
    static int N;
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        String game = st.nextToken();
        
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++){
            String s = br.readLine();
            set.add(s);
        }
        int ans = 0;
        int size = set.size();
        
        if (game.equals("Y")){
            ans = size;
        }else if(game.equals("F")){
            ans = size / 2;
        }else{
            ans = size / 3;
        }
        System.out.println(ans);
    }
}