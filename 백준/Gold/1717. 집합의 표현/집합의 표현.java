import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] rep;

    // 집합의 표현
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        rep = new int[n+1];
        
        for (int i = 1; i < n+1; i++) {
            rep[i] = i;
        }

        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 0){
                union(b, c);
            }else{
                sb.append((find(b) == find(c)) ? "YES\n" : "NO\n");
            }
        }
        System.out.println(sb);
    }

    static boolean union(int x, int y){
        x = find(x);
        y = find(y);

        if (x == y){
            return false;
        }
        if (x < y) rep[y] = x;
        else rep[x] = y;
        return true;
    }

    static int find(int x){
        if (x != rep[x]){
            rep[x] = find(rep[x]);
        }
        return rep[x];
    }

}
