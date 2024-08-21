import java.util.*;
import java.io.*;
 
public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);
    static StringTokenizer st; 
     
    static int D, W, K;
    static int[][] arr = new int[18][25];
    static int[] drug;
     
    static void init() throws Exception {
        flag = false;
        drug = new int[18];
        st = new StringTokenizer(br.readLine());
        D = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
         
        for(int i = 0; i < D; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < W; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken())+1;
            }
        }
    }
     
    static boolean judgeCell(int i) {
        int combo = 0;
        int d = -1;
        for(int j = 0; j < D; j++) {
            int nowD = -1;
            if(drug[j] == 0) nowD = arr[j][i];
            else if(drug[j] == 1) nowD = 1;
            else if(drug[j] == 2) nowD = 2;
            if(d == nowD) combo++;
            else {
                combo = 1;
                d = nowD;
            }
            if(combo >= K) return true;
        }
        return false;
    }
     
    static boolean judgeFilm() {
        for(int i = 0; i < W; i++) {
            if(!judgeCell(i)) return false;
        }
        return true;
    }
    static boolean flag;
    static void combi(int n, int cnt, int k) {
        if(cnt == k) {
            if(judgeFilm()) flag = true;
            return;
        }
        if(n == D) return;
        drug[n] = 1;
        combi(n+1, cnt+1, k);
        drug[n] = 2;
        combi(n+1, cnt+1, k);
        drug[n] = 0;
        combi(n+1, cnt, k);
    }
    static void changeCell(int k) {
        flag = false;
        combi(0,0,k);
    }
 
    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            init();
            int idx = 0;
            while(!flag) {
                changeCell(idx++);
            }
            pw.printf("#%d %d\n", t, idx-1);
        }
        pw.close();
    }
}