import java.util.*;

class Solution {
    public int solution(int[] elements) {
        
        boolean[] num = new boolean[1000001];
        
        int ans = 0;
        int N = elements.length;
        for (int i = 1; i <= N; i++){
            // i의 길이!
            for (int j = 0; j < N; j++){
                int tmp = 0;
                for (int k = j; k < i + j; k++){
                    tmp += elements[k % N];
                }
                if (!num[tmp]){
                    ans ++;
                    num[tmp] = true;
                }
            }
        }
        
        return ans;
    }
}