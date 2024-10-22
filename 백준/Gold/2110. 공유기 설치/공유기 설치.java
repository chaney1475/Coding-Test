import java.io.*;
import java.util.*;

public class Main {
    static int[] a;
    static int N;
    
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        a = new int[N];

        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(a);

        int s = 1;
        int e = a[N-1];

        int ans = -1;

        while(s <= e) {
            int m = (s + e) / 2;
            if (getCnt(a,m) >= K) {
                ans = m;
                s = m + 1;
            } else {
                e = m - 1;
            }
        }

        System.out.print(ans);

    }
    
    static int getCnt(int[] a, int m) {
        int cnt = 1;
       
        int now = a[0] + m; // 처음 숫자
        while(true) {
            now = find(now);
            if (now == -1) break;
            cnt++;
            now += m;
        }
        
        return cnt;
    }
    
    static int find(int target){
        int ans = -1;
        int s = 0;
        int e = N-1;
        
        while(s <= e){
            int m = (s + e) / 2;
            if (a[m] >= target){
                ans = a[m];
                e = m - 1;
            }else{
                s = m + 1;
            }
        }
        return ans;
    }
    
}