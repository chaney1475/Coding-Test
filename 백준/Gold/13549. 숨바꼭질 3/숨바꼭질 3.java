import java.util.*;
import java.io.*;

public class Main {

    static class Position {
        int x; // 위치
        int cnt; // 횟수

        Position(int x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 위치 배열
        int[] dp = new int[100001];
        Arrays.fill(dp, Integer.MAX_VALUE);

        // 덱 사용
        Deque<Position> dq = new ArrayDeque<>();
        
        dq.add(new Position(N, 0)); // 초기 위치 및 카운트 추가
        dp[N] = 0;

        while (!dq.isEmpty()) {
            Position now = dq.poll(); // 현재 위치

            if (now.x == K) { 
                break;
            }

            if (now.x * 2 <= 100000 && dp[now.x * 2] > now.cnt) {
                dp[now.x * 2] = now.cnt;
                dq.addFirst(new Position(now.x * 2, now.cnt));
            }

            if (now.x - 1 >= 0 && dp[now.x - 1] > now.cnt + 1) {
                dp[now.x - 1] = now.cnt + 1;
                dq.addLast(new Position(now.x - 1, now.cnt + 1));
            }

            if (now.x + 1 <= 100000 && dp[now.x + 1] > now.cnt + 1) {
                dp[now.x + 1] = now.cnt + 1;
                dq.addLast(new Position(now.x + 1, now.cnt + 1));
            }
        }

        System.out.println(dp[K]);
    }
}
