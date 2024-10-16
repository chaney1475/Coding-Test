import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        int N = targets.length;
        
        Arrays.sort(targets, (a,b) -> {
           if (a[0] != b[0]){
               return a[0] - b[0];
           } else{
               return a[1] - b[1];
           }
        });
        
        //앞에서부터 읽어서 뒤에 있는 값이 존재하지 않거나 시작 값이 끝값보다 크면 +1
        int start = targets[0][0];
        int end = targets[0][1];
        answer++;
        for (int i = 0; i < N; i++){
            if (i + 1 < N) {
               if( end <= targets[i+1][0]){
                answer++;
                start = targets[i+1][0];
                end = targets[i+1][1];
                }else{
                    end = Math.min(end,targets[i+1][1]);
                }
            }
            
        }
        
        return answer;
    }
}