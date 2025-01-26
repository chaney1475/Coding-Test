import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] a = new int[n + 1][m + 1];
        int[][] s = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
                s[i][j] = a[i][j] + s[i][j - 1] + s[i - 1][j] - s[i - 1][j - 1];
            }
        }

        int ans = Integer.MIN_VALUE;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int i1 = 0; i1 < i; i1++) {
                    for (int j1 = 0; j1 < j; j1++) {
                        ans = Math.max(ans, s[i][j] - s[i1][j] - s[i][j1] + s[i1][j1]);
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
