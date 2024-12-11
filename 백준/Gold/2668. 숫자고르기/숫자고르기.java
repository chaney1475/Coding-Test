import java.util.*;
import java.io.*;

public class Main {
    
    static ArrayList<Integer> list;
    static boolean visited[];
    static int[] A;
    
    public static void main(String args[]) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        A = new int[N + 1];
        
        for (int i = 0; i < N; i++){
            A[i + 1] = Integer.parseInt(br.readLine());
        }
        
        list = new ArrayList<>();
        
        visited = new boolean[N + 1];
        for(int i = 1; i <= N; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }
        
        Collections.sort(list);
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(list.size()).append("\n");
        
        for(int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append("\n");
        }
        
        System.out.print(sb);
    }
    
    public static void dfs(int now, int target) {
        
        if(!visited[A[now]]) {
            visited[A[now]] = true;
            dfs(A[now], target);
            visited[A[now]] = false;
        }
        
        if(A[now] == target) list.add(target);
    }
}