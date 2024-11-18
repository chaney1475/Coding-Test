import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        
        int newScore = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int[] scores = new int[N];
        
        if (N > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                scores[i] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 1등
        if (N == 0) {
            System.out.println(1);
            return;
        }

        if (newScore <= scores[N - 1] && N == P) {
            System.out.println(-1);
            return;
        }

        int rank = 1;
        
        for (int i = 0; i < N; i++) {
            if (newScore < scores[i]) {
                rank++;
            } else {
                break;
            }
        }

        System.out.println(rank);
    }
}
