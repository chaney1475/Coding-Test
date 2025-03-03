import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        int[] alp = new int[26];
        
        Arrays.fill(alp, -1);
        
        int N = s.length();
        int[] answer = new int[N];
        
        for (int i = 0; i < N; i++){
            int now = s.charAt(i) - 'a';
            if(alp[now] == -1){
                answer[i] = -1;
            }else{
                answer[i] = i - alp[now];
            }
            alp[now] = i;
        }
        
        
        return answer;
    }
}