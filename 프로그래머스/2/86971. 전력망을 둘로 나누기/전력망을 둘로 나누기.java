/*dfs 백번하기????*/
import java.util.*;

class Solution {
    static int ans;
    static int N;
    
    static boolean[][] graph;
    
    static Set<Integer> set;
    
    static Set<Integer> tmp;
    
    public int solution(int n, int[][] wires) {
        int answer = -1;
        
        N = wires.length;
        
        graph = new boolean[101][101];
        set = new HashSet<>();
        
        for (int i = 0; i < N; i++){
            graph[wires[i][0]][wires[i][1]] = true;
            graph[wires[i][1]][wires[i][0]] = true;
            set.add(wires[i][0]);
            set.add(wires[i][1]);
        }
        
        ans = 200;
        
        for (int i = 0; i < N; i++){
            graph[wires[i][0]][wires[i][1]] = false;
            graph[wires[i][1]][wires[i][0]] = false;
            
            cal();
            
            graph[wires[i][0]][wires[i][1]] = true;
            graph[wires[i][1]][wires[i][0]] = true;
        }
        
        return ans;
    }
    static void cal(){
        //방문한 점은 어떻게 할것인가?
        tmp = new HashSet<>();
        
        for (Integer now : set){
            if (! tmp.contains(now)){
                tmp.add(now);
                bfs(now);
                break;
            }
        }
        ans = Math.min(ans, Math.abs(set.size() - 2 * tmp.size()));
    }
    static void bfs(int k){
        Queue<Integer> q = new LinkedList<>();
        q.add(k);
        while(!q.isEmpty()){
            int now = q.poll();
            for (int i = 1; i < 101; i++){
                if (!tmp.contains(i) && graph[now][i]) {
                    q.add(i);
                    tmp.add(i);
                }
            }
            
        }
    }
}