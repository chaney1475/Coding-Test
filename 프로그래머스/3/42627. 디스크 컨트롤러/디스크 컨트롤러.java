import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        
        int N = jobs.length;
        int sum = 0;
        
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<int[]> q = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) return a[0] - b[0]; // 소요시간
                if (a[1] != b[1]) return a[1] - b[1]; // 요청시간
                return a[2] - b[2]; // 번호
            }
        );
        
        int time = 0;
        int i = 0;
        
        while (i < N || !q.isEmpty()) {
            
            // 현재 시간까지 들어온 작업 큐에 넣기
            while (i < N && jobs[i][0] <= time) {
                q.add(new int[]{jobs[i][1], jobs[i][0], i});
                i++;
            }
            
            if (!q.isEmpty()) {
                int[] cur = q.poll();
                
                int duration = cur[0];
                int request = cur[1];
                
                time += duration;
                sum += time - request;
                
            } else {
                time = jobs[i][0];
            }
        }
        
        return sum / N;
    }
}