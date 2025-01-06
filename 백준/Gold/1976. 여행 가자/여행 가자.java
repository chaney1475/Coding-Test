import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static boolean[] plan;
    static boolean[] visited;
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        map = new int[N][N];
    
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[] list = new int[M];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++){
            list[i] = Integer.parseInt(st.nextToken()) - 1;
        }
        
        visited = new boolean[N];
        
        boolean ans = false;
        
        for (int i = 0; i < N ;i++){
            if (visited[i]) continue;
            
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            visited[i] = true;
            
            Set<Integer> set = new HashSet<>();
            
            set.add(i);
            
            visited[i] = true;
            while(!q.isEmpty()){
                i = q.poll();
            for (int j = 0; j < N; j++){
                if (map[i][j] == 1 && !visited[j]) {
                    q.add(j);
                    visited[j] = true;
                    set.add(j);
                }
            }
            }
            
            if(check(list, set)) {
                ans = true;
                break;
            }
        }
        
        System.out.print(ans? "YES" : "NO");
    }
    static boolean check(int[] list, Set<Integer> set){
        
            for (int k = 0; k < M; k++){
                if ( !set.contains(list[k])) return false;
            }
        return true;
    }
    
}