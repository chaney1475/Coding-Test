import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int N = prices.length;
        
        int[] answer = new int[N];
        ArrayDeque<Integer> q = new ArrayDeque<>(); // 위치를 넣는 덱
        // 나보다 작은거 나올때까지 뽑은다음에 없으면 n-1 있으면 그거의 숫자
        // 얹을때는 큰거만 얹기
        
        q.add(N-1); // 끝에꺼 넣어두기!
        
        for (int i = N-2; i >= 0; i--){
            int now = prices[i];
            
            while(!q.isEmpty() && prices[q.peek()] >= now){
                q.pop();
            }
            
            if (q.isEmpty()){
                answer[i] = N-1;
                q.push(i);
                
            }else{
                answer[i] = q.peek();
                if (prices[q.peek()] < now){
                    q.push(i);
                }
            }
            
        }
        
        for (int i = 0; i < N-1; i++){
            answer[i] = answer[i] - i;
        }
        
        return answer;
    }
}