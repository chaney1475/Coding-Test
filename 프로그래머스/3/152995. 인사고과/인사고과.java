import java.util.*;

class Solution {
    public int solution(int[][] scores) {

        int[] wanho = scores[0];
        int wanhoSum = wanho[0] + wanho[1];

        Arrays.sort(scores, (a, b) -> {
            // 첫 점수 내림차순
            if (a[0] == b[0]) {
                // 첫 점수 같으면 두 번째 오름차순
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        int maxSecond = 0;
        int rank = 1;

        for (int[] s : scores) {

            // 인센티브 탈락자
            if (s[1] < maxSecond) {

                // 완호 탈락
                if (s[0] == wanho[0] && s[1] == wanho[1]) {
                    return -1;
                }

                continue;
            }

            maxSecond = Math.max(maxSecond, s[1]);
            if (s[0] + s[1] > wanhoSum) {
                rank++;
            }
        }

        return rank;
    }
}