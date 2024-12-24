import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        boolean[] used = new boolean[26];
        
        int N = Integer.parseInt(br.readLine());
        
        String[][] lines = new String[N][];
        
        for (int i = 0; i < N; i++) {
            lines[i] = br.readLine().split(" ");
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < N; i++) {
            
            int chosenWordIndex = -1;
            int chosenCharIndex = -1;
            
            // 단어한개씩 보기
            for (int w = 0; w < lines[i].length; w++) {
                String word = lines[i][w];
                if (word.isEmpty()) continue;
                
                char c = Character.toLowerCase(word.charAt(0));
                int idx = c - 'a';
                
                if (!used[idx] && idx >= 0 && idx < 26) {
                    used[idx] = true;
                    chosenWordIndex = w;
                    chosenCharIndex = 0;
                    break;
                }
            }
            
            if (chosenWordIndex == -1) {
                outerLoop: 
                for (int w = 0; w < lines[i].length; w++) {
                    String word = lines[i][w];
                    for (int cIdx = 0; cIdx < word.length(); cIdx++) {
                        char c = Character.toLowerCase(word.charAt(cIdx));
                        int idx = c - 'a';
                        
                        if (idx < 0 || idx >= 26) {
                            continue;
                        }
                        if (!used[idx]) {
                            used[idx] = true;
                            chosenWordIndex = w;
                            chosenCharIndex = cIdx;
                            break outerLoop;
                        }
                    }
                }
            }
            
            if (chosenWordIndex == -1) {
                sb.append(String.join(" ", lines[i])).append("\n");
            } else {
                for (int w = 0; w < lines[i].length; w++) {
                    String word = lines[i][w];
                    
                    if (w == chosenWordIndex) {
                        // 앞 부분
                        sb.append(word, 0, chosenCharIndex);
                        // []
                        sb.append("[")
                          .append(word.charAt(chosenCharIndex))
                          .append("]");
                        // 뒷 부분
                        sb.append(word.substring(chosenCharIndex + 1));
                    } else {
                        // 그냥 출력
                        sb.append(word);
                    }
                    
                    if (w < lines[i].length - 1) {
                        sb.append(" ");
                    }
                }
                sb.append("\n");
            }
        }
        
        System.out.print(sb.toString());
    }
}
