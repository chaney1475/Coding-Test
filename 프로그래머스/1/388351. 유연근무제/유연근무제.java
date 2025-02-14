import java.util.*;
/*
출근 희망 시간 + 10분

시간  * 60 + 분 + 10분까지 출근해야함
토요일 일요일의 출근 시간은 의미없음
매일 한번 출근 보든 시각 = 시 * 100 + 분

스케줄에 n명의 출근 희망시간 

[i][d] = 0 - 4 / 5,6 -> 은 안함
[i][0~6] 해당 직원의 출근 날짜

이벤트 시작 요일을 의미하는 정수 
1 월 0 1 2 3 4 / 5 6 / : 0 부터 4
2 화 0 1 2 3 / 4 5 / 6 : 6 부터 3
3 수 0 1 2 / 3 4 / 5 6 : 5 부터 2
4 목 0 1 / 2 3 / 4 5 6 : 4 부터 1
5 금 0 / 1 2 / 3 4 5 6 : 3 부터 0
6 토 / 0 1 / 2 3 4 5 6 : 2 부터 6
7 일 0 / 1 2 3 4 5 / 6 : 1 부터 5

d % 7 = 0 부터 4
(d + (7 - 1)) % 7 = 0부터 4

*/
class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        
        int N = schedules.length;
        int[] limits = new int[N];
        
        for (int i = 0; i < N; i++){
            int h = schedules[i] / 100;
            int m = schedules[i] % 100;
            
            int limit = h * 60 + m + 10;
            limits[i] = limit;
            
        }
        
        int ans = 0;
        for (int i = 0; i < N; i++){
            int cnt = 0;
            System.out.println();
            for (int d = 0; d < 5; d++){
                int idx = (d + 7 - startday + 1) % 7;
                int h = timelogs[i][idx] / 100;
                int m = timelogs[i][idx] % 100;
                if (h * 60 + m <= limits[i]) {
                    cnt++;
                }
            } 
            if (cnt == 5) ans++;
        }
        
        return ans;
    }
}