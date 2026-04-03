import java.util.*;    
class Solution {
    int count = 0;
    boolean[] visited;
    int n;
    int[][] computers;
    public int solution(int n, int[][] computers) {
        
        count = 0;
        visited = new boolean[n]; // 0부터 n-1까지의 
        this.n = n;
        this.computers = computers;
        
        int answer = 0;
        // 0번부터 n-1까지의 컴퓨터가 있음
        // 싹 돌아서 네트워크를 읽기
        
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            count++;
            visited[i] = true;
            dfs(i); // 특정 컴퓨터와 연결된 모든 네트워크 방문하기
        }
        
        return count;
    }
    
    public void dfs(int node) {
        
        for (int i = 0; i < n; i++) {
            if (visited[i] || computers[node][i] == 0) continue;
            visited[i] = true;
            dfs(i);
        }
    }
    
}