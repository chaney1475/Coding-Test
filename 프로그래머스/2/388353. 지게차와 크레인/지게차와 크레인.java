import java.util.*;

class Solution {
    int N, M;
    int[][] grid;
    char[][] str;
    int[] dx = new int[] {0,0,-1,1};
    int[] dy = new int[] {-1,1,0,0};
    
    public int solution(String[] storage, String[] requests) {
        
        
        this.N = storage.length;
        this.M = storage[0].length();
        
        this.str = new char[N][M];
        this.grid = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                str[i][j] = storage[i].charAt(j);
            }
            Arrays.fill(grid[i], 1); // 잇음
        }
        
        boolean[][] visited = new boolean[N][M];
        
        for (int i = 0; i < requests.length; i++) {
            String cur = requests[i];
            char c = cur.charAt(0);
            
            if (cur.length() > 1) {
                removeAll(c);
            } else {
                removeOut(c);
            }
            
        }
        int answer = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                answer += grid[i][j];
            }
        }
        return answer;
    }
    
    public void removeAll(char c) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (str[i][j] == c) {
                    grid[i][j] = 0;
                }
            }
        }
    }
    
    public void removeOut(char c) {
        Deque<int[]> q = new ArrayDeque<>();
        
        // 바깥만 확인하기
        for (int i = 0; i < N; i++) {
            if (grid[i][0] == 0) {
                q.add(new int[] {i, 0});
            }
            if (grid[i][M - 1] == 0) {
                q.add(new int[] {i, M-1});
            }
        }
        
        for (int i = 0; i < M; i++) {
            if (grid[0][i] == 0) {
                q.add(new int[] {0, i});
            }
            if (grid[N-1][i] == 0) {
                q.add(new int[] {N-1, i});
            }
        }
        
        List<int[]> arr = new ArrayList<>();
        
        boolean[][] visited = new boolean[N][M];
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            
            // 특정 위치에 대해서 주변 4개를 확인
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M 
                || visited[nx][ny]) continue;
                
                visited[nx][ny] = true;
                
                if (grid[nx][ny] == 0) {
                    q.add(new int[]{nx, ny});
                    continue;
                }
                
                if (str[nx][ny] == c) {
                    arr.add(new int[]{nx, ny});
                }
            }
        }
        
        // 바깥만 확인하기
        for (int i = 0; i < N; i++) {
            if (str[i][0] == c) {
                grid[i][0] = 0;
            }
            
            if (str[i][M - 1] == c) {
                grid[i][M - 1] = 0;
            }
        }
        
        for (int i = 0; i < M; i++) {
            if (str[0][i] == c) {
                grid[0][i] = 0;
            }
            if (str[N - 1][i] == c) {
                grid[N - 1][i] = 0;
            }
        }
        
        for (int[] a : arr) {
            grid[a[0]][a[1]] = 0;
        }
    }
}