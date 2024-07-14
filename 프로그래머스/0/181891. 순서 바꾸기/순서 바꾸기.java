import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        
        int[] a2 = Arrays.copyOfRange(num_list, 0, n);
        int[] a1 = Arrays.copyOfRange(num_list, n, num_list.length);
        
        // 두 배열을 결합할 새로운 배열을 생성합니다.
        int[] answer = new int[num_list.length];
        
        // a1 배열의 요소들을 answer 배열에 복사합니다.
        System.arraycopy(a1, 0, answer, 0, a1.length);
        
        // a2 배열의 요소들을 answer 배열의 남은 공간에 복사합니다.
        System.arraycopy(a2, 0, answer, a1.length, a2.length);
        
        return answer;
    }
}