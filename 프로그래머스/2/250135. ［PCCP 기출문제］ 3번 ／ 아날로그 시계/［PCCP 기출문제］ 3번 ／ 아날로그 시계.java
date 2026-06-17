import java.util.*;

class Solution {

    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int start = toSecond(h1, m1, s1);
        int end = toSecond(h2, m2, s2);

        int answer = countUntil(end) - countUntil(start);

        // 시작 시간이 이미 겹쳐 있는 순간이면 포함해야 함
        if (isOverlap(start)) {
            answer++;
        }

        return answer;
    }

    private int toSecond(int h, int m, int s) {
        return h * 3600 + m * 60 + s;
    }

    // 0시 0분 0초 이후부터 t초까지의 겹침 횟수
    // 단, t=0 자체는 포함하지 않는 방식
    private int countUntil(int t) {
        int secondMinute = t * 59 / 3600;
        int secondHour = t * 719 / 43200;

        // 12시간마다 초침/분침/시침이 동시에 겹침
        // 이때 초-분, 초-시를 각각 세면 중복이므로 한 번 제거
        int duplicated = t / 43200;

        return secondMinute + secondHour - duplicated;
    }

    // 특정 시각 t초에 초침이 분침 또는 시침과 정확히 겹치는지
    private boolean isOverlap(int t) {
        boolean overlapMinute = (t * 59) % 3600 == 0;
        boolean overlapHour = (t * 719) % 43200 == 0;

        return overlapMinute || overlapHour;
    }
}