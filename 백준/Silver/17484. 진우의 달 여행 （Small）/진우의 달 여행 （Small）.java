import java.util.*;
import java.io.*;

public class Main {
    
    static int[][] grid;
    static int N, M;
    static int[][][] dp;
    
    static int[] dy = {-1, 0, 1};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        grid = new int[N][M];
        dp = new int[N][M][3]; 
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                Arrays.fill(dp[i][j], Integer.MAX_VALUE); 
            }
        }
        
        // 첫 번째 행 초기화
        for (int j = 0; j < M; j++) {
            for (int d = 0; d < 3; d++) {
                dp[0][j][d] = grid[0][j];
            }
        }
        
        // DP
        for (int x = 0; x < N - 1; x++) {
            for (int y = 0; y < M; y++) {
                for (int d = 0; d < 3; d++) {
                    if (dp[x][y][d] == Integer.MAX_VALUE) continue;

                    // 세 방향으로 이동
                    for (int nd = 0; nd < 3; nd++) {
                        if (d == nd) continue; // 같은 방향 pass
                        int ny = y + dy[nd];
                        if (ny < 0 || ny >= M) continue; // 범위를 벗어나면 무시
                        dp[x + 1][ny][nd] = Math.min(dp[x + 1][ny][nd], dp[x][y][d] + grid[x + 1][ny]);
                    }
                }
            }
        }
        
        // 마지막 행에서 최소 연료 구하기
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < M; j++) {
            for (int d = 0; d < 3; d++) {
                ans = Math.min(ans, dp[N - 1][j][d]);
            }
        }
        
        System.out.println(ans);
    }
}
