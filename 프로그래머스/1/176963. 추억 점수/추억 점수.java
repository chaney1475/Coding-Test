import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int P = photo.length;
        int[] answer = new int[photo.length];
        
        Map<String, Integer> score = new HashMap();
        
        int n = name.length;
        for (int i = 0; i < n; i++){
            score.put(name[i], yearning[i]);
        }
        
        int idx = 0;
        for (int i = 0; i < P; i++){
            int sum = 0;
            for (int j = 0; j < photo[i].length; j++){
                sum += score.getOrDefault(photo[i][j], 0);
            }
            answer[idx++] = sum;
        }
        
        return answer;
    }
}