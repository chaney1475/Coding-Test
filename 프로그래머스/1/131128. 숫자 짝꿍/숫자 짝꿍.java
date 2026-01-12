import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        int[] numsX = new int[10];
        int[] numsY = new int[10];
        // 0부터 9까지 저장
        
        for (int i = 0; i < X.length(); i++) {
            numsX[X.charAt(i) - '0']++;
        }
        
        for (int i = 0; i < Y.length(); i++) {
            numsY[Y.charAt(i) - '0']++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        int sum = 0;
        for (int i = 9; i >= 1; i--) {
            int min = Math.min(numsX[i], numsY[i]);
            sum += min;
            if (min > 0) {
                for (int j = 0; j < min; j++) {
                    sb.append(i);
                }
            }
        }
        
        int zeroCnt = Math.min(numsX[0], numsY[0]);
        if (sb.length() > 0) {
            for (int i = 0; i < zeroCnt; i++) {
                sb.append(0);
            }
        } else if ( zeroCnt > 0){
            sb.append(0);
        }
            
        if (sb.length() == 0) {
            sb.append(-1);
        }
        return sb.toString();
    }
}