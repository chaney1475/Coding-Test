import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();  
        String T = br.readLine();  

        System.out.println(bfs(S, new StringBuilder(T)));
    }

    static int bfs(String S, StringBuilder T) {
        Queue<StringBuilder> queue = new LinkedList<>();
        queue.add(T);

        while (!queue.isEmpty()) {
            StringBuilder current = queue.poll();

            if (current.toString().equals(S)) {
                return 1;
            }

            if (current.length() < S.length()) {
                continue;
            }

            if (current.charAt(current.length() - 1) == 'A') {
                StringBuilder next = new StringBuilder(current);
                next.deleteCharAt(next.length() - 1);
                queue.add(next);
            }

            if (current.charAt(0) == 'B') {
                StringBuilder next = new StringBuilder(current);
                next.deleteCharAt(0).reverse();
                queue.add(next);
            }
        }
        
        return 0;
    }
}
