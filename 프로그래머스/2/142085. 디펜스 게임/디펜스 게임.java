import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> b - a);
        
        for (int i = 0; i < enemy.length; i++){
            n -= enemy[i];
            q.add(enemy[i]); 
            
            if (n < 0){
                if (!q.isEmpty() && k > 0){
                    n += q.poll();
                    k--;
                }else{
                    break;
                }
            }
            answer = i;
        }
        
        return answer + 1;
    }
}