import java.util.*;

// 큰거 만나면 무조건 이전꺼 정리
// 작은거 만나면 넘어가기

class Solution {
    public int[] solution(int[] progress, int[] speeds) {
        
        int N = progress.length;
        
        int[] days = new int[N];
        
        for (int i = 0; i < N; i++){
            days[i] = ((100 - progress[i]) + speeds[i] - 1) / speeds[i];
        }
        
        List<Integer> ans = new ArrayList<>();
        
        int max = days[0];
        int cnt = 1;
        
        for (int i = 1; i < N; i++){
            
            if (max < days[i]){
                ans.add(cnt);
                max = days[i];
                cnt = 1;
            } else{
                cnt++;
            }
            
            if (i == N - 1){
                ans.add(cnt);
                break;
            }
        }
        
        // System.out.println(Arrays.toString(days));
        
        int[] answer = new int[ans.size()];
        
        for (int i = 0; i < ans.size(); i++){
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
}