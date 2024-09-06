import java.util.*;
import java.io.*;

public class Main
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M;
    static int a;
    static int b;

    // tip: arguments are passed via the field below this editor
    public static void main(String[] args) throws Exception
    {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        int n1, n2;
        n1 = N / (a + 1);
        if (N % (a + 1) != 0){
            n1 += 1;
        }
        n2 = M / (b + 1);
        if (M % (b+1) != 0){
            n2 += 1;
        }
        System.out.println(n1 * n2);
    }
}