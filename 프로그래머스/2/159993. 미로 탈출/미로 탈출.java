/*
출구는 true가 되기 전까지는 그냥 길이다
레버를 당기면 true가 되고 그 다음에 출구로 가야함!
1차로 레버가기 
2차로 출구가기

*/
import java.util.*;

class Solution {
    static char[][] map;
    
    static int N;
    static int M;
    
    static int[] dx = new int[]{0,0,-1,1};
    static int[] dy = new int[]{-1,1,0,0};
    
    static class Position{
        int x, y, dist;
        
        Position(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
        Position(){}
    }
    
    public int solution(String[] maps) {
        int answer = -1;
        N = maps.length;
        M = maps[0].length();
        
        map = new char[N][M];
        
        Position start = new Position(); 
        Position lever = new Position(); 
        Position end = new Position(); 
            
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                map[i][j] = maps[i].charAt(j);
                if (map[i][j] == 'S'){
                    start.x = i; start.y = j; start.dist = 0;
                }else if(map[i][j] == 'L'){
                    lever.x = i; lever.y = j; lever.dist = 0;
                }else if (map[i][j] == 'E'){
                    end.x = i; end.y = j; end.dist = 0;
                }
            }
            // System.out.println(Arrays.toString(map[i]));
        }
        // System.out.println("시작에서 레버가기");
        int a1 = bfs(start, lever);
        
        // System.out.println("레버에서 끝가기");
        int a2 = bfs(lever, end);
        
        // System.out.println(a1 + ", " + a2);
        
        if (a1 != -1 && a2 != -1){
            answer = a1 + a2;
        }
        
        return answer;
    }
    
    static int bfs(Position start, Position end){
        
        Queue<Position> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        visited[start.x][start.y] = true;
        q.offer(start);
        
        while(!q.isEmpty()){
            Position now = q.poll();
            
            int x = now.x;
            int y = now.y;
            int dist = now.dist;
            
            if (x == end.x && y == end.y){
                return dist;
            }
            
            for (int d = 0; d < 4; d++){
                int nx = dx[d] + x;
                int ny = dy[d] + y;
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) continue;
                if (map[nx][ny] != 'X'){
                    visited[nx][ny] = true;
                    q.add(new Position(nx, ny, dist + 1));
                }
            }
            
        }
        
        return -1;
    }
}