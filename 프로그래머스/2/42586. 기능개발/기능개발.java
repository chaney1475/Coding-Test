import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        int N = progresses.length;
        
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        
        for (int i = 0; i < N; i++){
            int days = (100 - progresses[i] + speeds[i] - 1) / speeds[i];
            dq.add(days);
        }
        
        // System.out.println(dq);
        
        List<Integer> ans = new ArrayList<>();
        
        int cnt = 1;
        int day = dq.poll();
        
        while(!dq.isEmpty()){
            //나올 다음의 값
            int next = dq.peek();
            // 확인해보니 다음날보다 숫자가 크다! 아니면 이게 마지막 숫자임
            if (next > day){
                ans.add(cnt);
                day = next;
                cnt = 1;
            }else{
                cnt++;
            }
            dq.poll();
        }
        ans.add(cnt);
        
        // System.out.println(cnt);
    
        int[] answer = new int[ans.size()];
        int k = 0;
        for (Integer i : ans){
            answer[k++] = i;
        }
        return answer;
    }
}