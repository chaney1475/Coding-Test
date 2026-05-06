import java.util.*;
// 투포인터
class Solution {
    public int[] solution(int[] sequence, int k) {
        int s = 0;
        int e = 0;
        
        // s로 시작 e는 포함 안함
        int[] answer = new int[2];
        
        int len = 1000001;
        int sum = 0;
        
        int N = sequence.length;
        
        for (int i = 0; i < N; i++) {
            sum += sequence[i];
            
            while(sum > k && s <= i) {
                sum -= sequence[s++];
            }
            
            if (sum == k && (len > i - s)) {
                    answer[0] = s;
                    answer[1] = i;
                    len = i - s;
            }
        }
        
        return answer;
    }
}