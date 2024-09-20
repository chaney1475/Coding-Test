import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String args[]) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0;  i < N; i++){
            String word = br.readLine();
            
            if(word.length() >= M){
                map.put(word, map.getOrDefault(word,0) + 1);
            }
            
        }
        
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());

        entries.sort((a, b) -> {
            if (!a.getValue().equals(b.getValue())) {
                return b.getValue() - a.getValue(); // 값
            } else if (a.getKey().length() != b.getKey().length()) {
                return b.getKey().length() - a.getKey().length(); // 문자열 길이
            } else {
                return a.getKey().compareTo(b.getKey()); 
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : entries) {
            sb.append(entry.getKey() + "\n");
        }
        System.out.println(sb);
    }

}