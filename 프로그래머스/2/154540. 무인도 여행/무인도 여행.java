import java.util.*;

class Solution {
    int[][] map;
    int n;
    int m;
    int[] dx = new int[]{-1,1,0,0};
    int[] dy = new int[]{0,0,-1,1};
    
    public int[] solution(String[] maps) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        n = maps.length;
        m = maps[0].length();
        
        map = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Character now = maps[i].charAt(j);
                if (now == 'X') {
                    map[i][j] = -1;
                } else {
                    map[i][j] = now - '0';
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != -1) {
                    int tmpSum = bfs(i,j);
                    ans.add(tmpSum);
                }
            }
        }
        if (ans.isEmpty() ){
            return new int[]{-1};
        }
        
        return ans.stream().sorted().mapToInt(i -> i).toArray();
    }
    public int bfs(int x, int y) {
        Deque<int[]> queue = new ArrayDeque<>();
        
        int sum = map[x][y];
        map[x][y] = -1;
        queue.add(new int[]{x,y});
        
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= m 
                    || map[nx][ny] == -1) {
                    continue;
                }
                sum += map[nx][ny];
                map[nx][ny] = -1;
                queue.add(new int[]{nx, ny});
            }
            
        }
        return sum;
    }
    
}