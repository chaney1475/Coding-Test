import java.util.*;

class Solution {

    int answer = 0;

    boolean[] cols;
    boolean[] diag1;
    boolean[] diag2;

    public int solution(int n) {

        cols = new boolean[n];
        diag1 = new boolean[2 * n];
        diag2 = new boolean[2 * n];

        backtrack(0, n);

        return answer;
    }

    void backtrack(int row, int n) {

        // 모든 행에 퀸 배치 완료
        if (row == n) {
            answer++;
            return;
        }

        // 현재 행에서 가능한 열 탐색
        for (int col = 0; col < n; col++) {

            int d1 = row - col + n;
            int d2 = row + col;

            // 이미 사용 중인 열 or 대각선
            if (cols[col] || diag1[d1] || diag2[d2]) {
                continue;
            }

            // 퀸 배치
            cols[col] = true;
            diag1[d1] = true;
            diag2[d2] = true;

            backtrack(row + 1, n);

            // 원상복구 (백트래킹)
            cols[col] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }
    }
}