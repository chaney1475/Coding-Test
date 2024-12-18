import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        String s1 = br.readLine();
        String s2 = br.readLine();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = s1.charAt(i)-'0';
        
        int[] b = new int[n];
        for (int i = 0; i < n; i++) b[i] = s2.charAt(i)-'0';

        int[] c = Arrays.copyOf(a, n);
        c[0] = 1 - c[0];
        c[1] = 1 - c[1];

        int answer = solve(n, a, b);
        int answer2 = solve(n, c, b);
        if (answer2 != -1) answer2++;

        if (answer == -1)
            System.out.println(answer2);
        else if (answer2 == -1)
            System.out.println(answer);
        else
            System.out.println(Math.min(answer2, answer));
    }

    static int solve(int n, int[] a, int[] b) {
        int cnt = 0;

        for (int i = 0; i < n-1; i++) {
            if (a[i]!=b[i]) {
                cnt++;
                a[i] = 1-a[i];
                a[i+1] = 1-a[i+1];
                if (i != n-2)
                    a[i+2] = 1-a[i+2];
            }
        }

        return a[n-1]!=b[n-1] ? -1 : cnt;
    }
}
