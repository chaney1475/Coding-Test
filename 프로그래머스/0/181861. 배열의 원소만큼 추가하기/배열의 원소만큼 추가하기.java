import java.util.ArrayList;
import java.util.List;
class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        
        // arr의 각 원소를 처리
        for (int n : arr) {
            // n이 양의 정수이므로, n번 반복하여 n을 list에 추가
            for (int i = 0; i < n; i++) {
                list.add(n);
            }
        }
        
        // List를 배열로 변환
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}