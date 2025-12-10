import java.util.*;

class Solution {
    
    public int[] solution(String[] park, String[] routes) {
        int[] dx = new int []{0,0,1,-1};
        int[] dy = new int []{1,-1,0,0};
        Map<Character, Integer> go = new HashMap();
        go.put('E', 0);
        go.put('W', 1);
        go.put('S', 2);
        go.put('N', 3);
        
        // 0 -> E
        // 1 -> W
        // 2 -> S
        // 3 -> N
         
        int x = 0;
        int y = 0;
        int n = park.length;
        int m = park[0].length();
        
        int[][] grid = new int[n][m];
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                
                char now = park[i].charAt(j);
                
                if (now == 'S'){
                    x = i;
                    y = j;
                    grid[i][j] = 1;
                }else if (now == 'X'){
                    grid[i][j] = -1;
                }
            }
        }
        
        int R = routes.length;
        
        for (int i = 0; i < R; i++){
            
            char D = routes[i].charAt(0);
            int cnt = routes[i].charAt(2) - '0';
            
            int d = go.get(D);
            
            int temp_x = x;
            int temp_y = y;
            int flag = 1;
            
            for (int j = 0; j < cnt; j++){
                int nx = dx[d] + temp_x;
                int ny = dy[d] + temp_y;
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] != -1) {
                    temp_x = nx;
                    temp_y = ny;
                }else{
                    flag = 0;
                    break;
                }
            }
            if (flag == 1){
                x = temp_x;
                y = temp_y;
            }
        }
        int[] answer = new int[]{x,y};
        return answer;
    }
}