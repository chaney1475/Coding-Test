import java.util.*;

class Solution {
    
    int[][] compu;
    boolean visited[];
    int n;
    int ans;
    
    public int solution(int n, int[][] computers) {
        this.n = n;
        visited = new boolean[n];
        compu = computers;
        
        ans = 0;
        
        for (int i = 0; i < n; i++){
            if (!visited[i]) {
                ans ++;
                bfs(i);
            }
        }
        
        return ans;
    }
    void bfs(int x){
        Queue<Integer> q = new LinkedList<>();
        
        visited[x] = true;
        q.add(x);
        
        System.out.println("시작 : " + x);
        
        while(!q.isEmpty()){
            
            int now = q.poll();
            
            for (int i = 0; i < n; i++){
                if (compu[now][i] == 1 && !visited[i]){
                    q.add(i);
                    visited[i] = true;
                }
            }
            
        }
        System.out.println(Arrays.toString(visited));
        
    }
}