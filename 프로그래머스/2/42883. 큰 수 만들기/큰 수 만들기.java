import java.util.*;

class Solution {
    
    public String solution(String number, int k) {
        
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        //addLast peekLast pollLast를 통해서 스택처럼 사용하자!
        
        int cnt = k;
        int N = number.length();
        
        for(int i = 0; i < N; i++){
            int now = number.charAt(i) - '0';
            
            while (cnt > 0 && !dq.isEmpty() && dq.peekLast() < now){
                    // 숫자 빼기!
                cnt--;
                dq.pollLast();
            }
            dq.add(now);
        }
        
        StringBuilder sb = new StringBuilder();
        
        int i = 0;
        
        while(!dq.isEmpty()){
            sb.append(dq.pollFirst());
            i++;
            if (i == (N-k)) break;
        }
        
        
        
        return sb.toString();
    }
}