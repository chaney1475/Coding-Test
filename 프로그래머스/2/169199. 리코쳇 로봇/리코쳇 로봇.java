import java.util.*;

class Solution {
    static int[] dx = new int[]{0, -1, 0, 1};
    static int[] dy = new int[]{-1, 0, 1, 0};
    
    static char[][] map;
    
    static int N;
    static int M;
    
    static int startX;
    static int startY;
    
    static class Position{
        int x;
        int y;
        int cnt;
        
        Position(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    
    public int solution(String[] board) {
        
        N = board.length;
        M = board[0].length();
        
        map = new char[N][M];
        
        for (int i = 0; i < N; i++){
            for (int j = 0; j <M; j++){
                char tmp = board[i].charAt(j);
                if (tmp == 'R'){
                    startX = i;
                    startY = j;
                }
                map[i][j] = tmp;
            }
        }
        int answer = bfs(startX, startY);
        
        return answer;
    }
    static int bfs(int a, int b){
        int[][] dp = new int[N][M];
        
        for (int i = 0; i < N; i++) 
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        
        dp[a][b] = 0;
        
        Queue<Position> q = new LinkedList<>();
        q.add(new Position(a, b, 0));
        
        while (!q.isEmpty()){
            
            Position now = q.poll();
            int x = now.x;
            int y = now.y;
            int d = now.cnt;
            
            if (map[x][y] == 'G'){
                return d;
            }
            
            for (int i = 0; i < 4; i++){
                int nx = x;
                int ny = y;
            
                while(nx + dx[i] >= 0 && nx + dx[i] < N 
                    && ny + dy[i] >= 0 && ny + dy[i] < M
                    && (map[nx + dx[i]][ny + dy[i]] != 'D') 
                    ){
                    nx += dx[i];
                    ny += dy[i];
                }
                
                if (dp[nx][ny] > d + 1){
                    //도착 위치가 방문하지 않은 경우에는 방문한다
                    dp[nx][ny] = d + 1;
                    q.add(new Position(nx, ny, d + 1));
                }
            }
        }
        return -1;
    }
    
}