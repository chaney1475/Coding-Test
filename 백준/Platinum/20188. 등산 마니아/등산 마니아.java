import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] tree;
    static int[] dp;
    static int N;
    static long ans = 0;
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N+1];
        
        for (int i = 1; i <= N; i++){
            tree[i] = new ArrayList<>();
        }
        
        dp = new int[N+1];
        
        for (int i = 0; i < N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            tree[a].add(b);
            tree[b].add(a);
        }
        
        dp(1);
        
        System.out.print(ans);
    }
    
    public static int dp(int now){
        dp[now] = 1;
        
        for (int next: tree[now]){
            if(dp[next] == 0){
                dp[now] += dp(next);
            }
        }
        
        if (now != 1){
            ans += comb(N) - comb(N - dp[now]);
        }
        
        return dp[now];
    }
    
    public static long comb(int n){
        return (long)n * (long)(n-1) / 2;
    }
}