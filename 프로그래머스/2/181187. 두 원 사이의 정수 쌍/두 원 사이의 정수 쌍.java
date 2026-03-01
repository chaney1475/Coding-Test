import java.util.*;

class Solution {
    public long solution(int r1, int r2) {

        long answer = 0;

        long r2Sq = (long) r2 * r2;
        long r1Sq = (long) r1 * r1;

        for (long x = 1; x <= r2; x++) {

            long maxY = (long) Math.sqrt(r2Sq - x * x);

            long minY = 0;

            if (r1Sq - x * x > 0) {
                minY = (long) Math.ceil(Math.sqrt(r1Sq - x * x));
            }

            answer += (maxY - minY + 1);
        }

        return answer * 4;
    }
}