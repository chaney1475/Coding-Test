/**
bfs를 통해서 일단 1인애들을 다 저장을 함
--> 발견 될때마다 fuel = 0초기화
발견하면 fuel++;
새롭게 fuel을 추가하면 
List에다가 fuel의 cnt 추가하기
1일 떼 cnt = 10 0

fuelArray = new int[N * M];
*/

import java.util.*;

class Solution {
    static int N;
    static int M;
    static int landCnt;
    static boolean[][] visited;
    static int[] landArray;
    
    static class Point{
        int x, y;
        
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int solution(int[][] land) {
        int answer = 0;
        
        N = land.length;
        M = land[0].length;
        visited = new boolean[N][M];
        
        landCnt = 1;
        
        landArray = new int[N * M];
            
        for (int j = 0; j < M; j++){
            for (int i = 0; i < N; i++){
                if (!visited[i][j] && land[i][j] == 1){
                    visited[i][j] = true;
                    land[i][j] = landCnt;
                    bfs(new Point(i,j), land);
                    landCnt++;
                }
            }
        }
        
        Set<Integer> set = new HashSet<>();
        
        for (int j = 0; j < M; j++){
            int temp = 0;
            set.clear();
            for (int i = 0; i < N; i++){
                set.add(land[i][j]);
            }
            Iterator<Integer> it = set.iterator();
            
            while(it.hasNext()){
                temp += landArray[it.next()];
            }
            answer = Math.max(temp, answer);
        }
        
        return answer;
    }
    static int[] dx = new int[] {0,0,-1,1};
    static int[] dy = new int[] {1,-1,0,0};
    
    static void bfs(Point start, int[][] land){
        int cnt = 1; // 나 자신부터 세야하므로
        Queue<Point> q = new LinkedList<>();
        q.add(start);
        
        while (! q.isEmpty() ){
            Point now = q.poll();
            int x = now.x;
            int y = now.y;
            
            for (int d = 0; d < 4; d++){
                int nx = dx[d] + x;
                int ny = dy[d] + y;
                
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny])
                    continue;
                
                if (land[nx][ny] == 1){
                    visited[nx][ny] = true;
                    land[nx][ny] = landCnt;
                    cnt++;
                    q.add(new Point(nx, ny));
                }
                
            }
        }
        landArray[landCnt] = cnt; //해당 대지의 크기 저장하기
    }
}