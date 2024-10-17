

import java.util.*;

class Solution {
    static int[] dx = new int[] {0,0,-1,1};
    static int[] dy = new int[] {-1,1,0,0};
    
    static int N;
    static int M;
    
    static int[][] map;
    static boolean[][] visited;
    
    public int[] solution(String[] maps) {
        
        N = maps.length;
        M = maps[0].length();
        
        map = new int[N][M];
        visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                char tmp = maps[i].charAt(j);
                if (tmp != 'X'){
                    map[i][j] = tmp - '0';
                }
            }
        }
        
        
        List<Integer> lands = new ArrayList<>();
        
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (visited[i][j] || map[i][j] == 0) continue;
                lands.add(bfs(i,j));
            }
        }
        
        if (lands.size()  == 0){
            return new int[] {-1};
        }
        
        Collections.sort(lands);
        
        int[] answer = new int[lands.size()];
        int idx = 0;
        
        for (Integer i : lands){
            answer[idx++] = i;
        }
        
        return answer;
        
    }
    
    static int bfs(int a, int b){
        Queue <int[]> q = new LinkedList<>();
        q.add(new int[] {a,b});
        visited[a][b] = true;
        int sum = map[a][b];
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            
            for (int d = 0; d < 4; d++){
                int nx = dx[d] + x;
                int ny = dy[d] + y;
                
                if (nx < 0 || nx >= N || ny < 0 || ny >= M 
                    || visited[nx][ny] || map[nx][ny] == 0) continue;
                
                sum += map[nx][ny];
                visited[nx][ny] = true;
                q.add(new int[] {nx, ny});
            }
            
        }
        
        return sum;
        
    }
    
}