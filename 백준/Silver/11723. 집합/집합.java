import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        Set<Integer> set = new HashSet<>();
        
        StringBuilder sb = new StringBuilder();
        
        for (int t = 0; t < N ; t++){
            
            String[] line = br.readLine().split(" ");
            
            int num = -1;
            if (line.length > 1){
                num = Integer.parseInt(line[1]);
            }
            
            String act = line[0];
            
            if (act.equals("add")){
                set.add(num);
            }else if (act.equals("remove")){
                set.remove(num);
            }else if (act.equals("check")){
                if (set.contains(num)){
                    sb.append(1).append("\n");
                }else{
                    sb.append(0).append("\n");
                }
            }else if (act.equals("toggle")){
                if (set.contains(num)){
                    // 있으면 제거하고
                    set.remove(num);
                }else{
                    set.add(num);
                }
            }else if (act.equals("all")){
                for (int i = 1; i <= 20; i++){
                    set.add(i);
                }
                
            }else {
                // s를 공집합으로
                set.clear();
            }
            
        }
        System.out.print(sb);
        
    }
}