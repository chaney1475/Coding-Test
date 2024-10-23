import java.util.*;

class Solution {
    static int[] last;
    public int solution(int n, int K, int[] enemy) {
        int ans = 0;
        int N = enemy.length;
        
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> b-a);
        int left = n; // 나의 병사수
        int last = -1; // 마지막 위치
        
        //내가 사용한 애들을 큐에 넣어서 K에 사용할 걸 찾기
        
        for (int i = 0; i < N; i++){
            int now = enemy[i]; //현재 빼야하는 수
            
            if (left >= now){
                left -= now;
                last = i;
                q.add(now);
            }else{
                if (K == 0) {
                    break;
                }
                if (!q.isEmpty() && q.peek() > now && q.peek() + left >= now){
                    left += q.poll();
                    left -= now;
                    last = i;
                    K--;
                    q.add(now);
                }else{
                     last = i;
                     K--;
                        
                }
            }
            
        }
        
        return last + 1;
    }
    
    
}