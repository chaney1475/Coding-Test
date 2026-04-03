import java.util.*;

class Solution {

    int[] dx = {0,0,-1,1};
    int[] dy = {-1,1,0,0};

    public int solution(int[][] maps) {

        int n = maps.length;
        int m = maps[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(maps[nx][ny] != 1) continue;

                maps[nx][ny] = maps[x][y] + 1;
                q.add(new int[]{nx,ny});
            }
        }

        return maps[n-1][m-1] == 1 ? -1 : maps[n-1][m-1];
    }
}