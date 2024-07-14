import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        // delete_list를 HashSet으로 변환하여 빠르게 조회할 수 있도록 합니다.
        
        HashSet<Integer> deleteSet = new HashSet<>();
        for (int num : delete_list) {
            deleteSet.add(num);
        }
        
        // 결과를 저장할 ArrayList를 생성합니다.
        ArrayList<Integer> resultList = new ArrayList<>();
        for (int num : arr) {
            if (!deleteSet.contains(num)) {
                resultList.add(num);
            }
        }
        
        // ArrayList를 int[] 배열로 변환합니다.
        int[] answer = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            answer[i] = resultList.get(i);
        }
        
        return answer;
    }
}