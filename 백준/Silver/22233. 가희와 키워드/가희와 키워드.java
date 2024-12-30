import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        Set<String> words = new HashSet<>();
        
        for (int i = 0; i < N; i++){
            words.add(br.readLine());
        }
        
        StringBuilder sb = new StringBuilder();
        
        
        int ans = 0;
        for (int i = 0; i < M; i++){
            String[] line = br.readLine().split(",");
            for (int j = 0; j < line.length; j++){
                String now = line[j];
                if (words.contains(now)){
                    ans++;
                    words.remove(now);
                }
            }
            sb.append(N - ans).append("\n");
        }
        System.out.println(sb);
        
    }
}