import java.io.*;
import java.util.*;
 
 
public class Solution {
 
    static int N;
    static int[][] grid;
 
    static List<Integer[]> processor;
    static int procCnt;
    // 프로세서 연결하기
 
    static PriorityQueue<Integer[]> q;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        int T = Integer.parseInt(br.readLine());
 
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
 
            grid = new int[N][N];
 
            processor = new ArrayList<>();
            q = new PriorityQueue<>((a, b) -> {
                if (a[0] != b[0])
                    return b[0] - a[0];
                else {
                    return a[1] - b[1];
                }
            });
            procCnt = 0 ;
             
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                    if (grid[i][j] == 1) {
                        procCnt++;
                        if (i > 0 && j > 0 && i < N-1 && j < N-1 ) {
                            processor.add(new Integer[] { i, j });
                        }
                    }
                }
            }
 
            make(0, grid, procCnt - processor.size(), 0);
             
            Integer[] answer = q.poll();
             
            System.out.printf("#%d %d\n", t, answer[1]);
 
        }
 
    }
 
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
     
    static void make(int cnt, int[][] ori , int success, int total) {
         
        if (cnt == processor.size()) {
            q.add(new Integer[] { success, total });
            return;
        }
 
        // 가지치기 1: 현재까지의 최적 해보다 나쁜 경우
        if (!q.isEmpty() && success + (processor.size() - cnt) < q.peek()[0]) {
            return;
        }
 
        Integer[] nowProc = processor.get(cnt);
         
        int x = nowProc[0];
        int y = nowProc[1];
 
        int[][] next = new int[N][N];
 
        for (int i = 0; i < N; i++) {
            System.arraycopy(ori[i], 0, next[i], 0, N);
        }
 
        for (int d = 0; d < 4; d++) {
            int i = x + dx[d];
            int j = y + dy[d];
            int len = 0;
 
            while (0 <= i && i < N && 0 <= j && j < N && next[i][j] == 0) {
                next[i][j] = 2;
                i += dx[d];
                j += dy[d];
                len++;
            }
 
            if (i < 0 || j < 0 || i >= N || j >= N) { // 가장자리에 도달한 경우
                make(cnt + 1, next, success + 1, total + len);
            }
            // next 원복하기
            for (int k = 0; k < N; k++) {
                System.arraycopy(ori[k], 0, next[k], 0, N);
            }
        }
 
        // 아무것도 안하는 경우
        make (cnt+1, next, success, total);
    }
}