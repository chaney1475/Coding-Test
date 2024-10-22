import java.util.*;

class Solution {
    
    public int solution(int[] cards) {
        int N = cards.length;
        
        List<Integer> list = new ArrayList<>();
        
        boolean[] visited = new boolean[N];
        
        for (int i = 0; i < N; i++){
            int now = cards[i] - 1;
            int cnt = 0;
            
            while (! visited[now]){
                visited[now] = true;
                cnt++;
                now = cards[now] - 1;
            }
            if (cnt != 0){
                list.add(cnt);
            }
        }
        Collections.sort(list, (a,b) -> Integer.compare(b,a));
        if (list.size() > 1){
            
            return list.get(0) * list.get(1);
        }
        return 0;
    }
    
    
}