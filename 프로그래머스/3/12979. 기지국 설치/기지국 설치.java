import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int ans = 0;
        //비어있는 곳을 범위로 나누기
        // 범위는 w * 2 + 1
        
        int end = 1; // 처음으로 범위가 아닌곳을 매번 저장한다
        // 범위인 곳이 나오면 그것의 처음으로 범위가 아닌 값을 넣어준다
        
        for (int i = 0; i < stations.length; i++){
            int now = stations[i];
            if (now - w > end){
                ans += (now - end + w) / (w * 2 + 1);
            }
            end = now + w + 1;
        }
        
        if (end <= n){
            ans += (n - end + 1 + w * 2) / (w * 2 + 1);
        }
        
        return ans;
    }
}