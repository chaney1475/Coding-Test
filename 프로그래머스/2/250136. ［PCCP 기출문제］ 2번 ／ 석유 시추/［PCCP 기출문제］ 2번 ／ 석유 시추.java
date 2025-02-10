/*
하나하나 구해놓기
구해놓고 한줄 쭉 내려가면서 해당하는 곳을 더한다
*/
import java.util.*;

class Solution {
    static int[][] map;
    static boolean[][] visited;
    static int N, M;
    static int[] landSum;
    static int cnt = 2; // 땅번호
        
    public int solution(int[][] land) {
        int answer = 0;
        map = land;
        
        N = land.length;
        M = land[0].length;
        
        visited = new boolean[N][M];
        landSum = new int[N * M]; // 일단 최대로 지정
        
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (!visited[i][j] && map[i][j] == 1){
                    bfs(i,j);
                }
            }
        }
        
        int ans = -1;
        
        for (int j = 0; j < M; j++){
            int sum = 0;
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < N; i++){    
                if ( map[i][j] > 1 && !set.contains(map[i][j])){
                    sum += landSum[map[i][j]];
                    set.add(map[i][j]);
                }
                
            }
            ans = Math.max(ans, sum);
            
        }
        
        return ans;
    }
    static int[] dx = new int[]{0,0,-1,1};
    static int[] dy = new int[]{1,-1,0,0};
    
    void bfs(int i, int j){
        visited[i][j] = true;
        map[i][j] = cnt;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        
        int total = 1;
        // 2번 땅부터 땅
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            
            for (int d = 0; d < 4; d++){
                int nx = dx[d] + x;
                int ny = dy[d] + y;
                if(nx < 0|| nx >= N || ny < 0 || ny >= M || visited[nx][ny] ||
                   map[nx][ny] != 1)
                    continue;
                
                total++;
                map[nx][ny] = cnt;
                visited[nx][ny] = true;
                q.add(new int[]{nx,ny});
            }
            
        }
        
        landSum[cnt++] = total;
    }
}