import java.util.*;

class Solution {
    static int N = 110;
    static int M = 110;
    static int[][] map;
    
    static int endX;
    static int endY;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        map = new int[N][M];
        //테두리만 
        endX = itemX * 2;
        endY = itemY * 2;
        
        for (int[] sq : rectangle){
            int x1 = sq[0] << 1;
            int y1 = sq[1] << 1;
            int x2 = sq[2] << 1;
            int y2 = sq[3] << 1;
            
            //한변씩 다 1로 표기하기
            for (int i = x1; i <= x2; i++){
                map[i][y1] = map[i][y1] == 2 ? 2 : 1;
                map[i][y2] = map[i][y2] == 2 ? 2 : 1;
            }
            for (int i = y1; i <= y2; i++){
                map[x1][i] = map[x1][i] == 2 ? 2 : 1;
                map[x2][i] = map[x2][i] == 2 ? 2 : 1;
            }
            
            for (int i = x1 + 1; i < x2; i++){
                map[i][y1+1] = 2;
                map[i][y2-1] = 2;
            }
            
            for (int i = y1 + 1; i < y2; i++){
                map[x1+1][i] = 2;
                map[x2-1][i] = 2;
            }

        }
        
        int ans = bfs(characterX * 2, characterY * 2);
        
        return ans;
    }
    
    static int[] dx = new int[]{0,0,-1,1};
    static int[] dy = new int[]{-1,1,0,0};
    
    static int bfs(int a, int b){
        
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{a,b,1});
        
        boolean[][] visited = new boolean[N][M];
        visited[a][b] = true;
        
        while (!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            
            if (x == endX && y == endY){
                return now[2] / 2;
            }
            
            for (int d = 0; d < 4; d++){
                int nx = dx[d] + x;
                int ny = dy[d] + y;
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) continue;
                if (map[nx][ny] == 1){
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, now[2] + 1});
                }
            }
        }
        return -1;
        
    }
}