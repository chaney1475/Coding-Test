import java.util.*;

class Solution {
    boolean[][][] map;
    int[][] grid2; // int로 변환한 그리드 0 = "S", 1 = "L", 2 = "R"
    int n, m;

    int[] dx = new int[]{0,1,0,-1};
    int[] dy = new int[]{1,0,-1,0};

    public int[] solution(String[] grid) {
        n = grid.length;
        m = grid[0].length();

        map = new boolean[n][m][4];
        grid2 = new int[n][m];
        
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Character c = grid[i].charAt(j);
                if (c =='S') {
                    grid2[i][j] = 0; // 그대로
                } else if (c =='L') {
                    grid2[i][j] = -1; // 왼쪽으로 이동
                } else {
                    // R인 경우
                    grid2[i][j] = 1; // 오른쪽으로 이동
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int d = 0; d < 4; d++) {
                    if (!map[i][j][d]) {
                        int len = getCricle(i,j,d);
                        arr.add(len);
                    }
                }
            }
        }
        arr.sort((a,b) -> a-b);
        int[] answer = arr.stream().mapToInt(i -> i).toArray();
        return answer;
    }

    public int getCricle(int x, int y, int d) {

        int originX = x;
        int originY = y;
        int originD = d;

        int len = 1;
        while (true) {

            // 현재 위치에서 해당 방향으로 이동
            int nd = (d + grid2[x][y] + 4) % 4; // 4개 중에 하나로 go
            int nx = dx[nd] + x;
            int ny = dy[nd] + y;

           // 위치 보정하기
           nx = (nx + n) % n; // x위치 보정
           ny = (ny + m) % m; // y위치 보정
            
           if (originX == nx && originY == ny && originD == nd){
                break;
           }

            len ++;
            x = nx;
            y = ny;
            d = nd;
            map[x][y][d] = true;
        }
        
        return len;
    }
}